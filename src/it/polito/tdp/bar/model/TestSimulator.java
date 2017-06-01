package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;

public class TestSimulator {

	public static void main(String[] args) {
		
		Map <Tavolo, Integer> tavoli = new HashMap <Tavolo, Integer>();
		 
		 tavoli.put(new Tavolo(10),10);
		 tavoli.put(new Tavolo(10),10);
		 tavoli.put(new Tavolo(8),8);
		 tavoli.put(new Tavolo(8),8);
		 tavoli.put(new Tavolo(8),8);
		 tavoli.put(new Tavolo(8),8);
		 tavoli.put(new Tavolo(6),6);
		 tavoli.put(new Tavolo(6),6);
		 tavoli.put(new Tavolo(6),6);
		 tavoli.put(new Tavolo(6),6);
		 tavoli.put(new Tavolo(4),4);
		 tavoli.put(new Tavolo(4),4);
		 tavoli.put(new Tavolo(4),4);
		 tavoli.put(new Tavolo(4),4);
		 tavoli.put(new Tavolo(4),4);
		 
		
		Simulator sim = new Simulator (tavoli);
		
		for (int i=0;i<2000;i++){
			GruppoClienti gc = new GruppoClienti();
			sim.addGruppoClienti(gc, i+(int)(1+Math.random()*10));
		}
		
		sim.run();
		
		System.out.println(sim.getStats().toString());
		
		
	}

}
