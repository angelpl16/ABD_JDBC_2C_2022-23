package es.ubu.lsi.dao.conciertos;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.ubu.lsi.dao.ClienteDAO;
import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.conciertos.Cliente;


public class SQLClienteDAO extends JpaDAO<Cliente, String> implements ClienteDAO {

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public SQLClienteDAO(EntityManager em) {
		super(em);
		
		emf = Persistence.createEntityManagerFactory("Conciertos");
		this.em = emf.createEntityManager();
	}

	@Override
	public void persist(Cliente entity) {
		super.persist(entity);

	}

	@Override
	public void remove(Cliente entity) {
		super.remove(entity);

	}

	@Override
	public Cliente findById(String NIF) {
		String consultaid = "SELECT e from Cliente e where e.NIF = ?1";
		Cliente result = (Cliente) em.createQuery(consultaid).setParameter(1, NIF).getSingleResult();
		return result;
	}

	
	@Override
	public Set<Cliente> findAll() {
		Set<Cliente> result = new HashSet<Cliente>();
		String consultaid = "SELECT e from Cliente e order by e.NIF";
		List<?> resultConsulta = em.createQuery(consultaid).getResultList();
		for (Object linea : resultConsulta) {
			result.add((Cliente) linea);
		}
		return result;
	}

}
