package es.ubu.lsi.service.conciertos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.ubu.lsi.model.conciertos.Grupo;
import es.ubu.lsi.service.PersistenceException;

public class ServiceImpl implements Service {

	private static EntityManager entity;
	
	private static EntityManagerFactory emf;
	
	@Override
	public void comprar(Date fecha, String nif, int grupo, int tickets) throws PersistenceException {
		emf = Persistence.createEntityManagerFactory("Conciertos");
		entity = emf.createEntityManager();

	}

	@Override
	public void eliminarCliente(String nif) throws PersistenceException {
		emf = Persistence.createEntityManagerFactory("Conciertos");
		entity = emf.createEntityManager();
		
	}

	@Override
	public List<Grupo> consultarGrupos() throws PersistenceException {
		emf = Persistence.createEntityManagerFactory("Conciertos");
		entity = emf.createEntityManager();
		return null;
	}

}
