package br.com.fiap.desafioconnection.testesDAO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.dao.ClienteDAO;
import br.com.fiap.desafioconnection.domain.Cliente;

public class DAOClienteListarTeste {
	public static void main(String[] args) {

		try {

			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("desafioconnection-orm");
			EntityManager em = fabrica.createEntityManager();

			em.getTransaction().begin();

			ClienteDAO dao = new ClienteDAO(em);
			
			// teste listar primeiro cliente

			List<Cliente> lstCliente = dao.listarPrimeiroCliente();

			Iterator iterator = lstCliente.iterator();

			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				String idCliente = String.valueOf(obj[0]);
				String nmCliente = String.valueOf(obj[1]);
				System.out.println("\n\n\n");
				System.out.println("Id Cliente: " + idCliente + "\nNome do Cliente: " + nmCliente);
				System.out.println("\n\n\n");
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
