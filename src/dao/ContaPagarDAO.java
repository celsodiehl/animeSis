
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.ContaPagar;
import util.Conexao;

/**
 *
 * @author Celso
 */
public class ContaPagarDAO extends GenericoDAO<ContaPagar> {

    public List<ContaPagar> listarTodos() {
        EntityManager em = Conexao.getEM();
        List<ContaPagar> listObj = em.createQuery("From ContaPagar c").getResultList();
        em.close();

        return listObj;
    }
    
}
