package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Entrada;
import model.EntradaItem;
import model.enuns.Situacao;
import util.Conexao;

/**
 *
 * @author Celso
 */
public class EntradaDAO {

    private final SimpleDateFormat SDF = new SimpleDateFormat("YYYY-MM-dd");

    public Entrada salvar(Entrada ve) throws Exception {
        EntityManager em = Conexao.getEM();

        try {
            em.getTransaction().begin();
            if (ve.getId() == 0) {
                ve.setVlrtotal(ve.getVlrTotal());
                ve.setSituacao(ve.getSituacao().getId());
                //System.out.println("dao.VendaDAO.salvar()" + ve.getSituacao().getId());
                em.persist(ve);//executa o INSERT

                if (ve.getItens() != null) {
                    for (EntradaItem item : ve.getItens()) {
                        item.setEntrada(ve);
                        item.setVlr_Total(item.getValorTotal());
                        item.setMargem(item.getMargem());
                        item.setVlrvenda(item.getValorVenda());
                        //FAZER ENTRADA ESTOQUE
                        if (ve.getSituacao() == Situacao.FINALIZADA) {
                            ProdutoDAO produtoDAO = new ProdutoDAO();
                            produtoDAO.entrada(em, (long) item.getProduto().getId(), ((double) item.getQuantidade()), (double) item.getQuantidade(), ((double) item.getVlrunitario()), ((double) item.getValorVenda()));
                        }
                        em.persist(item);
                    }
                }
            } else {
                if (!em.contains(ve)) {
                    if (em.find(Entrada.class, ve.getId()) == null) {
                        throw new Exception("Erro ao Atualizar Nota de Entrada.!");
                    }
                }
                ve = em.merge(ve);  //executa o UPDATE      
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return ve;
    }

    public List<Entrada> listarTodos() {
        EntityManager em = Conexao.getEM();
        List<Entrada> listObj = em.createQuery("From Entrada WHERE situacao = '0'").getResultList();
        em.close();

        return listObj;
    }

    public List<Entrada> porProdutoData(Long pro, Date ini, Date fim, Long emp) {
        System.out.println("Entrada dao .:");
        EntityManager em = Conexao.getEM();
        TypedQuery<Entrada> query = em.createQuery("SELECT NEW model.Entrada(a.id, a.fornecedor, a.dataentrada, a.vlrtotal, a.situacao) FROM Entrada a ,EntradaItem b WHERE a.id = b.entrada AND b.produto.id = :pro AND dataentrada BETWEEN '" + SDF.format(ini) + "' AND '" + SDF.format(fim) + "' AND a.empresa.id = :emp", Entrada.class);
        query.setParameter("pro", pro);
        System.out.println("dao.entradaDAO por Produto e Data.:" + ini + " - " + fim);
        query.setParameter("emp", emp);

        List<Entrada> ents = query.getResultList();
        em.close();
        System.out.println("dao.porProdutoData()" + ents);
        return ents;
    }

}
