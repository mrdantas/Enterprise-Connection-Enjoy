package br.com.fiap.desafioconnection.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@SequenceGenerator(name = "cliente", sequenceName = "sq_t_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name = "id_cliente", nullable = false, length = 10)
	private int idCliente;
	
	@Column(name = "nm_cliente", nullable = false, length = 30)
	private String nmCliente;
	
	@Column(name = "nr_telefone", nullable = false, length = 15)
	private String numeroTelefone;


	@OneToOne(mappedBy = "idTicketCliente")
	private Ticket ticket;


	public Cliente() {
		super();
	}


	public Cliente(int idCliente, String nmCliente, String numeroTelefone, Ticket ticket) {
		super();
		this.idCliente = idCliente;
		this.nmCliente = nmCliente;
		this.numeroTelefone = numeroTelefone;
		this.ticket = ticket;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNmCliente() {
		return nmCliente;
	}


	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}


	public String getNumeroTelefone() {
		return numeroTelefone;
	}


	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}


	