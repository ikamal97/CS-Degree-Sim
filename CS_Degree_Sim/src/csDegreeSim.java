import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class csDegreeSim{
	public static int Height = 400;
	public static int Width = 600;
	public JPanel panel;
	public JMenuBar mainMenu;
	public JFrame frame;
	public Game gameSystem;
	
	public static void main(String[] args){
		final csDegreeSim CSDegreeSimulator = new csDegreeSim();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	CSDegreeSimulator.startGame();
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
		
	public void startGame(){
		setPanel(new MainMenu(this));
		gameSystem = new Game();
	}
	
	public void newGame(){
		System.out.println("New Game selected");
		setPanel(new NewGameMenu(this));
	}
	
	public void loadGame(){
		System.out.println("Load Game selected");
	}
	
	public void options(){
		System.out.println("Options selected");
	}
	
	public void exit(){
		System.out.println("Exit selected");
		frame.setVisible(false);
		System.exit(0);
	}
	
	public void startDay(){	
		System.out.println("Start Game selected");
		setPanel(new DayMenu(this));
		gameSystem.startDay();
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
