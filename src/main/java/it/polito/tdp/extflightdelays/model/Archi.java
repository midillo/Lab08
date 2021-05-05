package it.polito.tdp.extflightdelays.model;

public class Archi {

	private Airport partenza; 
	private Airport arrivo;
	private double mediaDistanza;

	public Archi(Airport partenza, Airport arrivo, double mediaDistanza) {
		super();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.mediaDistanza = mediaDistanza;
	}

	public Airport getPartenza() {
		return partenza;
	}

	public void setPartenza(Airport partenza) {
		this.partenza = partenza;
	}

	public Airport getArrivo() {
		return arrivo;
	}

	public void setArrivo(Airport arrivo) {
		this.arrivo = arrivo;
	}

	public double getMediaDistanza() {
		return mediaDistanza;
	}

	public void setMediaDistanza(double mediaDistanza) {
		this.mediaDistanza = mediaDistanza;
	}

	@Override
	public String toString() {
		return "[" + partenza.getAirportName() + " - "+ arrivo.getAirportName() + " - distanza = " + mediaDistanza + "]\n";
	}
	
}
