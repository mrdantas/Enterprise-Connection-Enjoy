package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.domain.Cliente;
import br.com.fiap.desafioconnection.domain.Produto;
import br.com.fiap.desafioconnection.domain.Ticket;

public class InserirTodasOperacoesTeste {
	
	public static void main(String[] args) {
		
		EntityManager em = null; 
		
		try {	
			
			  em = Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager(); 
		
			  em.getTransaction().begin(); 
			  
			  Cliente cliente1 = new Cliente();
			  cliente1.setNmCliente("Antônio Augusto");
			  cliente1.setNumeroTelefone("11930512542");
			  em.persist(cliente1);	
			  
			  Cliente cliente2 = new Cliente();
			  cliente2.setNmCliente("Antônio Augusto");
			  cliente2.setNumeroTelefone("11930512542");
			  em.persist(cliente2);
			  
			  Cliente cliente3 = new Cliente();
			  cliente3.setNmCliente("Antônio Augusto");
			  cliente3.setNumeroTelefone("11930512542");
			  em.persist(cliente3);
			  
			  Cliente cliente4 = new Cliente();
			  cliente4.setNmCliente("Antônio Augusto");
			  cliente4.setNumeroTelefone("11930512542");
			  em.persist(cliente4);
			  

			  Ticket ticket1 = new Ticket();
			  ticket1.setDtTicket("14/03/2022");
			  ticket1.setIdTicketCliente(cliente1);
			  em.persist(ticket1);	
			  
			  Ticket ticket2 = new Ticket();
			  ticket2.setDtTicket("15/03/2022");
			  ticket2.setIdTicketCliente(cliente2);
			  em.persist(ticket2);
			  
			  Ticket ticket3 = new Ticket();
			  ticket3.setDtTicket("16/03/2022");
			  ticket3.setIdTicketCliente(cliente3);
			  em.persist(ticket3);
			  
			  Ticket ticket4 = new Ticket();
			  ticket4.setDtTicket("17/03/2022");
			  ticket4.setIdTicketCliente(cliente4);
			  em.persist(ticket4);
			  
			  
			  Produto produto1 = new Produto();
			  produto1.setNmProduto("Cerveja Heineken 600ml");
			  produto1.setQtProduto(5);
			  produto1.setVlProduto(10.50f);
			  produto1.setVlTotal(105.00f);
			  produto1.setTicket(ticket1);
			  em.persist(produto1);	  	 
			  
			  Produto produto2 = new Produto();
			  produto2.setNmProduto("Cerveja Spaten 600ml");
			  produto2.setQtProduto(14);
			  produto2.setVlProduto(10.20f);
			  produto2.setVlTotal(142.80f);
			  produto2.setTicket(ticket2);
			  em.persist(produto2);	
			  
			  Produto produto3 = new Produto();
			  produto3.setNmProduto("Cerveja Heineken 600ml");
			  produto3.setQtProduto(10);
			  produto3.setVlProduto(10.50f);
			  produto3.setVlTotal(105.00f);
			  produto3.setTicket(ticket3);
			  em.persist(produto3);	
			  
			  Produto produto4 = new Produto();
			  produto4.setNmProduto("Cerveja Heineken 600ml");
			  produto4.setQtProduto(5);
			  produto4.setVlProduto(10.50f);
			  produto4.setVlTotal(105.00f);
			  produto4.setTicket(ticket4);
			  em.persist(produto4);	
			  
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
	
