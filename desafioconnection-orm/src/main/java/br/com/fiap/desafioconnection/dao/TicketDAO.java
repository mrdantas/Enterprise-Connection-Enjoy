package br.com.fiap.desafioconnection.dao;



import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.desafioconnection.domain.Ticket;


public class TicketDAO extends GenericDAO<Ticket, String> {

	public TicketDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> listarTodosPedidos(int id) {
		String jpqlQuery = "select idTicket from Ticket";
		return this.em.createQuery(jpqlQuery).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> listarPedidoPorId(int id) {
		String jpqlQuery = "select idTicket from Ticket where idTicket = :id";
		return this.em.createQuery(jpqlQuery).setParameter("id", id).getResultList();
	}

}


