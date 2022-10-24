package it.prova.gestioneproprietario.service;

import it.prova.gestioneproprietario.dao.MyDaoFactory;
import it.prova.gestioneproprietario.service.automobile.AutomobileService;
import it.prova.gestioneproprietario.service.automobile.AutomobileServiceImpl;
import it.prova.gestioneproprietario.service.proprietario.ProprietarioService;
import it.prova.gestioneproprietario.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {
	
	// rendiamo le istanze restituite SINGLETON
		private static AutomobileService automobileServiceInstance = null;
		private static ProprietarioService proprietarioServiceInstance = null;

		public static AutomobileService getAutomobileServiceInstance() {
			if (automobileServiceInstance == null) {
				automobileServiceInstance = new AutomobileServiceImpl();
				automobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
			}
			return automobileServiceInstance;
		}

		public static ProprietarioService getProprietarioServiceInstance() {
			if (proprietarioServiceInstance == null) {
				proprietarioServiceInstance = new ProprietarioServiceImpl();
				proprietarioServiceInstance.setProprietarioDAO(MyDaoFactory.getProprietarioDAOInstance());
			}
			return proprietarioServiceInstance;
		}

}
