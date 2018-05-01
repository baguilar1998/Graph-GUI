import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;


public class Graph {
	
	//Instance Variables for a Graph
	private static HashMap<Vertex,HashSet<Edge>> currentGraph;
	private static int numOfEdges,numOfVertexes;
	
	/*
	 * Default Constructor that creates an
	 * empty Graph
	 */
	public Graph() {
		currentGraph = new HashMap<Vertex,HashSet<Edge>>();
		numOfEdges = 0;
		numOfVertexes = 0;
	}
	
	/*
	 * Adds a vertex to the graph
	 * @param v a vertex
	 */
	public void addVertex(Vertex v) {
		if(!currentGraph.containsKey(v)) {
			currentGraph.put(v, new HashSet<Edge>());
			++numOfVertexes;
		}
	}
	
	/*
	 * Adds an edge to a graph that's incidence 
	 * with the given vertices
	 * @param v1 a vertex
	 * @param v2 a vertex
	 */
	public void addEdge(Vertex v1, Vertex v2) {
		if(edgeExists(v1,v2))return;
		currentGraph.get(v1).add(new Edge(v1,v2));
		currentGraph.get(v2).add(new Edge(v2,v1));
		numOfEdges += 2;
	}
	
	/*
	 * @return the number of vertices in the Graph
	 */
	public static int getNumOfVertexes() {
		return numOfVertexes;
	}
	
	/*
	 * @return the number of edges in the Graph
	 */
	public static int getNumOfEdges() {
		return numOfEdges/2;
	}
	
	/*
	 * Finds the vertex that the user clicked on
	 * @param userClick the location of the mouse click
	 * @return v if the user clicked on a vertex from the graph
	 * @return null if the user did not click on the vertex from the graph
	 */
	public Vertex findVertex(Point userClick) {
		for(Vertex v: currentGraph.keySet()) {
			
			if(v.getVisualVertex().contains(userClick)) {
				return v;
			}
		}
		return null;
		
	}
	
	/*
	 * Gets an edge from the graph
	 * @param head the beginning vertex
	 * @param tail the ending vertex
	 * @return e (an edge) if that edge exists
	 * @return null otherwise
	 */
	public Edge getEdge(Vertex head, Vertex tail) {
		HashSet<Edge> edges = currentGraph.get(head);
		for(Edge e: edges) {
			if(e.getEndpt2().equals(tail))return e;
		}
		return null;
	}
	
	/*
	 * Checks to see if an edge exists 
	 * @param head the beginning vertex
	 * @param tail the ending vertex
	 * @return true if the edge exists
	 * @return false otherwise
	 */
	public boolean edgeExists(Vertex head, Vertex tail) {
		Edge exist = getEdge(head,tail);
		if(exist !=null)return true;
		return false;
	}
	
	/*
	 * @return all the Vertices of the graph
	 */
	public HashSet<Vertex> getAllVertexes(){
		HashSet<Vertex> vertexes = new HashSet<Vertex>();
		for(Vertex v: currentGraph.keySet()) vertexes.add(v);
		return vertexes;
	}
	
	/*
	 * Gets all the edges of a given Vertex
	 * @param vertex a vertex
	 * @return all the edges that the vertex is connected to
	 */
	public HashSet<Edge> getVertexEdges(Vertex vertex){
		return currentGraph.get(vertex);
	}
	

}
