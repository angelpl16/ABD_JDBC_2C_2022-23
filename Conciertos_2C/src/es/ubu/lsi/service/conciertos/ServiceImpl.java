package es.ubu.lsi.service.conciertos;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.ubu.lsi.model.conciertos.Grupo;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.PersistenceService;

public class ServiceImpl extends PersistenceService implements Service {

	
	
	@Override
	public void comprar(Date fecha, String nif, int grupo, int tickets) throws PersistenceException {
		

	}

	@Override
	public void eliminarCliente(String nif) throws PersistenceException {
		
		
	}

	@Override
	public Set<Grupo> consultarGrupos() throws PersistenceException {
		return null;
	}

}
