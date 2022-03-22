package br.com.fiap.desafioconnection.testesDAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.dao.ProdutoDAO;
import br.com.fiap.desafioconnection.domain.Produto;


public class DAOBebidaFavorita {
	

public static void main(String[] args) {

		
	try {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("desafioconnection-orm");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();  
		
		ProdutoDAO dao = new ProdutoDAO(em);
		
		List <Produto> lstProd = dao.bebidaFavorita();
		
		Iterator iterator = lstProd.iterator();
		
		while(iterator.hasNext()){
			Object[] obj = (Object[]) iterator.next();
			String qtProd = String.valueOf(obj[0]);
			String nmProd = String.valueOf(obj[1]);
			System.out.println("");
			System.out.println("----- Bebida Favorita do Usuario -----");
			System.out.println("Nome do Produto: "+ nmProd + "\nQuantidade de Produto: " + qtProd);
			System.out.println("");
 		}
		
		

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
