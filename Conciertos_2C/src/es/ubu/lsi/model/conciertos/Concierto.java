package es.ubu.lsi.model.conciertos;

import java.util.Date;
import java.util.Set;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGrupo")
	private Grupo grupo;
	
	@OneToMany(mappedBy="concierto",cascade=CascadeType.ALL)
	private Set<Compra> compras;
	
	
	public Concierto() {
		
	}
	
	public Concierto(int idConcierto, String nombre, String ciudad, Date fecha, int tickets, float precio, Grupo grupo) {
		this.idConcierto = idConcierto;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.fecha = fecha;
		this.tickets = tickets;
		this.precio = precio;
		this.grupo=grupo;
		
	}
	
	public Set<Compra> getCompras(){
		return this.compras;
	}


}
