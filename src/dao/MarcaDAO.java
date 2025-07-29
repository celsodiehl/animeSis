package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Marca;
import util.Conexao;

/**
 * @author Celso
 */
public class MarcaDAO extends GenericoDAO<Marca> {

    public List<Marca> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Marca> listObj = em.createQuery("From Marca WHERE empresa_id = " +emp).getResultList();
        em.close();

        return listObj;
    }

}
