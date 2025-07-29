package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Entrada;
import model.Produto;
import util.Conexao;

/**
 * @author Celso
 */
public class ProdutoDAO extends GenericoDAO<Produto> {

    public Produto recuperar(Long id) {
        EntityManager em = Conexao.getEM();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);  //executa o SELECT
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Produto> listObj = em.createQuery("FROM Produto WHERE empresa_id = " + emp + " ORDER BY descricao").getResultList();
        em.close();

        return listObj;
    }

    public List<Produto> listarProdutos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Produto> listObj = em.createQuery("FROM Produto p WHERE p.servico = 'N' AND empresa_id = " + emp + " ORDER BY descricao").getResultList();
        em.close();

        return listObj;
    }

    //TESTAR NO PRODUTO DATA ULTIMA COMPRA NAO USEI
    public List<Entrada> porDataMaxima(Long pro, Long emp) {
        System.out.println("entrando dao produto.:");
        EntityManager em = Conexao.getEM();
        TypedQuery<Entrada> query = em.createQuery("SELECT NEW model.Entrada(a.id, a.dataentrada, c.descricao) FROM Entrada a, EntradaItem b WHERE a.id = b.entrada AND b.produto.id = :pro AND MAX(dataentrada) AND a.empresa.id = :emp", Entrada.class);
        query.setParameter("pro", pro);
        System.out.println("dao.ProdutoDAO por Produto e Data.: MAXIMA");
        query.setParameter("emp", emp);

        List<Entrada> vendas = query.getResultList();
        em.close();
        System.out.println("dao.porProdutoData()" + vendas);
        return vendas;
    }
    //SELECT new br.com.EntidadeVO(e1.id, e1.nome, e2.id, e3.nome) FROM Entidade1 e1
    //JOIN e1.entidades2 e2
    //JOIN e2.entidades3 e3

    public void entrada(EntityManager em, long codigo, double quantidade, double qtdultimacompra, double vlrunitario, double vlrvenda) {
        System.out.println("-- Começando UPDATE --");
        Date dataultimacompra = new Date();

        Query query = em.createQuery("UPDATE Produto SET quantidade = quantidade + ?, qtdultimacompra = ?, vlrcusto = ?, vlrvenda = ?, dataultimacompra = ? WHERE id = ?");
        query.setParameter(1, quantidade);
        query.setParameter(2, qtdultimacompra);
        query.setParameter(3, vlrunitario);
        query.setParameter(4, vlrvenda);
        query.setParameter(5, dataultimacompra);
        query.setParameter(6, codigo);
        int rowsUpdated = query.executeUpdate();
        System.out.println("Produto Atualizado: " + rowsUpdated);
    }

    public void saida(EntityManager em, long codigo, double quantidade) {
        System.out.println("-- Começando UPDATE --");

        Query query = em.createQuery("UPDATE Produto SET quantidade = quantidade - ? WHERE id = ?");
        query.setParameter(1, quantidade);
        query.setParameter(2, codigo);
        int rowsUpdated = query.executeUpdate();
        System.out.println("Produto Atualizado: " + rowsUpdated);
    }

}
