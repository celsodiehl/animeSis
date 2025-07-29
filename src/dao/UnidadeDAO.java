package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Unidade;
import util.Conexao;

/**
 * @author Celso
 */
public class UnidadeDAO extends GenericoDAO<Unidade> {

//    public UnidadeDAO() {
//        super();
//        classePersistente = Unidade.class;
//        ordem = "nome";
//    }

    public List<Unidade> listarTodos(Long emp) {
        EntityManager em = Conexao.getEM();
        List<Unidade> list = em.createQuery("From Unidade WHERE empresa_id = " +emp).getResultList();
        em.close();

        return list;
    }
}
