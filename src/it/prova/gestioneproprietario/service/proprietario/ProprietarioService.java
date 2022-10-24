package it.prova.gestioneproprietario.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietario.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietario.model.Proprietario;

public interface ProprietarioService {
	
	//per injection
		public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);
		
		public List<Proprietario> list() throws Exception ;
		
		public Proprietario get(Long id) throws Exception;
		
		public void update(Proprietario proprietarioInstance) throws Exception;
		
		public void insert(Proprietario proprietarioInstance) throws Exception;
		
		public void delete(Proprietario proprietarioInstance) throws Exception ;

}
