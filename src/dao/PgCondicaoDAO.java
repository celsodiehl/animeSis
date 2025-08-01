package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Empresa;
import model.PgCondicao;
import util.Conexao;

/**
 *
 * @author Celso
 */
public class PgCondicaoDAO extends GenericoDAO<PgCondicao> {

    public List<PgCondicao> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<PgCondicao> listObj = em.createQuery("FROM PgCondicao m WHERE empresa_id = " + emp).getResultList();
        em.close();

        return listObj;
    }

//    public List<PgCondicao> listarTodos(Empresa idEmpresa) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
