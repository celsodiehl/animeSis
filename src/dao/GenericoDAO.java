package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import model.EntidadeBase;
import util.Conexao;

/**
 * @author Celso
 *///Parâmetro (objeto tipo T que herda de entidade Base
public class GenericoDAO<T extends EntidadeBase> {
    Class<T> typeClass;

    public T salvar(T obj) throws Exception {
        EntityManager em = Conexao.getEM();
        try {
            em.getTransaction().begin();
            if (obj.getId() == 0) {
                em.persist(obj);//executa o INSERT
            } else {
                if (!em.contains(obj)) {
                    if (em.find(obj.getClass(), obj.getId()) == null) {
                        throw new Exception("Erro ao Atualizar Tabela!");
                    }
                }
                obj = em.merge(obj);  //executa o UPDATE      
            }
            //em.getTransaction().rollback();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return obj;
    }

    public void excluir(Class<T> clazz, Long id) {
        EntityManager em = Conexao.getEM();
        T obj = em.find(clazz, id);

        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    //clazz é só pra diferenciar da palavra class reservada
    public T consultarPorId(Class<T> clazz, Long id) {
        EntityManager em = Conexao.getEM();
        T obj = null;

        try {
            obj = em.find(clazz, id);
        } finally {
            em.close();
        }
        return obj;
    }

    //NAO FUNCIONA
    public List<T> findAll() {
        EntityManager em = Conexao.getEM();
        return em.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}
