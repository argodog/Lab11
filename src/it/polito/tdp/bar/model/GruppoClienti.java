package it.polito.tdp.bar.model;

public class GruppoClienti {
	
	public enum StatoGruppo {ARRIVATO,BANCONE,SEDUTO,GRRR,USCITA};
	
	
	private long durata;
	private int numPersone;
	private float tolleranza;
	private int id;
	private StatoGruppo stato;
	private Tavolo tavoloAssegnato;
	
	static private int idGruppoClienti = 1;
	
	public GruppoClienti() {
		this.id = idGruppoClienti++;
		this.numPersone = (int)(1+Math.random()*10);
		this.durata = (int)(60+Math.random()*60);
		this.tolleranza = (float) (Math.random()*0.9);
		this.stato = StatoGruppo.ARRIVATO;
		
	}
	
	@Override
	public String toString() {
		return "GruppoClienti [id=" + id + ", durata=" + durata + ", numPersone=" + numPersone
				+ ", tolleranza=" + tolleranza + ", stato=" + stato + ", tavoloAssegnato="
				+ tavoloAssegnato + "]";
	}


	public Tavolo getTavoloAssegnato() {
		return tavoloAssegnato;
	}



	public void setTavoloAssegnato(Tavolo tavoloAssegnato) {
		this.tavoloAssegnato = tavoloAssegnato;
	}



	public StatoGruppo getStato() {
		return stato;
	}


	public void setStato(StatoGruppo stato) {
		this.stato = stato;
	}


	public long getDurata() {
		return durata;
	}

	public void setDurata(long durata) {
		this.durata = durata;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
