import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Vertex {
	
	private int x,y;
	private int vertexID;
	private Shape visualVertex;
	private Color vertexState;

	private static int vertexNumber = 0;
	
	public Vertex() {
		x=0;
		y=0;
		visualVertex = new Ellipse2D.Double(x-5, y-5, 12, 12);
		vertexState = Color.RED;
		vertexID = ++vertexNumber;
	}
	
	public Vertex(int x,int y) {
		super();
		this.x=x;
		this.y=y;
		visualVertex = new Ellipse2D.Double(x-5, y-5, 12, 12);
		vertexState = Color.RED;
		vertexID = ++vertexNumber;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	public int getVertexID() {return vertexID;}
	public Shape getVisualVertex() {return visualVertex;}
	public Color getVertexState() {return vertexState;}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setVertexState(Color c) {
		vertexState = c;
	}
	
	public void setVisualVertex(Shape v) {
		visualVertex = v;
	}
	
	public String toString() {
		return "Vertex: "+vertexID;
	}
	

}
