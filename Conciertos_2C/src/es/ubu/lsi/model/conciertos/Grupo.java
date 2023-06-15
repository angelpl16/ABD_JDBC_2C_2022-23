package es.ubu.lsi.model.conciertos;

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
	
	public Grupo() {
		
	}
	
	public Grupo(int idGrupo, String nombre, String estilo, int activo) {
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.estilo = estilo;
		this.activo = activo;
	}


}
