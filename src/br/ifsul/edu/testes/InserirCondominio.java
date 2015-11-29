/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.testes;

import br.ifsul.edu.model.Cidade;
import br.ifsul.edu.model.Condominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class InserirCondominio {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
            em = emf.createEntityManager();
            Condominio c = new Condominio();
            c.setNome("Porra do caralho");  
            c.setEndereco("Avenida Brasil");
            c.setReferencia("Próximo ao mercado Zafari");
            c.setBairro("Centro");
            c.setCidade(em.find(Cidade.class, 1));
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
