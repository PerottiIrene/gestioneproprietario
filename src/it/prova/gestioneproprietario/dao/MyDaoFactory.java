package it.prova.gestioneproprietario.dao;

import it.prova.gestioneproprietario.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietario.dao.automobile.AutomobileDAOImpl;
import it.prova.gestioneproprietario.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietario.dao.proprietario.ProprietarioDAOImpl;

public class MyDaoFactory {
	

	// rendiamo questo factory SINGLETON
	private static AutomobileDAO automobileDAOInstance = null;
	private static ProprietarioDAO proprietarioDAOInstance = null;

	public static AutomobileDAO getAutomobileDAOInstance() {
		if (automobileDAOInstance == null)
			automobileDAOInstance = new AutomobileDAOImpl();
		return automobileDAOInstance;
	}

	public static ProprietarioDAO getProprietarioDAOInstance(){
		if(proprietarioDAOInstance == null)
			proprietarioDAOInstance= new ProprietarioDAOImpl();
		return proprietarioDAOInstance;
	}

}
