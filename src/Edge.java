
public class Edge {
	
	private Vertex endpt1,endpt2;
	private int weight;
	private int edgeNumber;
	private static int numOfEdges=0;
	
	
	public Edge() {
		endpt1=null;
		endpt2=null;
		weight=0;
	}
	public Edge(Vertex endpt1) {
		super();
		this.endpt1=endpt1;
		edgeNumber = ++numOfEdges;
	
	}

	public Edge(Vertex endpt1,Vertex endpt2) {
		super();
		this.endpt1=endpt1;
		this.endpt2=endpt2;
		edgeNumber = ++numOfEdges;
	}

	public Edge(Vertex endpt1,Vertex endpt2,int weight) {
		this.endpt1=endpt1;
		this.endpt2=endpt2;
		this.weight=weight;
		edgeNumber = ++numOfEdges;
	}
	
	public Vertex getEndpt1() {return endpt1;}
	public Vertex getEndpt2() {return endpt2;}
	public int getWeight() {return weight;}
	
	public void setWeight(int weight) {
		this.weight=weight;
	}
	
	public String toString() {
		return "Edge: "+edgeNumber;
	}


}
