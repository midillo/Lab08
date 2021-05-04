package it.polito.tdp.extflightdelays.model;

public class ArcoPesato {

	private Airport edgeSource;
	private Airport edgeTarget;
	private double edgeWeight;

	public ArcoPesato(Airport edgeSource, Airport edgeTarget, double edgeWeight) {
		super();
		this.edgeSource = edgeSource;
		this.edgeTarget = edgeTarget;
		this.edgeWeight = edgeWeight;
	}

	public Airport getEdgeSource() {
		return edgeSource;
	}

	public void setEdgeSource(Airport edgeSource) {
		this.edgeSource = edgeSource;
	}

	public Airport getEdgeTarget() {
		return edgeTarget;
	}

	public void setEdgeTarget(Airport edgeTarget) {
		this.edgeTarget = edgeTarget;
	}

	public double getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(double edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

	@Override
	public String toString() {
		return "Aeroporto di partenza: " +edgeSource+ ",\t aeroporto di arrivo=" +edgeTarget+ ",\tdistanza media in miglia=" +edgeWeight+ "\n";
	}


}
