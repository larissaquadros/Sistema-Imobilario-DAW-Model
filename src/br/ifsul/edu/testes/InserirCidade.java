/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.testes;

import br.ifsul.edu.model.Cidade;
import br.ifsul.edu.model.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class InserirCidade {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Trabalho-DAW-2-Etapa-ModelPU");
            em = emf.createEntityManager();
            Cidade c = new Cidade();
            c.setNome("Passo Fundo");
            Estado e = em.find(Estado.class, 1);
            c.setEstado(e);            
            em.getTransaction().begin();
            em.persist(c); // insert
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }    
}
