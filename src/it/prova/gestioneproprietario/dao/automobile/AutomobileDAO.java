package it.prova.gestioneproprietario.dao.automobile;

import java.util.List;

import it.prova.gestioneproprietario.dao.IBaseDAO;
import it.prova.gestioneproprietario.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {
	
	public List<Automobile> listaAutomobiliConErrori() throws Exception;

}
