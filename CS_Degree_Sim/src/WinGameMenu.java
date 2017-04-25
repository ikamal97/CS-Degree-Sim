import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class WinGameMenu extends JPanel implements Observer{

	private Character character;
	private csDegreeSim sim;
	private Game game;
	private Image background;
	private JPanel bodyPanel, headerPanel;
	private JLabel moraleLabel, energyLabel, nameLabel, winLabel;
	private JLabel intelligenceLabel, enduranceLabel, charismaLabel, backgroundLabel; 

	public WinGameMenu(csDegreeSim sim, Game game, Character character){
		this.sim = sim;
		this.character = character;
		this.game = game;

		character.registerObserver(this);
		game.registerObserver(this);

		createPanels();

		createComponents();
	}

	public void createPanels() {
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));

		bodyPanel = new JPanel();
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);

		background = Toolkit.getDefaultToolkit().getImage("images/night_menu_background_600x402.png");
	}
	
	public void createComponents() {
		winLabel = new JLabel("CONGRATS GRAD! YOU GOT YOUR DEGREE!");
		winLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		winLabel.setBackground(Color.WHITE);
		winLabel.setForeground(Color.BLACK);
		winLabel.setOpaque(true);
		winLabel.setBounds(25, 340, 300, 30);
		winLabel.setBorder(border);
		bodyPanel.add(winLabel);
		
		nameLabel = new JLabel("Player Name: " + character.getName());
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(25, 20, 300, 22);
		bodyPanel.add(nameLabel);
		
		moraleLabel = new JLabel("Morale: " + character.getMorale());
		moraleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		moraleLabel.setForeground(Color.WHITE);
		moraleLabel.setBounds(25, 50, 176, 18);
		bodyPanel.add(moraleLabel);
		
		energyLabel = new JLabel("Energy: " + character.getEnergy());
		energyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		energyLabel.setForeground(Color.WHITE);
		energyLabel.setBounds(25, 80, 176, 20);
		bodyPanel.add(energyLabel);
		
		intelligenceLabel = new JLabel("INT: " + character.getInt());
		intelligenceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		intelligenceLabel.setForeground(Color.WHITE);
		intelligenceLabel.setBounds(25, 110, 176, 20);
		bodyPanel.add(intelligenceLabel);
		
		enduranceLabel = new JLabel("END: " + character.getEnd());
		enduranceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		enduranceLabel.setForeground(Color.WHITE);
		enduranceLabel.setBounds(25, 140, 176, 20);
		bodyPanel.add(enduranceLabel);
		
		charismaLabel = new JLabel("CHR: " + character.getChr());
		charismaLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		charismaLabel.setForeground(Color.WHITE);
		charismaLabel.setBounds(25, 170, 176, 20);
		bodyPanel.add(charismaLabel);
		
		
		backgroundLabel = new JLabel(new ImageIcon(background));
		backgroundLabel.setBounds(0, 0, 600, 400);
		bodyPanel.add(backgroundLabel);
	}


	@Override
	public void updateStats(int morale, int energy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTraits(int intelligence, int endurance, int charisma) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTimer(int time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayMessage(boolean isEnabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCalendar() {
		// TODO Auto-generated method stub

	}

}
