package es.ubu.lsi.model.conciertos;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Grupo")
public class Grupo {

	@Id
	@Column(name="idGrupo")
	private int idGrupo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="estilo")
	private String estilo;
	@Column(name="activo")
	private int activo;
	
	@OneToMany(mappedBy = "grupo",cascade=CascadeType.ALL)
	private Set<Concierto> conciertos;
	
	public Grupo() {
		
	}
	
	public Grupo(int idGrupo, String nombre, String estilo, int activo) {
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.estilo = estilo;
		this.activo = activo;
	}
	
	public Set<Concierto> getConciertos(){
		return this.conciertos;
	}
	
	public void setConciertos() {
		
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public void setConciertos(Set<Concierto> conciertos) {
		this.conciertos = conciertos;
	}


}
