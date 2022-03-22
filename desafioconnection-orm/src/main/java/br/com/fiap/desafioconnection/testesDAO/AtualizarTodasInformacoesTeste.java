package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.domain.Cliente;
import br.com.fiap.desafioconnection.domain.Produto;
import br.com.fiap.desafioconnection.domain.Ticket;

public class AtualizarTodasInformacoesTeste {
	
	public static void main(String[] args) {
		
		EntityManager em = null; 
		
		try {	
			
			  em = Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager(); 
			  
			  
			  Cliente atualizarCliente = em.find(Cliente.class, 1);
			  
			  atualizarCliente.setNmCliente("Antônio Carlos da Silva");
			  atualizarCliente.setNumeroTelefone("11930512543");
			  em.persist(atualizarCliente);
			  
			  Produto atualizarProduto = em.find(Produto.class, 1);
			  atualizarProduto.setNmProduto("Cerveja Baden Baden Gold 600ml");
			  atualizarProduto.setQtProduto(5);
			  atualizarProduto.setVlProduto(12.50f);
			  atualizarProduto.setVlTotal(62.50);
			  em.persist(atualizarProduto);
			  
			  Ticket atualizarTicket = em.find(Ticket.class,1);
			  atualizarTicket.setDtTicket("18/03/2022");
			  em.persist(atualizarTicket);
			   
			  em.getTransaction().begin(); 
			  em.getTransaction().commit();
			  
			  
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally{
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}
}
	
