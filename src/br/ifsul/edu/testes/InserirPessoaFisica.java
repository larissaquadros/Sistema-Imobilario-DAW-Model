/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.testes;

import br.ifsul.edu.model.Cidade;
import br.ifsul.edu.model.PessoaFisica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Larissa
 */
public class InserirPessoaFisica {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Trabalho-DAW-2-Etapa-ModelPU");
            em = emf.createEntityManager();
            PessoaFisica obj = new PessoaFisica();
            obj.setNome("Larissa de Quadros");
            obj.setNascimento(Calendar.getInstance());
            obj.setRg("1109131696");
            obj.setCpf("022.328.330-46");
            obj.setPassaporte("123456789");
            obj.setCidade(em.find(Cidade.class, 1));
            obj.setBairro("Centro");
            obj.setEndereco("Avendida Brasil Leste - 544");
            obj.setComplemento("AP 23");
            obj.setEmail("larissaquadros@outlook.com");
            obj.setTelefone("(54)9192-0200");
            em.getTransaction().begin();            
            em.persist(obj); // insert
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
