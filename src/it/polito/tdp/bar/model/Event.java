package it.polito.tdp.bar.model;

public class Event implements Comparable <Event>{
	
	public enum EventType {
		ARRIVO_GRUPPO_CLIENTI,
		USCITA_GRUPPO_CLIENTI
	};
	
	private GruppoClienti gruppo;
	private long time;
	private EventType type;
	
	public Event(GruppoClienti gruppo, long time, EventType type) {
		super();
		this.gruppo=gruppo;
		this.time=time;
		this.type=type;
	}


	@Override
	public int compareTo(Event arg0) {
		
		return (int) (this.time-arg0.time);
	}
	
	@Override
	public String toString() {
		return "Event [gruppo=" + gruppo + ", time=" + time + ", type=" + type + "]";
	}


	public GruppoClienti getGruppo() {
		return gruppo;
	}

	public void setGruppo(GruppoClienti gruppo) {
		this.gruppo = gruppo;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}
	
	

}
