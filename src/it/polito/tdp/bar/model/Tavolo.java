package it.polito.tdp.bar.model;

public class Tavolo {
	
	static private int totaleTavoli = 1;
	private int numPosti = 0;
	private int idGruppo;
	private int idTavolo;
	private boolean libero;
	
	public Tavolo(int numPosti){
		this.libero=true;
		idTavolo = totaleTavoli++;
		this.numPosti = numPosti;
		this.idGruppo = -1;
	}
	
	

	@Override
	public String toString() {
		return "Tavolo [numPosti=" + numPosti + ", idGruppo=" + idGruppo + ", idTavolo=" + idTavolo + ", libero="
				+ libero + "]";
	}



	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public int getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(int idGruppo) {
		this.idGruppo = idGruppo;
	}

	public int getIdTavolo() {
		return idTavolo;
	}

	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	
	

}
