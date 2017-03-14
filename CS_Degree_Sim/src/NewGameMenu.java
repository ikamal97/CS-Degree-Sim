import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class NewGameMenu extends JPanel implements Observer, DisplayMenu {

	private int initialCharacterPoints;
	private Character character;
	private int moral, energy, intelligence, endurance, charisma; 
	private csDegreeSim sim;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel, moralLabel, energyLabel;
	private JLabel intelligenceLabel, enduranceLabel, charismaLabel; 
	private JButton startGame, minusINT, plusINT;
	private NewGameMenuListener listen;
	
	
	public NewGameMenu(csDegreeSim sim, Character character){
		this.sim = sim;
		this.character = character;
		character.registerObserver(this);
		
		initialCharacterInfo(character.getMorale(), character.getEnergy(), 
				character.getInt(), character.getEnd(), character.getChr());
		
		createPanels();
		
		listen = new NewGameMenuListener();
		
		createButtons();
		
	}
	
	public void createPanels(){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		headerLabel = new JLabel("Character Creation Screen");//
		headerPanel.add(headerLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLUE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
	}
	
	public void createButtons(){
		startGame = new JButton("START GAME");
		startGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		startGame.setBackground(Color.BLUE);
		startGame.setForeground(Color.BLACK);
		startGame.setBounds(210, 300, 300, 30);
		startGame.setBorder(border);
		startGame.addActionListener(listen);
		startGame.setActionCommand("startGame");	
		bodyPanel.add(startGame);
		
		minusINT = new JButton("-INT");
		minusINT.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
		minusINT.setBackground(Color.BLUE);
		minusINT.setForeground(Color.BLACK);
		minusINT.setBounds(210, 200, 100, 30);
		minusINT.setBorder(border2);
		minusINT.addActionListener(listen);
		minusINT.setActionCommand("-INT");	
		bodyPanel.add(minusINT);
		
		plusINT = new JButton("+INT");
		plusINT.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusINT.setBackground(Color.BLUE);
		plusINT.setForeground(Color.BLACK);
		plusINT.setBounds(320, 200, 100, 30);
		plusINT.setBorder(border3);
		plusINT.addActionListener(listen);
		plusINT.setActionCommand("+INT");	
		bodyPanel.add(plusINT);
		
		moralLabel = new JLabel("Moral: " + moral);
		moralLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		moralLabel.setForeground(Color.WHITE);
		moralLabel.setBounds(50, 50, 176, 18);
		bodyPanel.add(moralLabel);
		
		energyLabel = new JLabel("Energy: " + energy);
		energyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		energyLabel.setForeground(Color.WHITE);
		energyLabel.setBounds(50, 80, 176, 20);
		bodyPanel.add(energyLabel);
		
		intelligenceLabel = new JLabel("INT: " + intelligence);
		intelligenceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		intelligenceLabel.setForeground(Color.WHITE);
		intelligenceLabel.setBounds(50, 110, 176, 20);
		bodyPanel.add(intelligenceLabel);
		
		enduranceLabel = new JLabel("END: " + endurance);
		enduranceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		enduranceLabel.setForeground(Color.WHITE);
		enduranceLabel.setBounds(50, 140, 176, 20);
		bodyPanel.add(enduranceLabel);
		
	}
	
	/*public MainMenu(Subject Character){//recieves reference to subject
	this.Character = Character;
	Character.registerObserver(this);//registers this observer with subject
	}*/
	
	public void initialCharacterInfo(int moral, int energy, int intelligence, int endurance, int charisma){
		this.moral = moral;
		this.energy = energy;
		this.intelligence = intelligence;
		this.endurance = endurance;
		this.charisma = charisma;
	}
	
	public void updateStats(int moral, int energy){
		this.moral = moral;
		this.energy = energy;
		//display();
	}
	
	public void updateTraits(int intelligence, int endurance, int charisma){
		this.intelligence = intelligence;	
		this.endurance = endurance;
		this.charisma = charisma;
		
		this.intelligenceLabel.setText("INT: " + intelligence);
		this.enduranceLabel.setText("END: " + endurance);
	}
	
	public void updateTimer(int time){
		//display();
	}
	
	//public void display(){
		//code for updating display
	//}
	
	public class NewGameMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("startGame")) 
				sim.startDay();
			if (event.getActionCommand().equals("-INT"))
				character.setIntelligence(-1);
			if (event.getActionCommand().equals("+INT"))
				character.setIntelligence(1);
		}
	}

}
