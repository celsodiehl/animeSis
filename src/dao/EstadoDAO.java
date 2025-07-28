/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Estado;
import util.Conexao;

public class EstadoDAO {
    
    private EntityManager em = Conexao.getEM();

    public List<Estado> buscarEstado() {
        return em.createQuery("SELECT e FROM  Estado e", Estado.class).getResultList();
    }
    
}
