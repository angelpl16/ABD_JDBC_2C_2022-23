package es.ubu.lsi.dao.conciertos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.ubu.lsi.dao.GrupoDAO;
import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.conciertos.Grupo;

public class SQLGrupoDAO extends JpaDAO<Grupo, Integer> implements GrupoDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	public SQLGrupoDAO(EntityManager em) {
		super(em);

		emf = Persistence.createEntityManagerFactory("Conciertos");
		this.em = emf.createEntityManager();

	}

	@Override
	public void persist(Grupo entity) {
	//	em.persist(entity);
		super.persist(entity);
	}

	@Override
	public void remove(Grupo entity) {
		super.remove(entity);

	}

	@Override
	public Grupo findById(Integer id) {
		String consultaid = "SELECT e from Grupo e where e.idGrupo = ?1";
		Grupo result = (Grupo) em.createQuery(consultaid).setParameter(1, id).getSingleResult();
		return result;
	}

	
	@Override
	public Set<Grupo> findAll() {
		Set<Grupo> result = new HashSet<Grupo>();
		String consultaid = "SELECT e from Grupo e order by e.idGrupo";
		List<?> resultConsulta = em.createQuery(consultaid).getResultList();
		for (Object linea : resultConsulta) {
			result.add((Grupo) linea);
		}
		return result;
	}

}
