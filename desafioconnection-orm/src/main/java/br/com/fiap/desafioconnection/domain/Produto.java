package br.com.fiap.desafioconnection.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@SequenceGenerator(name = "produto", sequenceName = "sq_t_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name = "id_produto", nullable = false, length = 10)
	int idProduto;
	
	@Column(name = "nm_produto", nullable = false, length = 30)
	String nmProduto;
	
	@Column(name = "qt_produto", nullable = false, length = 10)
	int qtProduto;
	
	@Column(name = "vl_produto", nullable = false)
	double vlProduto;
	
	@Column(name = "vl_total", nullable = false)
	double vlTotal;

	@ManyToOne
	private Ticket ticket;

	public Produto() {
		super();
	}

	public Produto(int idProduto, String nmProduto, int qtProduto, double vlProduto, double vlTotal, Ticket ticket) {
		super();
		this.idProduto = idProduto;
		this.nmProduto = nmProduto;
		this.qtProduto = qtProduto;
		this.vlProduto = vlProduto;
		this.vlTotal = vlTotal;
		this.ticket = ticket;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public int getQtProduto() {
		return qtProduto;
	}

	public void setQtProduto(int qtProduto) {
		this.qtProduto = qtProduto;
	}

	public double getVlProduto() {
		return vlProduto;
	}

	public void setVlProduto(double vlProduto) {
		this.vlProduto = vlProduto;
	}

	public double getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(double vlTotal) {
		this.vlTotal = vlTotal;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}