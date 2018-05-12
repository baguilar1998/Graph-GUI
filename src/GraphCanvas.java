import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GraphCanvas extends JPanel implements MouseListener{

	//Instance Variables of a GraphCanvas
    private GraphGUI frame;
    private static String radioButtonState;
    private static boolean isEnabled; 
    protected static Graph graphDrawing;
    private static Vertex endpt1,endpt2;

    /*
     * One Parameter Constructor of a GraphCanvas
     * @param frame the current JFrame the canvas
     * is on
     */
    public GraphCanvas(GraphGUI frame)
    {
        this.frame=frame;
        isEnabled = false;
        radioButtonState="";
        graphDrawing = new Graph();
        this.addMouseListener(this);
    }

    /*
     * @param e sets whether the user can edit on the 
     * canvas or not
     */
    public void setIsEnabled(boolean e) {
    	isEnabled = e;
    }
    
    /*
     * @param v sets the first vertex the user
     * clicked on
     */
    public void setEndpt1(Vertex v) {
    	endpt1=v;
    }
    
    /*
     * @param v sets the second vertex the user
     * clicked on
     */
    public void setEndpt2(Vertex v) {
    	endpt2=v;
    }
    
    /*
     * @return the first vertex the user clicked on
     */
    public Vertex getEndpt1() {
    	return endpt1;
    }
    
    /*
     * @return the second vertex the user clicked on
     */
    public Vertex getEndpt2() {
    	return endpt2;
    }
    
    /*
     * @return whether the user can edit on the canvas
     */
    public boolean getIsEnabled() {
    	return isEnabled;
    }

    /*
     * @param s sets which option (RadioButton) the 
     * user chose
     */
    public void setRadioButtonState(String s) {
    	radioButtonState=s;
    }
    
    /*
     * @return the option (RadioButton) the user chose
     */
    public String getRadioButtonState() {
    	return radioButtonState;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
    	
        int x = e.getX();
        int y = e.getY();
        
       //DEBUG CODE
      if(radioButtonState.equals("")) {
    	  this.paintComponent(this.getGraphics());
        }
    	
    	if(!isEnabled)return;
        
    	/*
    	 * (Add A Vertex)
    	 * Adds a vertex to the canvas
    	 */
        if(radioButtonState.equals("Add Vertex")) {
        	Vertex v = new Vertex(x,y);
        	graphDrawing.addVertex(v);
        	this.paintComponent(this.getGraphics());
        }
        
        /*
         * (Add An Edge)
         * Adds an edge to the two vertices that
         * the user has chosen
         */
        if(radioButtonState.equals("Add Edge")) {
           if(endpt1==null) {
        	   endpt1=graphDrawing.findVertex(e.getPoint());
        	   try{
        		   endpt1.setVertexState(Color.GREEN);
        	   }catch (NullPointerException ex) {
    			   this.repaint();
        		   return;
        	   }
        	   this.repaint();
           }else if(endpt1.getVertexState().equals(Color.GREEN)) {
        	   endpt2 = graphDrawing.findVertex(e.getPoint());
        	   try {
        		   if(endpt2 == null || endpt1==endpt2) throw new NullPointerException();
        		   graphDrawing.addEdge(endpt1,endpt2);
        	   }catch (NullPointerException ex) {
             	   endpt1.setVertexState(Color.RED);
             	   this.repaint();
              	   endpt1=null;
              	   endpt2=null;
              	   return;
        	   }
         	   endpt1.setVertexState(Color.RED);
         	   this.repaint();
          	   endpt1=null;
          	   endpt2=null;
          	   
           }
        }
        
        /*
         * (Move a Vertex)
         * Moves a chosen vertex to another location of 
         * the canvas
         */
        if(radioButtonState.equals("Move Vertex")) {
            if(endpt1==null) {
            	try {
                    endpt1 = graphDrawing.findVertex(e.getPoint());
                    if(endpt1==null) throw new NullPointerException();
            	}catch (NullPointerException ex) {
            		return;
            	}
  			endpt1.setVertexState(Color.GREEN);
  			this.repaint();	
            }else if(endpt1.getVertexState().equals(Color.GREEN)) {
            	Point newPoint = e.getPoint();
            	endpt1.setX(newPoint.x);
            	endpt1.setY(newPoint.y);
            	endpt1.setVertexState(Color.RED);
            	this.repaint();
            	endpt1=null;
            }
            	
        }
        
        /*
         * (Shortest Path)
         * Calculates the shortest path from one vertice
         * to another
         */
        if(radioButtonState.equals("Shortest Path")) {
        	 if(endpt1==null) {
             	try {
                     endpt1 = graphDrawing.findVertex(e.getPoint());
                     if(endpt1==null) throw new NullPointerException();
             	}catch (NullPointerException ex) {
             		return;
             	}
             	endpt1.setVertexState(Color.GREEN);
             	this.repaint();	
        	 }else if(endpt1.getVertexState().equals(Color.GREEN)) {
          	   endpt2 = graphDrawing.findVertex(e.getPoint());
          	   try {
          		   if(endpt2 == null) throw new NullPointerException();
          	   }catch (NullPointerException ex) {
               	   endpt1.setVertexState(Color.RED);
               	   this.repaint();
                	   endpt1=null;
                	   endpt2=null;
                	   return;
          	   }
          
          	   JOptionPane.showMessageDialog(null, "Has not been implemented.");
          	   
           	   endpt1.setVertexState(Color.RED);
           	   this.repaint();
               endpt1=null;
               endpt2=null;
            	   
        	 }
        	
        }
        
        /*
         * (Change Weight)
         * Changes the weight of any edge based on 
         * the two vertices the user has chosen
         */
        if(radioButtonState.equals("Change Weight")) {
            if(endpt1==null) {
            	try {
             	   endpt1=graphDrawing.findVertex(e.getPoint());
             	   if(endpt1==null)throw new NullPointerException();
     			   endpt1.setVertexState(Color.GREEN);
     			   this.repaint();
            	}catch (NullPointerException ex) {
            		return;
            	}
            }else if(endpt1.getVertexState().equals(Color.GREEN)) {
            	int weight;
            	try{
              	   endpt2 = graphDrawing.findVertex(e.getPoint());
              	   if(endpt2==null) throw new NullPointerException();
              	   weight = Integer.parseInt(frame.weightInput.getText());
            	}catch (NullPointerException | NumberFormatException ex) {
              	   endpt1.setVertexState(Color.RED);
              	   this.repaint();
               	   endpt1=null;
               	   endpt2=null;
               	   return;
            	}
            	
         	   Edge edge1 = graphDrawing.getEdge(endpt1, endpt2);
          	   Edge edge2 = graphDrawing.getEdge(endpt2, endpt1);
          	   edge1.setWeight(weight);
          	   edge2.setWeight(weight);
          	   endpt1.setVertexState(Color.RED);
          	   this.repaint();
           	   endpt1=null;
           	   endpt2=null;
            }
        	
        }
   
    }

	public void paintComponent(Graphics g){ 
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        
       HashSet<Vertex> allVertexes = graphDrawing.getAllVertexes();
      
      /*
       * Draws all the Vertices that the user has
       * placed on the canvas
       */
       for(Vertex x: allVertexes) {
           	Shape vertex = new Ellipse2D.Double(x.getX()-5, x.getY()-5, 12, 12);
        	x.setVisualVertex(vertex);
        	g2.setColor(x.getVertexState());
            g2.fill(vertex);
       }

       /*
        * Draws all the edges that the user has made
        * with their given weights if one exists
        */
       for(Vertex x: allVertexes) {
        	HashSet<Edge> temp = graphDrawing.getVertexEdges(x);
        	for(Edge e : temp) { 
        		Point from = new Point(x.getX(),x.getY());
        		Point to = new Point(e.getEndpt2().getX(),e.getEndpt2().getY());
        		g2.setColor(e.getEdgeColor());
             	g2.setStroke(new BasicStroke(5));
             	g2.drawLine(from.x, from.y, to.x, to.y);
             	if(e.getWeight()!=0) {
             		g2.setFont(new Font("Dialog",Font.BOLD,18));
             		g2.drawString(""+e.getWeight(), ((from.x+to.x)/2)+20 , ((from.y+to.y)/2));
             	}
        	}
        }
        
    }
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}