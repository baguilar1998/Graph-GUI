import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
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

			/*
			 * Bad Algorithm for Minimal Spanning Tree
			 */
			Vertex s = gui.canvas.graphDrawing.getVertex(1);
			HashMap <Vertex,HashSet<Edge>> mst = new HashMap<Vertex,HashSet<Edge>>();
			mst.put(s, new HashSet<Edge>());
			while(!gui.canvas.graphDrawing.getAllVertexes().equals(mst.keySet())) {
				Edge min = new Edge();
				Vertex u = new Vertex();
				for(Vertex v : mst.keySet()) {
					for(Edge ee: gui.canvas.graphDrawing.getVertexEdges(v)) {
						try {
							if(mst.containsKey(v)) {
								if(mst.get(v).contains(ee))continue;
								Edge adj = new Edge(ee.getEndpt2(),ee.getEndpt1());
								if(mst.get(v).contains(adj))continue;
								Vertex v1 = ee.getEndpt1();
								Vertex v2 = ee.getEndpt2();
								if(gui.canvas.graphDrawing.getVertex(v1.getVertexID()).getVertexState().equals(Color.GREEN) 
										&& gui.canvas.graphDrawing.getVertex(v2.getVertexID()).getVertexState().equals(Color.GREEN)) continue;
							}

						}catch(NullPointerException ex) {
							continue;
						}

						if(ee.getWeight()<min.getWeight()) {
							u=v;
							System.out.println(u);
							min = ee;

						}
					}
				}
				

				if(mst.containsKey(u)) {

					Edge adj = new Edge(min.getEndpt2(),u);
					mst.get(u).add(min);
					if(!mst.containsKey(min.getEndpt2())) {
						mst.put(min.getEndpt2(), new HashSet<Edge>());
						mst.get(min.getEndpt2()).add(adj);
					}else {
						mst.get(min.getEndpt2()).add(adj);
					}
					gui.canvas.graphDrawing.getEdge(u, min.getEndpt2()).setEdgeColor(Color.GREEN);
					gui.canvas.graphDrawing.getEdge(min.getEndpt2(),u).setEdgeColor(Color.GREEN);
					gui.canvas.graphDrawing.getVertex(u.getVertexID()).setVertexState(Color.GREEN);
					gui.canvas.graphDrawing.getVertex(min.getEndpt2().getVertexID()).setVertexState(Color.GREEN);
					min=null;
					u=null;
				}else {
					mst.put(u,new HashSet<Edge>());
					Edge adj = new Edge(min.getEndpt2(),u);
					mst.get(u).add(min);
					if(!mst.containsKey(min.getEndpt2())) {
						mst.put(min.getEndpt2(), new HashSet<Edge>());
						mst.get(min.getEndpt2()).add(adj);
					}else {
						mst.get(min.getEndpt2()).add(adj);
					}
					gui.canvas.graphDrawing.getEdge(u, min.getEndpt2()).setEdgeColor(Color.GREEN);
					gui.canvas.graphDrawing.getEdge(min.getEndpt2(), u).setEdgeColor(Color.GREEN);
					min=null;
					u=null;
				}
			}
			
			
			System.out.println(mst);
			gui.canvas.repaint();
			
			
		}
		
		if(buttonName.equals("Help")) {
			new HelpPrompt();
		}
	}

}
