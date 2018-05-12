import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Vertex {
	
	//Instance Variables for a Vertex
	private int x,y;
	private int vertexID;
	private Shape visualVertex;
	private Color vertexState;

	//Number of current vertices that have been made
	private static int vertexNumber = 0;
	
	/*
	 * Default Constructor for a Vertex
	 */
	public Vertex() {
		x=0;
		y=0;
		visualVertex = new Ellipse2D.Double(x, y, 12, 12);
		vertexState = Color.RED;
		vertexID = ++vertexNumber;
	}
	
	/*
	 * Two Parameter Constructor for a Vertex
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Vertex(int x,int y) {
		super();
		this.x=x;
		this.y=y;
		visualVertex = new Ellipse2D.Double(x-5, y-5, 12, 12);
		vertexState = Color.RED;
		vertexID = ++vertexNumber;
	}
	
	/*
	 * @return current x-coordinate
	 */
	public int getX() {
		return x;
	}
	
	/*
	 * @return current y-coordinate
	 */
	public int getY() {
		return y;
	}
	
	/*
	 * @return vertex number
	 */
	public int getVertexID() {
		return vertexID;
	}
	
	/*
	 * @return the vertex representation on the canvas
	 */
	public Shape getVisualVertex() {
		return visualVertex;
	}
	
	/*
	 * @return the current vertex state
	 */
	public Color getVertexState() {
		return vertexState;
	}
	
	/*
	 * @param x sets the x-coordinate
	 */
	public void setX(int x) {
		this.x=x;
	}
	
	/*
	 * @param y sets the y-coordinate
	 */
	public void setY(int y) {
		this.y=y;
	}
	
	/*
	 * @param c sets the state of the vertex
	 * Whether the user clicked on the vertex or not 
	 * for certain menu options
	 */
	public void setVertexState(Color c) {
		vertexState = c;
	}
	
	/*
	 * @param v the vertex representation in a canvas
	 */
	public void setVisualVertex(Shape v) {
		visualVertex = v;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return string representation of a Vertex
	 */
	public String toString() {
		return "Vertex: "+vertexID;
	}

}
