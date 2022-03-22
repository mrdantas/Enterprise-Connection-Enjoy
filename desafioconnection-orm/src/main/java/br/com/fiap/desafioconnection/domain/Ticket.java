package br.com.fiap.desafioconnection.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_ticket")
public class Ticket {
	
	
	@Id
	@SequenceGenerator(name = "ticket", sequenceName = "sq_t_ticket", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket")
	@Column(name = "id_ticket", nullable = false, length = 10)
	int idTicket;
	
	@Column(name = "dt_ticket", nullable = false)
	String dtTicket;

	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente idTicketCliente;

	@OneToMany(mappedBy = "ticket")
	private Collection<Produto> produtos;

	public Ticket() {
		super();
	}

	public Ticket(int idTicket, String dtTicket, Cliente idTicketCliente, Collection<Produto> produtos) {
		super();
		this.idTicket = idTicket;
		this.dtTicket = dtTicket;
		this.idTicketCliente = idTicketCliente;
		this.produtos = produtos;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getDtTicket() {
		return dtTicket;
	}

	public void setDtTicket(String dtTicket) {
		this.dtTicket = dtTicket;
	}

	public Cliente getIdTicketCliente() {
		return idTicketCliente;
	}

	public void setIdTicketCliente(Cliente idTicketCliente) {
		this.idTicketCliente = idTicketCliente;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

}