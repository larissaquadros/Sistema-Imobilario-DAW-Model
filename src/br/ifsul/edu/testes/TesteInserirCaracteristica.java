package br.ifsul.edu.testes;


import br.ifsul.edu.model.Caracteristica;
import br.ifsul.edu.model.Imovel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class TesteInserirCaracteristica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Sistema-Imobiliario-DAW-ModelPU");
            em = emf.createEntityManager();
            Imovel obj = em.find(Imovel.class, 7);
            Caracteristica ca = em.find(Caracteristica.class, 2);
            obj.getCaracteristicas().add(ca);
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
