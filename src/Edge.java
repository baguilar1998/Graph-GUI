public class Edge {
	
	//Instance Variables for Edges
	private Vertex endpt1,endpt2;
	private int weight;
	private int edgeNumber;
	
	//Number of current Edges that have been made
	private static int numOfEdges=0;
	
	/*
	 * Default Constructor for an Edge
	 */
	public Edge() {
		endpt1=null;
		endpt2=null;
		weight=0;
	}
	
	/*
	 * One Parameter Constructor for an edge
	 * @param endpt1 the initial vertex
	 */
	public Edge(Vertex endpt1) {
		super();
		this.endpt1=endpt1;
		edgeNumber = ++numOfEdges;
	
	}

	/*
	 * Two Parameter Constructor for an edge
	 * @param endpt1 the initial vertex
	 * @param endpt2 the ending vertex
	 */
	public Edge(Vertex endpt1,Vertex endpt2) {
		super();
		this.endpt1=endpt1;
		this.endpt2=endpt2;
		edgeNumber = ++numOfEdges;
	}

	/*
	 * Three Parameter Constructor for an edge
	 * @param endpt1 the initial vertex
	 * @param endpt2 the ending vertex
	 * @param weight the weight of the edge
	 */
	public Edge(Vertex endpt1,Vertex endpt2,int weight) {
		this.endpt1=endpt1;
		this.endpt2=endpt2;
		this.weight=weight;
		edgeNumber = ++numOfEdges;
	}
	/*
	 * @return the beginning vertex of an edge
	 */
	public Vertex getEndpt1() {
		return endpt1;
	}
	
	/*
	 * @return the ending vertex of an edge
	 */
	public Vertex getEndpt2() {
		return endpt2;
	}
	
	/*
	 * @return the weight of the edge
	 */
	public int getWeight() {
		return weight;
	}
	
	/*
	 * Sets a new weight to the edge
	 * @param weight the weight of the edge
	 */
	public void setWeight(int weight) {
		this.weight=weight;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * String representation of an edge
	 */
	public String toString() {
		return "Edge: "+edgeNumber;
	}


}
