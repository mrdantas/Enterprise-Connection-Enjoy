package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAOConsumoMedio {

public static void main(String[] args) {

		
		try {
			
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("desafioconnection-orm");
			EntityManager em = fabrica.createEntityManager();
			
			em.getTransaction().begin();  
			
			TypedQuery<Double> query = em.createQuery("Select avg(vlTotal) from Produto", Double.class);
			System.out.println("");
			System.out.println("Consumo médio do usuário R$ " + query.getResultList() + " reais.");
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

