package es.ubu.lsi.service.conciertos;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.ubu.lsi.model.conciertos.*;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.PersistenceService;
import es.ubu.lsi.dao.*;
import es.ubu.lsi.dao.conciertos.SQLClienteDAO;
import es.ubu.lsi.dao.conciertos.SQLConciertoDAO;

public class ServiceImpl extends PersistenceService implements Service {

	private static EntityManager em;

	private static EntityManagerFactory emf;

	private static EntityTransaction et;

	@Override
	public void comprar(Date fecha, String nif, int grupo, int tickets) throws PersistenceException {
		emf = Persistence.createEntityManagerFactory("Conciertos");

		em = emf.createEntityManager();

		et = em.getTransaction();
		et.begin();

		SQLClienteDAO cliente = new SQLClienteDAO(em);

		try {

			// Comprobar que hay tickets para ese concierto

			String comprobarEntradas = "SELECT e.tickets FROM concierto e where e.fecha = ?1 and e.idGrupo = ?2";

			int entradasDisponibles = (int) em.createQuery(comprobarEntradas).setParameter(1, fecha)
					.setParameter(2, grupo).getSingleResult();

			if (entradasDisponibles < tickets) {
				throw new PersistenceException("No hay entradas disponibles");
			}

			int maxIDCompra = obtenerUltimoIDCompra(em);

			maxIDCompra++;

			Compra compra = new Compra();
			compra.setIdCompra(maxIDCompra);
			compra.setConcierto(obtenerConcierto(em, grupo, fecha));
			compra.setCliente(cliente.findById(nif));
			compra.setN_tickets(tickets);
			em.persist(compra);

			restarTicketsComprados(em, grupo, fecha, tickets);

		} catch (Exception e) {

			System.out.println("Se produjo un problema durante el proceso de compra");

		}
	}

	@Override
	public void eliminarCliente(String nif) throws PersistenceException {

	}

	@Override
	public Set<Grupo> consultarGrupos() throws PersistenceException {
		Set<Grupo> resultado = new HashSet<Grupo>();
		
		emf = Persistence.createEntityManagerFactory("Conciertos");

		em = emf.createEntityManager();

		et = em.getTransaction();
		et.begin();

		String consulta = "SELECT * FROM Grupo JOIN FETCH g.conciertos c JOIN FETCH c.compras co JOIN FETCH co.cliente";
		List<?> gruposList = em.createQuery(consulta).getResultList(); 
		
		for (Object resValue : gruposList) {
			resultado.add((Grupo) resValue);
		}
		
		return resultado;
	}

	private int obtenerUltimoIDCompra(EntityManager em) {
		String consulta = "SELECT MAX(e.idCompra) FROM Compra e";
		int maxID = (int) em.createQuery(consulta).getSingleResult();
		return maxID;
	}

	private Concierto obtenerConcierto(EntityManager em, int grupo, Date fecha) {
		String consulta = "SELECT e.idConcierto FROM concierto e where e.idGrupo = ?1 and e.fecha = ?2";
		Concierto resultado = (Concierto) em.createQuery(consulta).setParameter(1, grupo).setParameter(2, fecha)
				.getSingleResult();
		return resultado;
	}

	private void restarTicketsComprados(EntityManager em, int grupo, Date fecha, int tickets) {
		String update = "UPDATE Concierto c SET c.ticketsDisponibles = c.ticketsDisponibles - ?1 WHERE c.idGrupo = ?2 and c.fecha = ?3";
		em.createQuery(update).setParameter(1, tickets).setParameter(2, grupo).setParameter(3, fecha);
	}
}
