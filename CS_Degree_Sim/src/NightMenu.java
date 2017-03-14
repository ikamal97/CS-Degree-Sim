import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class NightMenu extends JPanel implements Observer, DisplayMenu {

	private Character character;
	private int moral, energy, intelligence, endurance, charisma;
	private csDegreeSim sim;
	private Game game;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel, timerLabel, moralLabel, energyLabel, nameLabel;
	private JLabel intelligenceLabel, enduranceLabel, charismaLabel; 
	private JButton startGame, plusINT, plusEND, plusCHR;
	private JButton quit, nextDay;
	private NightMenuListener listen;
	
	public NightMenu(csDegreeSim sim, Game game, Character character){
		this.sim = sim;
		this.character = character;
		this.game = game;
		
		character.registerObserver(this);
		game.registerObserver(this);
		
		initialCharacterInfo(character.getMorale(), character.getEnergy(), 
				character.getInt(), character.getEnd(), character.getChr());
		
		createPanels();
		
		listen = new NightMenuListener();
		
		createComponents();
		
	}
	
	public void createPanels() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		headerLabel = new JLabel("Night Menu Screen");//
		headerPanel.add(headerLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.DARK_GRAY);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
	}

	public void createComponents() {
		nextDay = new JButton("NEXT DAY");
		nextDay.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		nextDay.setBackground(Color.GRAY);
		nextDay.setForeground(Color.BLACK);
		nextDay.setBounds(210, 300, 300, 30);
		nextDay.setBorder(border);
		nextDay.addActionListener(listen);
		nextDay.setActionCommand("nextDay");	
		bodyPanel.add(nextDay);
		
		plusINT = new JButton("STUDY: +INT(5 Energy)");
		plusINT.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusINT.setBackground(Color.GRAY);
		plusINT.setForeground(Color.BLACK);
		plusINT.setBounds(250, 110, 200, 20);
		plusINT.setBorder(border2);
		plusINT.addActionListener(listen);
		plusINT.setActionCommand("+INT");	
		bodyPanel.add(plusINT);
		
		plusEND = new JButton("LIFT: +END(8 Energy)");
		plusEND.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusEND.setBackground(Color.GRAY);
		plusEND.setForeground(Color.BLACK);
		plusEND.setBounds(250, 140, 200, 20);
		plusEND.setBorder(border3);
		plusEND.addActionListener(listen);
		plusEND.setActionCommand("+END");	
		bodyPanel.add(plusEND);
		
		plusCHR = new JButton("DRINK: +CHR(4 Energy)");
		plusCHR.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusCHR.setBackground(Color.GRAY);
		plusCHR.setForeground(Color.BLACK);
		plusCHR.setBounds(250, 170, 200, 20);
		plusCHR.setBorder(border4);
		plusCHR.addActionListener(listen);
		plusCHR.setActionCommand("+CHR");	
		bodyPanel.add(plusCHR);
		
		nameLabel = new JLabel("Player Name: ");
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(50, 20, 180, 18);
		bodyPanel.add(nameLabel);
		
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
		
		charismaLabel = new JLabel("CHR: " + charisma);
		charismaLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		charismaLabel.setForeground(Color.WHITE);
		charismaLabel.setBounds(50, 170, 176, 20);
		bodyPanel.add(charismaLabel);
	}

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
		
		this.energyLabel.setText("Energy: " + energy);
	}
	
	public void updateTraits(int intelligence, int endurance, int charisma){
		this.intelligence = intelligence;	
		this.endurance = endurance;
		this.charisma = charisma;
		
		this.intelligenceLabel.setText("INT: " + intelligence);
		this.enduranceLabel.setText("END: " + endurance);
		this.charismaLabel.setText("CHR: " + charisma);
	}

	@Override
	public void updateTimer(int time) {
		// TODO Auto-generated method stub

	}
	
	public void increaseINT(){
		if(energy >= 5){
			character.setIntelligence(1);
			character.damageEnergy(5);
		}
	}
	
	public void increaseEND(){
		if(energy >= 5){
			character.setEndurance(1);
			character.damageEnergy(8);
		}
	}
	
	public void increaseCHR(){
		if(energy >= 5){
			character.setCharisma(1);
			character.damageEnergy(4);
		}
	}

	public class NightMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("nextDay")) 
				sim.startDay();
			if (event.getActionCommand().equals("+INT"))
				increaseINT();
			if (event.getActionCommand().equals("+END"))
				increaseEND();
			if (event.getActionCommand().equals("+CHR"))
				increaseCHR();
		}
	}

}
