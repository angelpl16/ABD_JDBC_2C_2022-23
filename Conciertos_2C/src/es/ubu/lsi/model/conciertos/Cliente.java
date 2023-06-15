package es.ubu.lsi.model.conciertos;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Id
	@Column(name="NIF")
	private String NIF;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="direccion")
	private String direccion;
	@Column(name="cp")
	private String cp;
	@Column(name="ciudad")
	private String ciudad;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private Set<Compra> compras;
	
	public Cliente() {
		
	}
	
	public Cliente(String NIF, String nombre, String apellidos, String direccion, String cp, String ciudad) {
		this.NIF = NIF;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.cp = cp;
		this.ciudad = ciudad;
	}

	

}
