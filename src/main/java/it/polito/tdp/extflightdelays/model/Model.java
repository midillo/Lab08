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

	public void creaGrafo(int distanza) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		//aggiungo vertici
		Graphs.addAllVertices(this.grafo, idMap.values());

		//aggiungo archi
		List<Archi> archi = dao.getArchi();
		for(Archi a: archi) {
			if(idMap.containsKey(a.getPartenza()) && idMap.containsKey(a.getArrivo()) && a.getMediaDistanza()<distanza){
				Graphs.addEdge(this.grafo, idMap.get(a.getPartenza()), idMap.get(a.getArrivo()), a.getMediaDistanza());	
			}
		}
	}

	public int numVertici(){
		return this.grafo.vertexSet().size();
	}

	public int numArchi() {
		return this.grafo.edgeSet().size();
	}

	public List<ArcoPesato> elencoArchi(){
		List<ArcoPesato> result = new ArrayList<>();
		for(DefaultWeightedEdge e: this.grafo.edgeSet()) {
			result.add(new ArcoPesato(this.grafo.getEdgeSource(e), this.grafo.getEdgeTarget(e), this.grafo.getEdgeWeight(e)));
		}
		return result;
	}


}
