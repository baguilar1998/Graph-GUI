import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener{

	private GraphGUI gui;
	
	public ButtonListener(GraphGUI gui) {
		this.gui=gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName = e.getActionCommand();
		
		/*
		 * Adds all possibles edges in a graph 
		 * based on the number of vertices that are presented
		 * (Creates a Complete Graph)
		 */
		if(buttonName.equals("Add All Edges")) {
			HashSet<Vertex> vertexes = gui.canvas.graphDrawing.getAllVertexes();
			for(Vertex v: vertexes) {
				for(Vertex vv: vertexes) {
					if(v.equals(vv))continue;
					gui.canvas.graphDrawing.addEdge(v,vv);
				}
			}
			gui.canvas.repaint();
		}
	
		/*
		 * Adds random weights to all of the current
		 * edges that are in the graph
		 */
		if(buttonName.equals("Random Weights")) {
			for(Vertex x: gui.canvas.graphDrawing.getAllVertexes()) {
				for(Edge ee: gui.canvas.graphDrawing.getVertexEdges(x)) {
					int randomWeight =(int)(Math.random()*10)+1;
					ee.setWeight(randomWeight);
					try {
						Edge temp = gui.canvas.graphDrawing.getEdge(ee.getEndpt2(), x);	
						//if(temp.getWeight()>0) continue;
						temp.setWeight(randomWeight);
					}catch(NullPointerException ex) {
						
					}
					
				}
			}
			gui.canvas.repaint();
		}
		
		if(buttonName.equals("Minimal Tree Spanning")) {
			PriorityQueue<Vertex> treePath = new PriorityQueue<Vertex>();
			for(Vertex v : gui.canvas.graphDrawing.getAllVertexes()) {
				if(v.getVertexID()==1) {
					v.minDistance=0;
				}else {
					v.minDistance = Double.POSITIVE_INFINITY;
				}
				treePath.add(v);
			}
			System.out.println(treePath.poll());
			TreeSet<Edge> mst = new TreeSet<Edge>();
			/*while(!treePath.isEmpty()) {
				
			}*/
			
		}
		
		if(buttonName.equals("Help")) {
			new HelpPrompt();
		}
	}

}
