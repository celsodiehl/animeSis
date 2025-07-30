package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Fornecedor;
import util.Conexao;

/**
 *
 * @author Celso
 */
public class FornecedorDAO extends GenericoDAO<Fornecedor> {

    public List<Fornecedor> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Fornecedor> obj = em.createQuery("FROM Fornecedor WHERE empresa_id = " + emp + " ORDER BY nome").getResultList();
        em.close();

        return obj;
    }

}
