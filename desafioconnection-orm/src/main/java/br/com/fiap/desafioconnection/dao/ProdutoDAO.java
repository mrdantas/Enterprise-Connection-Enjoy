package br.com.fiap.desafioconnection.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.desafioconnection.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Integer> {

	public ProdutoDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> bebidaFavorita() {
		return em.createQuery("Select sum(qtProduto), nmProduto from Produto group by nmProduto order by nmProduto").setMaxResults(1)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutos() {
		String jpqlQuery = "select nmProduto from Produto";
		return this.em.createQuery(jpqlQuery).getResultList();
	}

}