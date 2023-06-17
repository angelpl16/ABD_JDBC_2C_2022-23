package es.ubu.lsi.model.conciertos;

import javax.persistence.*;

@Entity
@Table(name = "Compra")
public class Compra {
	
	@Id
	@Column(name="idCompra")
	private int idCompra;
//	@Column(name = "idConcierto")
//	private int idConcierto;
//	@Column(name="NIF")
//	private String NIF;
	@Column(name="n_tickets")
	private int n_tickets;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="NIF")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idConcierto")
	private Concierto concierto;
	
	public Compra() {
		
	}
	
	public Compra(int idCompra, Concierto concierto, Cliente cliente, int n_tickets) {
		this.idCompra = idCompra;
		this.concierto = concierto;
		this.cliente = cliente;
		this.n_tickets = n_tickets;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getN_tickets() {
		return n_tickets;
	}

	public void setN_tickets(int n_tickets) {
		this.n_tickets = n_tickets;
	}

	public Concierto getConcierto() {
		return concierto;
	}

	public void setConcierto(Concierto concierto) {
		this.concierto = concierto;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
