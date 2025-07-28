
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Cliente;
import util.Conexao;

/**
 * @author Celso
 */
public class ClienteDAO extends GenericoDAO<Cliente> {

  public List<Cliente> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Cliente> listObj = em.createQuery("FROM Cliente WHERE empresa_id = " + emp + " ORDER BY nome").getResultList();
        em.close();

        return listObj;
    }

}