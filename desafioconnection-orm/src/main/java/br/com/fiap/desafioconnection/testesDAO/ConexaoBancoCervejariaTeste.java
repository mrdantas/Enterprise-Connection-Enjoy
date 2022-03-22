package br.com.fiap.desafioconnection.testesDAO;

import javax.persistence.Persistence;

public class ConexaoBancoCervejariaTeste {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("desafioconnection-orm").createEntityManager();
	}
}