package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.domain.Cliente;

public class ExcluirClientePorIdTeste {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager();

			em.getTransaction().begin();

			Cliente excluirCliente = em.find(Cliente.class, 1);

			em.remove(excluirCliente);

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}
}