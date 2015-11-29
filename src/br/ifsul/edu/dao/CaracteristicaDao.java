/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.dao;

import br.ifsul.edu.model.Caracteristica;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class CaracteristicaDao implements Serializable{
    
    private List<Caracteristica> listarTodos;

    public CaracteristicaDao() {

    }
    
    public void persistir(Caracteristica objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public void merge(Caracteristica objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }   
    
    public void remover(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            Caracteristica objeto = em.find(Caracteristica.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }      
    
    public Caracteristica getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Caracteristica.class, id);
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Caracteristica> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Caracteristica order by nome").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Caracteristica> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
