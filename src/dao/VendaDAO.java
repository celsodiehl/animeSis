package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Venda;
import model.VendaItem;
import model.enuns.Situacao;
import util.Conexao;

/**
 * @author Celso
 */
public class VendaDAO {

    private final SimpleDateFormat SDF = new SimpleDateFormat("YYYY-MM-dd");

    public Venda salvar(Venda ve) throws Exception {
        EntityManager em = Conexao.getEM();
        try {
            em.getTransaction().begin();
            if (ve.getId() == 0) {
                ve.setVlrsubtotal(ve.getVlrsubtotal());
                ve.setVlrdesconto(ve.getVlrdesconto());
                ve.setVlrtotal(ve.getCalcVlrTotal());
                ve.setSituacao(ve.getSituacao().getId());
                em.persist(ve);//executa o INSERT

                System.out.println("Salvar VENDA.:" + ve.getId());
                if (ve.getItens() != null) {
                    for (VendaItem item : ve.getItens()) {
                        item.setVenda(ve);
                        item.setVlr_total(item.getValorTotal());
                        //FAZ SAIDA ESTOQUE
                        if (ve.getSituacao() == Situacao.FINALIZADA) {
                            ProdutoDAO produtoDAO = new ProdutoDAO();
                            produtoDAO.saida(em, (long) item.getProduto().getId(), ((double) item.getQuantidade()));
                        }
                        em.persist(item);
                    }
                }
            } else {
                //executa o UPDATE
                System.out.println("Atualiza VENDA.:" + ve.getId());
                ve.setVlrsubtotal(ve.getVlrsubtotal());
                ve.setVlrtotal(ve.getCalcVlrTotal());
                ve.setSituacao(ve.getSituacao().getId());
                if (ve.getItens() != null) {
                    for (VendaItem item : ve.getItens()) {
                        item.setVenda(ve);
                        item.setVlr_total(item.getValorTotal());
                        //FAZ SAIDA ESTOQUE
                        if (ve.getSituacao() == Situacao.FINALIZADA) {
                            ProdutoDAO produtoDAO = new ProdutoDAO();
                            produtoDAO.saida(em, (long) item.getProduto().getId(), ((double) item.getQuantidade()));
                        }
                        ve = em.merge(ve);
                        em.merge(item);
                        System.out.println("Atualiza ITENS DA VENDA.:" + ve.getId() + " ITENS.:" + item.getProduto().getId() + "- " + item.getProduto().getDescricao());
                    }
                }
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return ve;
    }

    //USANDO PARA LISTAR TODAS NÃO FINALIZADAS
    public List<Venda> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda WHERE situacao = '0' AND empresa_id = " + emp).getResultList();
        em.close();

        return listObj;
    }

    public List<Venda> listarFinalizadas() {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda v").getResultList();
        em.close();

        return listObj;
    }

    public List<Venda> porCodigo(Long ve) {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda WHERE id = " + ve).getResultList();
        em.close();

        return listObj;
    }

    //USANDO NO REL DE VENDAS
    public List<Venda> porCliente(Long cli, Long emp) {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda WHERE cliente_id = " + cli + " AND empresa_id = " + emp).getResultList();
        em.close();

        return listObj;
    }

    //USANDO NA BUSCA DE PRODUTOPESQUISA.: POR PRODUTO
    public List<Venda> porProduto(Long pro, Long emp) {
        System.out.println("dao 1.:");
        EntityManager em = Conexao.getEM();
        TypedQuery<Venda> query = em.createQuery("SELECT NEW model.Venda(a.id, a.cliente, a.datavenda, a.vlrtotal, a.situacao) FROM Venda a ,VendaItem b WHERE a.id = b.venda AND b.produto.id = :pro AND a.empresa.id = :emp", Venda.class);
        query.setParameter("pro", pro);
        query.setParameter("emp", emp);

        List<Venda> vendas = query.getResultList();
        em.close();
        System.out.println("dao.porProduto()" + vendas);
        return vendas;
    }

    //USANDO NA BUSCA DE PRODUTOPESQUISA.: POR PRODUTO E DATA
    public List<Venda> porProdutoData(Long pro, Date ini, Date fim, Long emp) {
        System.out.println("dao 2.:");
        EntityManager em = Conexao.getEM();
        TypedQuery<Venda> query = em.createQuery("SELECT NEW model.Venda(a.id, a.cliente, a.datavenda, a.vlrtotal, a.situacao) FROM Venda a ,VendaItem b WHERE a.id = b.venda AND b.produto.id = :pro AND datavenda BETWEEN '" + SDF.format(ini) + "' AND '" + SDF.format(fim) + "' AND a.empresa.id = :emp", Venda.class);
        query.setParameter("pro", pro);
        System.out.println("dao.VendaDAO por Produto e Data.:" + ini + " - " + fim);
        query.setParameter("emp", emp);

        List<Venda> vendas = query.getResultList();
        em.close();
        System.out.println("dao.porProdutoData()" + vendas);
        return vendas;
    }

    //USANDO NO RELATORIO DE VENDAS POR DATA
    public List<Venda> porData(Date ini, Date fim, Long emp) {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda WHERE datavenda BETWEEN '" + SDF.format(ini) + "' AND '" + SDF.format(fim) + "' AND empresa_id = " + emp + " AND situacao = '1'").getResultList();
        em.close();

        return listObj;
    }

    //USANDO NO RELATORIO DE VENDAS POR CLIENTE E DATA
    public List<Venda> porClienteData(Long cli, Date ini, Date fim, Long emp) {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda WHERE cliente_id = " + cli + " AND datavenda BETWEEN '" + SDF.format(ini) + "' AND '" + SDF.format(fim) + "' AND empresa_id = " + emp).getResultList();
        em.close();
        System.out.println("REL.: VENDAS.:" + ini + " - " + fim);

        return listObj;
    }

    public List porCodigo(Venda ve) {
        EntityManager em = Conexao.getEM();
        List<Venda> listObj = em.createQuery("FROM Venda WHERE id = " + ve).getResultList();
        em.close();
        return (List) listObj;

    }

}
