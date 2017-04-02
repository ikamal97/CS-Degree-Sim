import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class csDegreeSim{
	public static int Height = 429;
	public static int Width = 605;
	public JPanel panel;
	public JFrame frame;
	public Game gameSystem;
	public Character playerCharacter;
	public MainMenu mainMenu;
	public NewGameMenu newGameMenu;
	public DayMenu dayMenu;
	
	
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
		
		//mainMenu = new MainMenu(this);
		//dayMenu = new DayMenu(this);
		//newGameMenu = new NewGameMenu(this);
	}
		
	public void startGame(){
		setPanel(new MainMenu(this));
	}
	
	public void newGame(){
		System.out.println("New Game selected");
		playerCharacter = new Character();
		gameSystem = new Game(playerCharacter);
		setPanel(new NewGameMenu(this, playerCharacter));
	}
	
	public void loadGame(){
		System.out.println("Load Game selected");
		setPanel(new DayMenu(this, gameSystem, playerCharacter));
		gameSystem.startDay();
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
		System.out.println("New Day selected");
		setPanel(new DayMenu(this, gameSystem, playerCharacter));
		gameSystem.startDay();
	}
	
	public void endDay(){
		System.out.println("End Day selected");
		setPanel(new NightMenu(this, gameSystem, playerCharacter));
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
