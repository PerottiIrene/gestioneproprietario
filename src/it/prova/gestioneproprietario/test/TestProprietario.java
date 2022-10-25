package it.prova.gestioneproprietario.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietario.model.Automobile;
import it.prova.gestioneproprietario.model.Proprietario;
import it.prova.gestioneproprietario.service.MyServiceFactory;
import it.prova.gestioneproprietario.service.automobile.AutomobileService;
import it.prova.gestioneproprietario.service.proprietario.ProprietarioService;

public class TestProprietario {

	public static void main(String[] args) throws Exception {

		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();

		testInserisciAutomobile(automobileService);
		System.out.println("In tabella automobile ci sono " + automobileService.listAll().size() + " elementi.");

		testRimuoviAutomobile(automobileService);
		System.out.println("In tabella automobile ci sono " + automobileService.listAll().size() + " elementi.");

		testAggiornaAutomobile(automobileService);
		System.out.println("In tabella automobile ci sono " + automobileService.listAll().size() + " elementi.");

		testInsertProprietario(proprietarioService);
		System.out.println("In tabella proprietario ci sono " + proprietarioService.list().size() + " elementi.");
		
		testRimuoviProprietario(proprietarioService);
		System.out.println("In tabella proprietario ci sono " + proprietarioService.list().size() + " elementi.");
		
		testUpdateProprietario(proprietarioService);
		System.out.println("In tabella proprietario ci sono " + proprietarioService.list().size() + " elementi.");
		
		contaProprietariConDataImmatricolazioneMaggioreDi(proprietarioService,automobileService);
		System.out.println("In tabella proprietario ci sono " + proprietarioService.list().size() + " elementi.");
		
		testListaAutomobiliConErrori(proprietarioService,automobileService);
		System.out.println("In tabella proprietario ci sono " + proprietarioService.list().size() + " elementi.");
		
		testListaAutoCodFiscale(automobileService,proprietarioService);
	    System.out.println("In tabella proprietario ci sono " + proprietarioService.list().size() + " elementi.");
		
	}

	private static void testInserisciAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println(".......testInserisciAutomobile inizio.............");
		// creo nuovo municipio
		Date dataImmatricolazione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile = new Automobile("audi", "a4", "tdf566", dataImmatricolazione);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile fallito: record già presente ");

