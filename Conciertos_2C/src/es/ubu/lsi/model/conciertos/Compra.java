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
	@JoinColumn(name="icConcierto")
	private Concierto concierto;
	
	public Compra() {
		
	}
	
	public Compra(int idCompra, int idConcierto, Cliente cliente, int n_tickets) {
		this.idCompra = idCompra;
		this.idConcierto = idConcierto;
		this.cliente = cliente;
		this.n_tickets = n_tickets;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}

	
}
