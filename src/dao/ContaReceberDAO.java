package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.ContaReceber;
import util.Conexao;

/**
 *
 * @author Celso
 */
public class ContaReceberDAO extends GenericoDAO<ContaReceber> {

    public List<ContaReceber> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<ContaReceber> listObj = em.createQuery("FROM ContaReceber WHERE empresa_id = " + emp).getResultList();
        em.close();

        return listObj;
    }

}
