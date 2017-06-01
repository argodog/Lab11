package it.polito.tdp.bar.model;

public class Statistiche {
	
	private int numero_totale_clienti = 0;
	private int numero_clienti_soddisfatti = 0;
	private int numero_clienti_insoddisfatti = 0;
	
	public Statistiche (){
		
	}
	
	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}
	public void setNumero_totale_clienti(int numero_totale_clienti) {
		this.numero_totale_clienti = this.numero_totale_clienti + numero_totale_clienti;
	}
	public int getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}
	public void setNumero_clienti_soddisfatti(int numero_clienti_soddisfatti) {
		this.numero_clienti_soddisfatti = this.numero_clienti_soddisfatti+numero_clienti_soddisfatti;
	}
	public int getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}
	public void setNumero_clienti_insoddisfatti(int numero_clienti_insoddisfatti) {
		this.numero_clienti_insoddisfatti = this.numero_clienti_insoddisfatti+numero_clienti_insoddisfatti;
	}

	@Override
	public String toString() {
		return "Statistiche [numero_totale_clienti=" + numero_totale_clienti + ", numero_clienti_soddisfatti="
				+ numero_clienti_soddisfatti + ", numero_clienti_insoddisfatti=" + numero_clienti_insoddisfatti + "]";
	}
	
	
	
	
	

}
