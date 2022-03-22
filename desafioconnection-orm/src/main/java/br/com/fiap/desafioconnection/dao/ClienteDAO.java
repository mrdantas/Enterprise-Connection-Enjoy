package br.com.fiap.desafioconnection.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.desafioconnection.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer> {

	public ClienteDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarPrimeiroCliente() {
		return em.createQuery("select idCliente, nmCliente from Cliente").setMaxResults(1).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarOrdenadoNome() {
		return this.em.createQuery("from Cliente order by nmCliente").getResultList();
	}

	
	public void alterarCliente(String nome) {
		em.getTransaction().begin();

		this.em.createQuery("update Cliente c set c.nmCliente = :nome").setParameter("nome", nome).executeUpdate();

		em.getTransaction().commit();

	}

	public void excluirCliente(String nome) {
		em.getTransaction().begin();

		this.em.createQuery("delete from Cliente c where c.nmCliente = :nome").setParameter("nome", nome)
				.executeUpdate();

		em.getTransaction().commit();
	}
}
