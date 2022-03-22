package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.dao.ClienteDAO;
import br.com.fiap.desafioconnection.domain.Cliente;


public class DAOClienteConsultarTeste {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager();

			ClienteDAO dao = new ClienteDAO(em);
			Cliente cliente = dao.buscar(1);
			
			if (cliente == null) {
				System.out.println("Não existe cliente para a chave 1");
			} else {
				System.out.println("\n\n\n");
				System.out.println(" > " + cliente.getIdCliente() + " - " + cliente.getNmCliente());
				System.out.println("\n\n\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}

}

