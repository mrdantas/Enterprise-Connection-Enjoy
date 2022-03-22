package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.desafioconnection.dao.ClienteDAO;


public class DAOClienteExcluirTeste {
	
	public static void main(String[] args) {

	
	EntityManager em = null;

	try {

		em = Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager();

		// estrutura para excluir cliente, mas nesse caso tem FK 
		
		ClienteDAO dao = new ClienteDAO(em);
		dao.excluir(1);	 
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
	
	
