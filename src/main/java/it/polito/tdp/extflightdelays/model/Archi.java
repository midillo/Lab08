package it.polito.tdp.extflightdelays.model;

public class Archi {

	private Integer partenza; 
	private Integer arrivo;
	private int mediaDistanza;

	public Archi(Integer partenza, Integer arrivo, Integer mediaDistanza) {
		super();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.mediaDistanza = mediaDistanza;
	}

	public Integer getPartenza() {
		return partenza;
	}

	public void setPartenza(Integer partenza) {
		this.partenza = partenza;
	}

	public Integer getArrivo() {
		return arrivo;
	}

	public void setArrivo(Integer arrivo) {
		this.arrivo = arrivo;
	}

	public Integer getMediaDistanza() {
		return mediaDistanza;
	}

	public void setMediaDistanza(Integer mediaDistanza) {
		this.mediaDistanza = mediaDistanza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivo == null) ? 0 : arrivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Archi other = (Archi) obj;
		if (arrivo == null) {
			if (other.arrivo != null)
				return false;
		} else if (!arrivo.equals(other.arrivo))
			return false;
		return true;
	}
}
