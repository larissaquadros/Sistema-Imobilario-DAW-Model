/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.testes;

import br.ifsul.edu.model.Caracteristica;
import br.ifsul.edu.model.Indice;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class InseriCaracteristica {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
            em = emf.createEntityManager();
            Caracteristica i = new Caracteristica();
            i.setNome("Banheiro Social");          
            em.getTransaction().begin();
            em.persist(i); // insert
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
