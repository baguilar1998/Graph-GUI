import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class RadioButtonListener implements ActionListener{

	private GraphGUI gui;
	
	public RadioButtonListener(GraphGUI gui) {
		this.gui=gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Add a vertex
		if(gui.buttons[0].isSelected()) {
			disableUnselectedButtons(0);
			gui.canvas.setRadioButtonState("Add Vertex");
			gui.canvas.setIsEnabled(true);
			
		
		//Add an Edge
		}else if(gui.buttons[1].isSelected()) {
			disableUnselectedButtons(1);
			gui.canvas.setRadioButtonState("Add Edge");
			gui.canvas.setIsEnabled(true);
	
		//Move a vertex
		}else if(gui.buttons[2].isSelected()) {
			disableUnselectedButtons(2);
			gui.canvas.setRadioButtonState("Move Vertex");
			gui.canvas.setIsEnabled(true);
	
		//Shortest Path
		}else if(gui.buttons[3].isSelected()) {
			disableUnselectedButtons(3);
			gui.canvas.setRadioButtonState("Shortest Path");
			gui.canvas.setIsEnabled(true);
	
		//Change weight to
		}else if(gui.buttons[4].isSelected()) {
			disableUnselectedButtons(4);
			gui.canvas.setRadioButtonState("Change Weight");
			gui.canvas.setIsEnabled(true);
		}else {
			gui.canvas.setRadioButtonState("");
			gui.canvas.setIsEnabled(false);
			for(int i=0;i<gui.buttons.length;++i) {
				gui.buttons[i].setEnabled(true);
			}
			for(Vertex v : gui.canvas.graphDrawing.getAllVertexes()) {
				if(v.getVertexState().equals(Color.GREEN)) {
					v.setVertexState(Color.RED);
				}
			}
			gui.canvas.repaint();
		}
	}
	
	private void disableUnselectedButtons(int index) {
		gui.canvas.setIsEnabled(false);
		for(int i=0;i<gui.buttons.length;++i) {
			if(i==index)continue;
			gui.buttons[i].setEnabled(false);
		}
		gui.canvas.setEndpt1(null);
		gui.canvas.setEndpt2(null);
	}


}
