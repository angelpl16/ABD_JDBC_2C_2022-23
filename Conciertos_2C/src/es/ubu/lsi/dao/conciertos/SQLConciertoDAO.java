package es.ubu.lsi.dao.conciertos;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.ubu.lsi.dao.ConciertoDAO;
import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.conciertos.Concierto;


public class SQLConciertoDAO extends JpaDAO<Concierto, Integer> implements ConciertoDAO {

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public SQLConciertoDAO(EntityManager em) {
		super(em);
		
		emf = Persistence.createEntityManagerFactory("Conciertos");
		this.em = emf.createEntityManager();
	}

	@Override
	public void persist(Concierto entity) {
		super.persist(entity);

	}

	@Override
	public void remove(Concierto entity) {
		super.remove(entity);

	}

	@Override
	public Concierto findById(Integer id) {
		String consultaid = "SELECT e from Concierto e where e.idConcierto = ?1";
		Concierto result = (Concierto) em.createQuery(consultaid).setParameter(1, id).getSingleResult();
		return result;
	}

	@Override
	public Set<Concierto> findAll() {
		Set<Concierto> result = new HashSet<Concierto>();
		String consultaid = "SELECT e from Grupo e order by e.idGrupo";
		List<?> resultConsulta = em.createQuery(consultaid).getResultList();
		for (Object linea : resultConsulta) {
			result.add((Concierto) linea);
		}
		return result;
	}

}
