package fr.digi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class TestJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = emf.createEntityManager();
		
		Livre livre = em.find(Livre.class, 2);
		if(livre != null) {
			 System.out.println(livre.getAuteur() + " " + livre.getTitre());
		}
		
        em.getTransaction().begin();
		Livre l = new Livre();
		l.setAuteur("Edmond Rostand");
		l.setTitre("Cyrano de Bergerac");
		em.persist(l);
		
		Livre updateLivre = em.find(Livre.class, 5);
		if(updateLivre != null) {
			updateLivre.setTitre("Du plaisir dans la cuisine");
		}
		
		Livre deleteL = em.find(Livre.class, 1);
		if(deleteL != null) {
			em.remove(deleteL);
		}
		
        em.getTransaction().commit();
        
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre = 'Germinal'", Livre.class);
        Livre l2 = query.getResultList().get(0);
        System.out.println(l2.toString());
		
        TypedQuery<Livre> query2 = em.createQuery("SELECT l FROM Livre l WHERE l.auteur = 'Gaston Pouet'", Livre.class);
        Livre l3 = query2.getResultList().get(0);
        System.out.println(l3.toString());

        TypedQuery<Livre> query3 = em.createQuery("SELECT l FROM Livre l", Livre.class);
        List<Livre> listeLivres = new ArrayList<>();
        listeLivres = query3.getResultList();
        
        for(Livre livre1 : listeLivres) {
        	System.out.println(livre1.toString());
        }
        
//		System.out.println(em);
		em.close();
		emf.close();
	}

}
