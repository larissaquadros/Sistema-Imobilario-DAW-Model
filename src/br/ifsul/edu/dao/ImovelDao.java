/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.dao;

import br.ifsul.edu.model.Imovel;
import java.io.Serializable;
import java.util.List;import javax.persistence.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Larissa
 */
public class ImovelDao implements Serializable{
    
    private List<Imovel> listarTodos;

    public ImovelDao() {

    }
    
    public void persistir(Imovel objeto) throws Exception {
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
    
    public void merge(Imovel objeto) throws Exception {
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
            Imovel objeto = em.find(Imovel.class, id);
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
    
    public Imovel getObjectById(Integer id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            Imovel obj = em.find(Imovel.class, id);
            obj.getCaracteristicas().size();
            return obj;
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Imovel> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Imovel").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Imovel> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
