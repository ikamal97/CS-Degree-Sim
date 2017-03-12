import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class csDegreeSim{
	public static int Height = 400;
	public static int Width = 600;
	JPanel panel;
	JMenuBar mainMenu;
	public JFrame frame;
	
	
	public static void main(String[] args){
		final csDegreeSim CSDegreeSimulator = new csDegreeSim();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	CSDegreeSimulator.start();
            }
        });

	}
	
	public csDegreeSim(){
		//constructor
		frame = new JFrame();
		frame.setTitle("CS Degree Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(new Dimension(Width, Height));
		frame.setLocation(200, 200);
	}
		
	private void start(){
		//new mainMenu/Game/etc...
		setPanel(new MainMenu(this));
	}
	
	public JFrame getJFrame(){
		return frame;
	}
	
	void setPanel(JPanel newPanel) {
		frame.add(newPanel);
		if (panel != null)
			frame.remove(panel);
		panel = newPanel;
		frame.setVisible(true);
	}
}







