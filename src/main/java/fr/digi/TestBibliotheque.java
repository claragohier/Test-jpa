package fr.digi;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBibliotheque {

	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("test-jpa");
			em = emf.createEntityManager();

			Emprunt emp = em.find(Emprunt.class, 1);
			System.out.println(emp.getLivres());
			
			Client cli = em.find(Client.class, 1);
			Set<Emprunt> emps = cli.getEmprunts();
			for(Emprunt empr : emps) {
				System.out.println(empr.getLivres());
			}

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}

	}

}
