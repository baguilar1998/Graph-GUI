import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;


public class Graph {
	
	private static HashMap<Vertex,HashSet<Edge>> currentGraph;
	private static int numOfEdges,numOfVertexes;
	
	public Graph() {
		currentGraph = new HashMap<Vertex,HashSet<Edge>>();
		numOfEdges = 0;
		numOfVertexes = 0;
	}
	
	public void addVertex(Vertex v) {
		if(!currentGraph.containsKey(v)) {
			currentGraph.put(v, new HashSet<Edge>());
			++numOfVertexes;
		}
	}
	
	public void addEdge(Vertex v1, Vertex v2) {
		currentGraph.get(v1).add(new Edge(v1,v2));
		currentGraph.get(v2).add(new Edge(v2,v1));
		numOfEdges += 2;
	}
	
	public static int getNumOfVertexes() {
		return numOfVertexes;
	}
	
	public static int getNumOfEdges() {
		return numOfEdges/2;
	}
	
	public Vertex findVertex(Point userClick) {
		for(Vertex v: currentGraph.keySet()) {
			
			if(v.getVisualVertex().contains(userClick)) {
				return v;
			}
		}
		return null;
		
	}
	
	public Edge getEdge(Vertex head, Vertex tail) {
		HashSet<Edge> edges = currentGraph.get(head);
		for(Edge e: edges) {
			if(e.getEndpt2().equals(tail))return e;
		}
		return null;
	}
	
	public HashSet<Vertex> getAllVertexes(){
		HashSet<Vertex> vertexes = new HashSet<Vertex>();
		for(Vertex v: currentGraph.keySet()) vertexes.add(v);
		return vertexes;
	}
	
	public HashSet<Edge> getVertexEdges(Vertex vertex){
		return currentGraph.get(vertex);
	}
	

}
