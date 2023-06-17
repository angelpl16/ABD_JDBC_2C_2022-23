package es.ubu.lsi.dao.conciertos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.ubu.lsi.dao.CompraDAO;
import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.conciertos.Compra;


public class SQLCompraDAO extends JpaDAO<Compra, Integer> implements CompraDAO {

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public SQLCompraDAO(EntityManager em) {
		super(em);
		
		emf = Persistence.createEntityManagerFactory("Conciertos");
		this.em = emf.createEntityManager();
	}

	@Override
	public void persist(Compra entity) {
		super.persist(entity);

	}

	@Override
	public void remove(Compra entity) {
		super.persist(entity);

	}

	@Override
	public Compra findById(Integer id) {
		String consultaid = "SELECT e from Compra e where e.idCompra = ?1";
		Compra result = (Compra) em.createQuery(consultaid).setParameter(1, id).getSingleResult();
		return result;
	}


	@Override
	public Set<Compra> findAll() {
		Set<Compra> result = new HashSet<Compra>();
		String consultaid = "SELECT e from Compra e order by e.idCompra";
		List<?> resultConsulta = em.createQuery(consultaid).getResultList();
		for (Object linea : resultConsulta) {
			result.add((Compra) linea);
		}
		return result;
	}

}
