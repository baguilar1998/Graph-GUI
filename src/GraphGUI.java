import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GraphGUI extends JFrame{
	
	private JPanel sideMenu,weightPanel;
	protected GraphCanvas canvas;
	protected JTextField weightInput;
	protected JRadioButton[] buttons; 
	private JButton addAllEdges,randomWeights,treeSpanning,help;
	private RadioButtonListener rbl;
	private ButtonListener bl;
	
	/*
	 * A default constructor for the GraphGUI
	 */
	public GraphGUI() {
		setTitle("Graph GUI");
		setSize(1000,700);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rbl = new RadioButtonListener(this);
		bl = new ButtonListener(this);
		setComponents();
		setVisible(true);
	}
	
	/*
	 * A helper function that sets up the whole GUI
	 */
	private void setComponents() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
	
		sideMenu = new JPanel();
		sideMenu.setAlignmentX(LEFT_ALIGNMENT);
		sideMenu.setMaximumSize(new Dimension(200,700));
		setSideMenu();
		add(sideMenu);

		canvas = new GraphCanvas(this);
		canvas.setAlignmentX(RIGHT_ALIGNMENT);
		add(canvas);
		
	    /*setLayout(new GridLayout(1,2));
		
		sideMenu = new JPanel();
		setSideMenu();
		add(sideMenu);
		
		canvas = new GraphCanvas(this);
		add(canvas);*/

		
	}

	/*
	 * A helper function that sets up the side menu
	 * for the GUI
	 */
	private void setSideMenu() {
		sideMenu.setLayout(new GridLayout(9,1));
		
		buttons = new JRadioButton[5];
		
		buttons[0] = new JRadioButton("Add a vertex");
		buttons[0].addActionListener(rbl);
		sideMenu.add(buttons[0]);
		
		buttons[1]= new JRadioButton("Add an edge");
		buttons[1].addActionListener(rbl);
		sideMenu.add(buttons[1]);
		
		buttons[2] = new JRadioButton("Move a vertex");
		buttons[2].addActionListener(rbl);
		sideMenu.add(buttons[2]);
		
		buttons[3] = new JRadioButton("Shortest Path");
		buttons[3].addActionListener(rbl);
		sideMenu.add(buttons[3]);
		
		weightPanel = new JPanel();
		weightPanel.setLayout(new GridLayout(1,2));
		
		buttons[4] = new JRadioButton("Change Weight to :");
		buttons[4].addActionListener(rbl);
		weightPanel.add(buttons[4]);
		
		weightInput = new JTextField(3);
		weightPanel.add(weightInput);
		
		sideMenu.add(weightPanel);
		
		addAllEdges = new JButton("Add All Edges");
		addAllEdges.addActionListener(bl);
		sideMenu.add(addAllEdges);
		
		randomWeights = new JButton("Random Weights");
		randomWeights.addActionListener(bl);
		sideMenu.add(randomWeights);
		
		treeSpanning = new JButton("Minimal Tree Spanning");
		sideMenu.add(treeSpanning);
		
		help = new JButton("Help");
		sideMenu.add(help);
	}
	

}
