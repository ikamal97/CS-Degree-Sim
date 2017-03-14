import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel implements Observer, DisplayMenu {//

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
		
		createPanels();
		
		listen = new MainMenuListener();
		//addKeyListener(this);
		
		createButtons();
		
	}
	
	public void createPanels(){
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
	}

	public void createButtons(){
		newGame = new JButton("NEW GAME");
		newGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		newGame.setBackground(Color.BLACK);
		newGame.setForeground(Color.WHITE);
		newGame.setBounds(210, 20, 200, 30);
		newGame.setBorder(border);
		newGame.addActionListener(listen);
		newGame.setActionCommand("newGame");	
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
	
	public void updateStats(int stats, int energy){
		this.screenStats = stats;
		//display();
	}
	
	public void updateTraits(int intelligence, int endurance, int charisma){
		
		//display();
	}
	
	public void updateTimer(int time){
		//display();
	}
	
	//public void display(){
		//code for updating display	
	//}
	
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

}
