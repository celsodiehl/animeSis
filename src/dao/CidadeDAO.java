/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Cidade;
import model.Estado;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.Conexao;

public class CidadeDAO {

    public List<Cidade> buscarCidade(Estado estado) {
        EntityManager em = Conexao.getEM();
        Session sess = em.unwrap(Session.class);
        Criteria crit = sess.createCriteria(Cidade.class);

        if (estado != null) {
            crit.add(Restrictions.eq("estado", estado));
        }
        return crit.list();

    }
}
