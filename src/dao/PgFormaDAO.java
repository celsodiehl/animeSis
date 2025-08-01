/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.PgForma;
import util.Conexao;

/**
 *
 * @author Celso
 */
public class PgFormaDAO extends GenericoDAO<PgForma> {

    public List<PgForma> listarTodos() {
        EntityManager em = Conexao.getEM();
        List<PgForma> lista = em.createQuery("From PgForma m ORDER BY descricao").getResultList();
        em.close();

        return lista;
    }

}
