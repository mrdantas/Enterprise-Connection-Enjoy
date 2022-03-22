package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAOFrequenciaVisita {
	
public static void main(String[] args) {

		
		try {
			
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("desafioconnection-orm");
			EntityManager em = fabrica.createEntityManager();
			
			em.getTransaction().begin();  
			
			TypedQuery<Long> query = em.createQuery("Select count(idTicket) from Ticket", Long.class);
			System.out.println("");
			System.out.println("O usuário frequentou o estabelecimento " + query.getResultList() + " vezes.");
			System.out.println("");


			em.getTransaction().commit();
			em.close();
			fabrica.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
			
		}
	}
}
