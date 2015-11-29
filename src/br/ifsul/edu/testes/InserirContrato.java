/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.testes;

import br.ifsul.edu.model.Cidade;
import br.ifsul.edu.model.Condominio;
import br.ifsul.edu.model.Contrato;
import br.ifsul.edu.model.Imovel;
import br.ifsul.edu.model.Indice;
import br.ifsul.edu.model.Pessoa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class InserirContrato {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
            em = emf.createEntityManager();
            Contrato c = new Contrato(); 
            c.setData_inicio(Calendar.getInstance());
            c.setData_encerramento(Calendar.getInstance());
            c.setImovel(em.find(Imovel.class, 7));
            c.setIndice(em.find(Indice.class, 1));
            c.setLocatario(em.find(Pessoa.class, 1));
            c.setValor_aluguel(400.00);
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
