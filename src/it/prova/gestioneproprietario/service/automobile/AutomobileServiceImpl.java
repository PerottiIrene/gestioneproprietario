package it.prova.gestioneproprietario.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietario.dao.EntityManagerUtil;
import it.prova.gestioneproprietario.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietario.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDAO automobileDAO;

	@Override
	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;

	}

	@Override
	public void insert(Automobile automobileInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.insert(automobileInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Automobile> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void delete(Automobile automobileInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.delete(automobileInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile get(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void update(Automobile automobileInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDAO.update(automobileInstance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public List<Automobile> listaAutomobiliConErrori() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.listaAutomobiliConErrori();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Automobile> listaAutoCodFiscale(String input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDAO.listaAutoCodFiscale(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
}