		// salvo
		automobileService.insert(nuovaAutomobile);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		System.out.println(".......testInserisciAutomobile fine: PASSED.............");
	}

	private static void testRimuoviAutomobile(AutomobileService automobileService) throws Exception {

		System.out.println(".......testRimozioneAutomobile inizio.............");

		Automobile nuovaAutomobile = automobileService.listAll().get(0);

		automobileService.delete(nuovaAutomobile);

		if (automobileService.get(nuovaAutomobile.getId()) != null)
			throw new RuntimeException("testRimozioneAutomobile fallito: record non cancellato ");
		System.out.println(".......testRimozioneAutomobile fine: PASSED.............");
	}

	private static void testAggiornaAutomobile(AutomobileService automobileService) throws Exception {

		System.out.println(".......testUpdateAutomobile inizio.............");

		Date dataImmatricolazione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile = new Automobile("audi", "a4", "tdf566", dataImmatricolazione);
		automobileService.insert(nuovaAutomobile);

		String nuovoModello = "a5";
		nuovaAutomobile.setModello(nuovoModello);
		automobileService.update(nuovaAutomobile);
		if (!automobileService.get(nuovaAutomobile.getId()).getModello().equals(nuovoModello))
			throw new RuntimeException("testRimozioneAutomobile fallito: record non aggiornato ");

		automobileService.delete(nuovaAutomobile);

		System.out.println(".......testUpdateAutomobile fine: PASSED.............");
	}

	private static void testInsertProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testInserisciProprietario inizio.............");
		// creo nuovo municipio
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Proprietario proprietario1 = new Proprietario("mario", "rossi", "tdf566", dataNascita);
		if (proprietario1.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		// salvo
		proprietarioService.insert(proprietario1);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (proprietario1.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		System.out.println(".......testInserisciProprietario fine: PASSED.............");
	}
	
	private static void testRimuoviProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testRimozioneProprietario inizio.............");

		Proprietario proprietario = proprietarioService.list().get(0);

		proprietarioService.delete(proprietario);

		if (proprietarioService.get(proprietario.getId()) != null)
			throw new RuntimeException("testRimozioneProprietario fallito: record non cancellato ");
		System.out.println(".......testRimozioneProprietario fine: PASSED.............");
		
	}
	
	private static void testUpdateProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testUpdateProprietario inizio.............");

		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Proprietario proprietario = new Proprietario("giuliano", "verdi", "tdf566", dataNascita);
		proprietarioService.insert(proprietario);

		String nuovoNome = "irene";
		proprietario.setNome(nuovoNome);
		proprietarioService.update(proprietario);
		if (!proprietarioService.get(proprietario.getId()).getNome().equals(nuovoNome))
			throw new RuntimeException("testRimozioneProprietario fallito: record non aggiornato ");

		proprietarioService.delete(proprietario);

		System.out.println(".......testUpdateProprietario fine: PASSED.............");
		
	}
	

	private static void contaProprietariConDataImmatricolazioneMaggioreDi(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Proprietario proprietario = new Proprietario("giuliano", "verdi", "tdf566", dataNascita);
		proprietarioService.insert(proprietario);

		Date dataNascita2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Proprietario proprietario2 = new Proprietario("giuliano", "verdi", "tdf566", dataNascita2);
		proprietarioService.insert(proprietario2);
		
		Date dataImmatricolazione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile = new Automobile("audi", "a4", "tdf566", dataImmatricolazione);
		nuovaAutomobile.setProprietario(proprietario);
		automobileService.insert(nuovaAutomobile);
		
		Date dataImmatricolazione2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile2 = new Automobile("audi", "a4", "tdf566", dataImmatricolazione2);
		nuovaAutomobile2.setProprietario(proprietario2);
		automobileService.insert(nuovaAutomobile2);
		
		Date dataInput= new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2015");
		
		
		int quantiProprietariConDataImmatricolazioneMaggioreDi=proprietarioService.contaProprietariConDataImmatricolazioneMaggioreDi(dataInput);
		if(quantiProprietariConDataImmatricolazioneMaggioreDi != 2)
			throw new RuntimeException("counter fallito");
	
		System.out.println("test contaProprietariConDataImmatricolazioneMaggioreDi passed");
		
		automobileService.delete(nuovaAutomobile2);
		automobileService.delete(nuovaAutomobile);
		proprietarioService.delete(proprietario);
		proprietarioService.delete(proprietario2);

	}
	
	public static void testListaAutomobiliConErrori(ProprietarioService proprietarioService,AutomobileService automobileService) throws Exception {
		
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2010");
		Proprietario proprietario = new Proprietario("giuliano", "verdi", "tdf566", dataNascita);
		proprietarioService.insert(proprietario);

		Date dataNascita2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2009");
		Proprietario proprietario2 = new Proprietario("giuliano", "verdi", "tdf566", dataNascita2);
		proprietarioService.insert(proprietario2);
		
		Date dataImmatricolazione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile = new Automobile("audi", "a4", "tdf566", dataImmatricolazione);
		nuovaAutomobile.setProprietario(proprietario);
		automobileService.insert(nuovaAutomobile);
		
		Date dataImmatricolazione2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile2 = new Automobile("audi", "a4", "tdf566", dataImmatricolazione2);
		nuovaAutomobile2.setProprietario(proprietario2);
		automobileService.insert(nuovaAutomobile2);
		
		List<Automobile> listaAutoConErrori=new ArrayList<Automobile>();
		listaAutoConErrori=automobileService.listaAutomobiliConErrori();
		if(listaAutoConErrori.size() != 2)
			throw new RuntimeException("counter fallito");
		
		System.out.println("test listaAutoConErrori passed");
		
		
		automobileService.delete(nuovaAutomobile2);
		automobileService.delete(nuovaAutomobile);
		proprietarioService.delete(proprietario);
		proprietarioService.delete(proprietario2);

	}
	
	public static void testListaAutoCodFiscale(AutomobileService automobileService, ProprietarioService proprietarioService) throws Exception {
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2010");
		Proprietario proprietario = new Proprietario("giuliano", "verdi", "gbr566", dataNascita);
		proprietarioService.insert(proprietario);

		Date dataNascita2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2009");
		Proprietario proprietario2 = new Proprietario("giuliano", "verdi", "tdf566", dataNascita2);
		proprietarioService.insert(proprietario2);
		
		Date dataImmatricolazione = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile = new Automobile("audi", "a4", "tdf566", dataImmatricolazione);
		nuovaAutomobile.setProprietario(proprietario);
		automobileService.insert(nuovaAutomobile);
		
		Date dataImmatricolazione2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2020");
		Automobile nuovaAutomobile2 = new Automobile("audi", "a4", "tdf566", dataImmatricolazione2);
		nuovaAutomobile2.setProprietario(proprietario2);
		automobileService.insert(nuovaAutomobile2);
		
		List<Automobile> listaAuto=new ArrayList<Automobile>();
		listaAuto=automobileService.listaAutoCodFiscale("gb");
		if(listaAuto.size() != 1)
			throw new RuntimeException("test fallito");
		
		System.out.println("test passed");
		
		
		
	}
}
