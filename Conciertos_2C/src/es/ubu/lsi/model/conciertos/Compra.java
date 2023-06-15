package es.ubu.lsi.model.conciertos;

import javax.persistence.*;

@Entity
@Table(name = "Compra")
public class Compra {
	
	@Id
	@Column(name="idCompra")
	private int idCompra;
	@Column(name="idConcierto")
	private int idConcierto;
	@Column(name="NIF")
	private String NIF;
	@Column(name="n_tickets")
	private int n_tickets;
	
	public Compra() {
		
	}
	
	public Compra(int idCompra, int idConcierto, String NIF, int n_tickets) {
		this.idCompra = idCompra;
		this.idConcierto = idConcierto;
		this.NIF = NIF;
		this.n_tickets = n_tickets;
	}

	
}
