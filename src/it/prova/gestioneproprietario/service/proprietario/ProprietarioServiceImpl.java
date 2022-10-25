package it.prova.gestioneproprietario.service.proprietario;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietario.dao.EntityManagerUtil;
import it.prova.gestioneproprietario.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietario.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {

	public ProprietarioDAO proprietarioDAO;

	@Override
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;

	}

	@Override
	public List<Proprietario> list() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return proprietarioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return proprietarioDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void update(Proprietario proprietarioInstance) throws Exception {

		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.update(proprietarioInstance);
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
	public void insert(Proprietario proprietarioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.insert(proprietarioInstance);
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
	public void delete(Proprietario proprietarioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			proprietarioDAO.delete(proprietarioInstance);
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
	public int contaProprietariConDataImmatricolazioneMaggioreDi(Date dataInpt) throws Exception {

		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			proprietarioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return proprietarioDAO.contaProprietariConDataImmatricolazioneMaggioreDi(dataInpt);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

}
