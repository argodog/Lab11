package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;
import it.polito.tdp.bar.model.GruppoClienti.StatoGruppo;

public class Simulator {
	
	//Parametri di simulazione
	private Map <Tavolo, Integer> tavoli;
	
	
	//Modello del mondo
	
	//private PriorityQueue <GruppoClienti> clienti; 
	private int tavoliOccupati = 0;
	
	
	//Statistiche
	Statistiche stats;
	
	//Lista degli eventi
	private PriorityQueue <Event> queue;
	
	public Simulator (Map <Tavolo,Integer> tavoli){
		this.queue = new PriorityQueue<Event>();
		this.tavoli = tavoli;
		this.stats = new Statistiche();
		//this.clienti = new PriorityQueue<GruppoClienti>();
		
	}
	
	public void addGruppoClienti (GruppoClienti gc, int time){
		Event e = new Event (gc, time, EventType.ARRIVO_GRUPPO_CLIENTI);
		queue.add(e);
		
	}
	
	public void run(){
		while (!queue.isEmpty()){
			Event e = queue.poll();
			System.out.println(e);
			
			switch (e.getType()){
			case ARRIVO_GRUPPO_CLIENTI:
				processArrivo(e);
				break;
			case USCITA_GRUPPO_CLIENTI:
				processUscita(e);
				break;
				
			}
		}
	}

	public float getProbabilita(){
		return (float) (Math.random()*0.9);
	}
	
	private void processArrivo(Event e) {
		
		GruppoClienti gc = e.getGruppo();
		
		//arrivati
		//gli devo assegnare un tavolo
		//controllo se c'è un tavolo libero
		
		if (this.cercaTavoloDisponibile(gc)!=null){
			Tavolo t = this.cercaTavoloDisponibile(gc);
			gc.setTavoloAssegnato(t);
			tavoli.remove(t);
			t.setIdGruppo(gc.getId());
			t.setLibero(false);
			gc.setStato(StatoGruppo.SEDUTO);
			this.tavoliOccupati++;
			queue.add(new Event (gc, e.getTime()+gc.getDurata(),EventType.USCITA_GRUPPO_CLIENTI));
			
			
		} else {
			
			if (gc.getTolleranza()<getProbabilita()){
				gc.setStato(StatoGruppo.BANCONE);
				queue.add(new Event(gc,e.getTime()+gc.getDurata(),EventType.USCITA_GRUPPO_CLIENTI));
				
			} else {
				gc.setStato(StatoGruppo.GRRR);
				queue.add(new Event(gc,e.getTime(),EventType.USCITA_GRUPPO_CLIENTI));
				
			}
			
			
		}
					
	}
	
	private void processUscita(Event e) {
		GruppoClienti gc = e.getGruppo();
		switch (gc.getStato()){
		case BANCONE:
			gc.setStato(StatoGruppo.USCITA);
			stats.setNumero_clienti_soddisfatti(gc.getNumPersone());
			stats.setNumero_totale_clienti(gc.getNumPersone());
			break;
			
		case SEDUTO:
			gc.setStato(StatoGruppo.USCITA);
			Tavolo ttemp = gc.getTavoloAssegnato();
			ttemp.setLibero(true);
			ttemp.setIdGruppo(-1);
			this.tavoliOccupati--;
			tavoli.put(ttemp, ttemp.getNumPosti());
			stats.setNumero_clienti_soddisfatti(gc.getNumPersone());
			stats.setNumero_totale_clienti(gc.getNumPersone());
			break;
			
		case GRRR:
			gc.setStato(StatoGruppo.USCITA);
			stats.setNumero_clienti_insoddisfatti(gc.getNumPersone());
			stats.setNumero_totale_clienti(gc.getNumPersone());
			break;
			
		default:
			throw new IllegalArgumentException();
		}
		
	}

	
	
	public Tavolo cercaTavoloDisponibile(GruppoClienti gc){
		
		int numPersone = gc.getNumPersone();
		int postiTavoloMin = Integer.MAX_VALUE;
		Tavolo returnTable = null;

		// Itero su tutti i tavoli
		for (Tavolo tavolo : tavoli.keySet()) {

			// Controllo i requisiti minimi
			if (tavolo.isLibero() && numPersone >= 0.5 * tavolo.getNumPosti() && numPersone<=tavolo.getNumPosti()) {

				// Cerco il tavolo con il minimo numero di posti a sedere.
				if (postiTavoloMin > tavolo.getNumPosti()) {
					returnTable = tavolo;
					postiTavoloMin = tavolo.getNumPosti();
				}
			}
		}

		return returnTable;
	}
		
		

	public Statistiche getStats() {
		return stats;
	}

}
