package es.ubu.lsi.model.conciertos;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Concierto")
public class Concierto {
	
	@Id
	@Column(name="idConcierto")
	private int idConcierto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="ciudad")
	private String ciudad;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="tickets")
	private int tickets;
	@Column(name="precio")
	private float precio;
	@Column(name="idGrupo")
	private int idGrupo;
	
	public Concierto() {
		
	}
	
	public Concierto(int idConcierto, String nombre, String ciudad, Date fecha, int tickets, float precio,
			int idGrupo) {
		this.idConcierto = idConcierto;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.fecha = fecha;
		this.tickets = tickets;
		this.precio = precio;
		this.idGrupo = idGrupo;
	}


}
