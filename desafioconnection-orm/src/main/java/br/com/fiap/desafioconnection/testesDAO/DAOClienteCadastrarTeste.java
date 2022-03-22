package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.dao.ClienteDAO;
import br.com.fiap.desafioconnection.domain.Cliente;


public class DAOClienteCadastrarTeste {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager();

			ClienteDAO dao = new ClienteDAO(em);

			Cliente nome = new Cliente(); 
			nome.setNmCliente("Antônio Augusto"); 
			nome.setNumeroTelefone("11930512542");
			dao.cadastrar(nome); 

			dao.commit(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}

}
