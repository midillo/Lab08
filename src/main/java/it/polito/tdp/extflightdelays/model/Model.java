package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer, Airport> idMap;
	ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();

	public Model() {
		this.idMap = new HashMap<>();
		dao = new ExtFlightDelaysDAO();
		dao.loadAllAirports(idMap);
	}

	public void creaGrafo(double distanza) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		//aggiungo vertici
		Graphs.addAllVertices(this.grafo, idMap.values());

		//aggiungo archi
		for(Archi a : dao.getArchi(idMap)) {
			if(this.grafo.containsVertex(a.getPartenza()) && this.grafo.containsVertex(a.getArrivo())) {
				if(a.getMediaDistanza()>distanza) {
					DefaultWeightedEdge e = this.grafo.getEdge(a.getPartenza(), a.getArrivo());

					if(e==null) {
						Graphs.addEdgeWithVertices(this.grafo, a.getPartenza(), a.getArrivo(), a.getMediaDistanza());
					}else {
						double distanzaOld = this.grafo.getEdgeWeight(e);
						double distanzaNew = (distanzaOld + a.getMediaDistanza())/2;

						if(distanzaNew>distanza)
							this.grafo.setEdgeWeight(e, distanzaNew);
					}
				}
			}
		}
	}

	public int numVertici(){
		return this.grafo.vertexSet().size();
	}

	public int numArchi() {
		return this.grafo.edgeSet().size();
	}

	public List<Archi> elencoArchi(){
		List<Archi> result = new ArrayList<>();
		for(DefaultWeightedEdge e: this.grafo.edgeSet()) {
			Archi a = new Archi(this.grafo.getEdgeSource(e), this.grafo.getEdgeTarget(e), (float)this.grafo.getEdgeWeight(e));
			result.add(a);
		}
		return result;
	}
}
