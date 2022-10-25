package it.prova.gestioneproprietario.dao.proprietario;

import java.util.Date;

import it.prova.gestioneproprietario.dao.IBaseDAO;
import it.prova.gestioneproprietario.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario>{
	
	public int contaProprietariConDataImmatricolazioneMaggioreDi(Date dataInpt) throws Exception;

}
