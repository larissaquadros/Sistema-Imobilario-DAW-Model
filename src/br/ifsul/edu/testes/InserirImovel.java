/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.testes;

import br.ifsul.edu.model.Caracteristica;
import br.ifsul.edu.model.Cidade;
import br.ifsul.edu.model.Condominio;
import br.ifsul.edu.model.Imovel;
import br.ifsul.edu.model.Indice;
import br.ifsul.edu.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class InserirImovel {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
            em = emf.createEntityManager();
            Imovel i = new Imovel(); 
            i.setEndereco("Avenida Brasil");
            i.setComplemento("Apartamento");
            i.setBairro("Centro");
            i.setCidade(em.find(Cidade.class, 1));
            i.setCondominio(em.find(Condominio.class, 1));
            i.setProprietario(em.find(Pessoa.class, 1));
            i.setOperacao("Venda");
            i.setPreco(20000.00);
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
