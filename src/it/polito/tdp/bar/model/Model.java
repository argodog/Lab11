package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;

public class Model {
	
	Map <Tavolo, Integer> tavoli = new HashMap <Tavolo, Integer>();
	
	public void addTavolo (Tavolo tavolo){
		tavoli.put(tavolo, tavolo.getNumPosti());
	}

}
