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

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	

}
