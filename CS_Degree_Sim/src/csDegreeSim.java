package csDegreeSim2;

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
		csDegreeSim CSDegreeSimulator = new csDegreeSim();
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
		//setPanel(new MainMenu(this));
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


interface Subject{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

interface Observer{
	public void update(int stats);
}

interface DisplayElement{
	public void display();
}

class Game implements Subject  {
	private ArrayList<Observer> observers;
	
	public Game(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}
	
	public void notifyObservers(){
		
	}
	
	public int randomNumberGenerator(){
		Random RNG = new Random();
		int randomNumber = RNG.nextInt(100); //0-100
		return randomNumber;
	}
	
	
	public Event chooseEventType(){
		int Number=randomNumberGenerator();
		if(Number >=0 && Number <= 50){
			System.out.println("Good Event");
			GoodEvent goodEvent = new GoodEvent();
			return goodEvent;
		}
		else if(Number > 50 && Number <= 100){
		    System.out.println("Bad Event");
		    BadEvent badEvent=new BadEvent();
		    return badEvent;
		     
		}
	    
	  return null;
	}
	public void eventSelector(){
		int number=randomNumberGenerator();
		
		Event event=chooseEventType();
		
	}

	public abstract class Event{
	
	
	   
	}
	
	public class GoodEvent extends Event{

		public GoodEvent() {
			
			// TODO Auto-generated constructor stub
		}
		
	}
	public class BadEvent extends Event{

		public BadEvent() {
			
		}
		
	}
	
}

class Character implements Subject{
	int characterStats;
	private ArrayList<Observer> observers;
	
	public Character(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}
	
	//notify all observers that character stats changed and to update
	public void notifyObservers(){
		for(Observer observer : observers){
			observer.update(characterStats);
		}
	}
	
	public void statsChanged(){
		notifyObservers();
	}
	
}

class MainMenu extends JPanel implements Observer, DisplayElement{
	private int screenStats;
	private Subject Character;
	private JPanel panel;
	private csDegreeSim sim;
	private JTextField playerName;
	
	public MainMenu(csDegreeSim sim){
		this.sim = sim;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		JLabel headerLabel = new JLabel("Main Menu");
		headerPanel.add(headerLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLUE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		JButton newGame = new JButton("NEW GAME");
		newGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		newGame.setBackground(Color.GREEN);
		newGame.setForeground(Color.WHITE);
		newGame.setBounds(210, 20, 170, 30);
		newGame.setBorder(border);
		bodyPanel.add(newGame);
		
		JButton loadGame = new JButton("LOAD GAME");
		loadGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 1);
		loadGame.setBackground(Color.GREEN);
		loadGame.setForeground(Color.WHITE);
		loadGame.setBounds(205, 90, 183, 30);
		loadGame.setBorder(border2);
		bodyPanel.add(loadGame);
		
		JButton options = new JButton("OPTIONS");
		options.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 1);
		options.setBackground(Color.GREEN);
		options.setForeground(Color.WHITE);
		options.setBounds(215, 160, 136, 30);
		options.setBorder(border3);
		bodyPanel.add(options);
		
		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border4 = BorderFactory.createLineBorder(Color.BLACK, 1);
		exit.setBackground(Color.GREEN);
		exit.setForeground(Color.WHITE);
		exit.setBounds(255, 230, 70, 30);
		exit.setBorder(border4);
		bodyPanel.add(exit);
		

	}
	
	/*public MainMenu(Subject Character){//recieves reference to subject
		this.Character = Character;
		Character.registerObserver(this);//registers this observer with subject
	}*/
	
	public void update(int stats){
		this.screenStats = stats;
		display();
	}
	
	public void display(){
		//code for updating display
		
	}
		
}




/*
public class csDegreeSim {
	
	
	
	public static void main(String[] args){
		csDegreeSim CSDegreeSimulator = new csDegreeSim();
	
		
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	CSDegreeSimulator.start();
            }
        });

	}
	
	public csDegreeSim(){
		//constructor
	}
		
	private void start(){
		//new mainMenu/Game/etc...
	}
	
}


interface Subject{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

interface Observer{
	public void update(int stats);
}

interface DisplayElement{
	public void display();
}

class Game implements Subject{
	private ArrayList<Observer> observers;
	
	public Game(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}
	
	public void notifyObservers(){
		
	}
	
}

class Character implements Subject{
	int characterStats;
	private ArrayList<Observer> observers;
	
	public Character(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}
	
	//notify all observers that character stats changed and to update
	public void notifyObservers(){
		for(Observer observer : observers){
			observer.update(characterStats);
		}
	}
	
	public void statsChanged(){
		notifyObservers();
	}
	
}
class MainMenu implements Observer, DisplayElement{
	private int screenStats;
	private Subject Character;
	private JLabel label;
	
	
	public MainMenu(Subject Character){//recieves reference to subject
		this.Character = Character;
		Character.registerObserver(this);//registers this observer with subject
	}
	
	public void update(int stats){
		this.screenStats = stats;
		display();
	}
	
	public void display(){
		//code for updating display
		JFrame window= new JFrame("Main Menu");
		JPanel panel=new JPanel();
		JLabel label=new JLabel();
		JButton newGame=new JButton("New Game");
		JButton loadGame=new JButton("Load Game");
		JButton selectMoral=new JButton("Select Moral");
		JButton selectCharacter=new JButton("Select Character");
		JButton saveGame=new JButton("Save Game");
		
		window.setVisible(true);
		window.setSize(1000,700);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.GRAY);
		
		panel.add(newGame);
		panel.add(loadGame);
		panel.add(saveGame);
		panel.add(selectMoral);
		panel.add(selectCharacter);
		
		panel.add(label);
		
		window.add(panel,BorderLayout.SOUTH);
	    
	//  newGame.addActionListener(this);
	//	newGame.addKeyListener(this);
	
	}
		
}
*/
