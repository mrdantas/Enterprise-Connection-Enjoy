package br.com.fiap.desafioconnection.testesDAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




public class DAOUltimaVisita {

	public static void main(String[] args) {

		
		try {
			
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("desafioconnection-orm");
			EntityManager em = fabrica.createEntityManager();
			
			em.getTransaction().begin();  
			
			TypedQuery<String> query = em.createQuery("Select max(dtTicket) from Ticket", String.class);
			System.out.println("");
			System.out.println("Data da última visita: " + query.getResultList());
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
	


			
		

