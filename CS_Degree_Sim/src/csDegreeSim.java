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
	
	public int randomNumberGenerator(){
		Random RNG = new Random();
		int randomNumber = RNG.nextInt(100); //0-100
		return randomNumber;
	}
	
	public abstract class Event{
		
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

class MainMenu extends JPanel implements Observer{//, KeyListener
	private int screenStats;
	private Subject Character;
	private csDegreeSim sim;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel;
	private JButton newGame, loadGame, options, exit;
	private MainMenuListener listen;
	
	public MainMenu(csDegreeSim sim){
		this.sim = sim;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		headerLabel = new JLabel("Main Menu Screen");
		headerPanel.add(headerLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLACK);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		listen = new MainMenuListener();
		//addKeyListener(this);
		
		createButtons();
		
	}
	
	public void createButtons(){
		newGame = new JButton("NEW GAME");
		newGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		newGame.setBackground(Color.BLACK);
		newGame.setForeground(Color.WHITE);
		newGame.setBounds(210, 20, 172, 30);
		newGame.setBorder(border);
		newGame.addActionListener(listen);
		newGame.setActionCommand("newGame");
		//newGame.requestFocus();	
		bodyPanel.add(newGame);
		
		loadGame = new JButton("LOAD GAME");
		loadGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 2);
		loadGame.setBackground(Color.BLACK);
		loadGame.setForeground(Color.WHITE);
		loadGame.setBounds(205, 90, 185, 30);
		loadGame.setBorder(border2);
		loadGame.addActionListener(listen);
		loadGame.setActionCommand("loadGame");
		bodyPanel.add(loadGame);
		
		options = new JButton("OPTIONS");
		options.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border3 = BorderFactory.createLineBorder(Color.WHITE, 2);
		options.setBackground(Color.BLACK);
		options.setForeground(Color.WHITE);
		options.setBounds(215, 160, 138, 30);
		options.setBorder(border3);
		options.addActionListener(listen);
		options.setActionCommand("options");
		bodyPanel.add(options);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border4 = BorderFactory.createLineBorder(Color.WHITE, 2);
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(255, 230, 71, 30);
		exit.setBorder(border4);
		exit.addActionListener(listen);
		exit.setActionCommand("exit");
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
	/*
	@Override
	public void keyTyped(KeyEvent e){
		System.out.println(e.getKeyCode());
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("up typed.");
			if(button == 0)
				button = 3;
			else 
				button--;
			setButtonFocus();
		case KeyEvent.VK_DOWN:
			System.out.println("down typed.");
			if(button == 3)
				button = 0;
			else 
				button++;
			setButtonFocus();
		case KeyEvent.VK_ENTER:
			System.out.println("enter typed.");
			//(getButtonFocus()).doClick();
			getButtonFocus().setBackground(Color.GREEN);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){

	}
	
	@Override
	public void keyReleased(KeyEvent e){
		
	}
	
	public void setButtonFocus(){
		switch(button){
		case 0:
			newGame.requestFocus();
		case 1:
			loadGame.requestFocus();
		case 2:
			options.requestFocus();
		case 3:
			exit.requestFocus();
		}
	}
	
	public JButton getButtonFocus(){
		switch(button){
		case 0:
			return newGame;
		case 1:
			return loadGame;
		case 2:
			return options;
		case 3:
			return exit;
		default:
			return newGame;
		}
	}*/
	
	public class MainMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("newGame")) 
				sim.newGame();
			else if (event.getActionCommand().equals("loadGame"))
				sim.loadGame();			
			else if (event.getActionCommand().equals("options"))
				sim.options();
			else if (event.getActionCommand().equals("exit")) 
				sim.exit();	
		}
	}
		
}

class NewGameMenu extends JPanel implements Observer{
	private int screenStats;
	private Subject Character;
	private csDegreeSim sim;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel;
	private JButton quit;
	private NewGameMenuListener listen;
	
	
	public NewGameMenu(csDegreeSim sim){
		this.sim = sim;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		headerLabel = new JLabel("Character Creation Screen");
		headerPanel.add(headerLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLUE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		listen = new NewGameMenuListener();
		
		createButtons();
		
	}
	
	public void createButtons(){
		quit = new JButton("START GAME");
		quit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		quit.setBackground(Color.BLUE);
		quit.setForeground(Color.BLACK);
		quit.setBounds(210, 20, 172, 30);
		quit.setBorder(border);
		quit.addActionListener(listen);
		quit.setActionCommand("startGame");
		//newGame.requestFocus();	
		bodyPanel.add(quit);
	}
	
	public void update(int stats){
		this.screenStats = stats;
		display();
	}
	
	public void display(){
		//code for updating display
		
	}
	
	public class NewGameMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("startGame")) 
				sim.startDay();
		}
	}
	
	
}


class DayMenu extends JPanel implements Observer{
	private int screenStats;
	private Subject Character;
	private csDegreeSim sim;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel;
	private JButton quit;
	private DayMenuListener listen;
	
	
	public DayMenu(csDegreeSim sim){
		this.sim = sim;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		headerLabel = new JLabel("Day Menu Screen");
		headerPanel.add(headerLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.ORANGE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		listen = new DayMenuListener();
		
		createButtons();
		
	}
	
	public void createButtons(){
		quit = new JButton("QUIT");
		quit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		quit.setBackground(Color.ORANGE);
		quit.setForeground(Color.GRAY);
		quit.setBounds(210, 20, 172, 30);
		quit.setBorder(border);
		quit.addActionListener(listen);
		quit.setActionCommand("quit");
		//newGame.requestFocus();	
		bodyPanel.add(quit);
	}
	
	public void update(int stats){
		this.screenStats = stats;
		display();
	}
	
	public void display(){
		//code for updating display
		
	}
	
	public class DayMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("quit")) 
				sim.startGame();
		}
	}
	
	
}



