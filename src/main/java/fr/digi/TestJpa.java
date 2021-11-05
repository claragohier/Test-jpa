package fr.digi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = emf.createEntityManager();
		System.out.println(em);
		em.close();
		emf.close();
	}

}
