package it.prova.gestioneproprietario.service.automobile;

import java.util.List;

import it.prova.gestioneproprietario.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietario.model.Automobile;

public interface AutomobileService {
	
	//per injection
	public void setAutomobileDAO(AutomobileDAO automobileDAO);
	
	public void insert(Automobile automobileInstance) throws Exception ;

	public List<Automobile> listAll() throws Exception;
	
	public void delete(Automobile automobileInstance) throws Exception ;
	
	public Automobile get(Long id) throws Exception ;
	
	public void update(Automobile automobileInstance) throws Exception ;
	
	public List<Automobile> listaAutomobiliConErrori() throws Exception;
	




}
