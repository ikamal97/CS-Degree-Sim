import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class NightMenu extends JPanel implements Observer, DisplayMenu {

	private Character character;
	private int morale, energy, intelligence, endurance, charisma;
	private String characterName;
	private csDegreeSim sim;
	private Game game;
	private int button = 0;
	private Image background;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel, timerLabel, moraleLabel, energyLabel, nameLabel;
	private JLabel intelligenceLabel, enduranceLabel, charismaLabel, backgroundLabel; 
	private JButton startGame, plusINT, plusEND, plusCHR;
	private JButton quit, nextDay;
	private NightMenuListener listen;
	
	public NightMenu(csDegreeSim sim, Game game, Character character){
		this.sim = sim;
		this.character = character;
		this.game = game;
		
		character.registerObserver(this);
		game.registerObserver(this);
		
		initialCharacterInfo();
		
		createPanels();
		
		listen = new NightMenuListener();
		
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
		nextDay = new JButton("NEXT WEEK");
		nextDay.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		nextDay.setBackground(Color.WHITE);
		nextDay.setForeground(Color.BLACK);
		nextDay.setOpaque(true);
		nextDay.setBounds(25, 340, 300, 30);
		nextDay.setBorder(border);
		nextDay.addActionListener(listen);
		nextDay.setActionCommand("nextDay");
		nextDay.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				nextDay.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				nextDay.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(nextDay);
		
		plusINT = new JButton("STUDY: +INT(5 Energy)");
		plusINT.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusINT.setBackground(Color.WHITE);
		plusINT.setForeground(Color.BLACK);
		plusINT.setOpaque(true);
		plusINT.setBounds(25, 200, 200, 20);
		plusINT.setBorder(border2);
		plusINT.addActionListener(listen);
		plusINT.setActionCommand("+INT");
		plusINT.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				plusINT.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				plusINT.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(plusINT);
		
		plusEND = new JButton("LIFT: +END(8 Energy)");
		plusEND.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusEND.setBackground(Color.WHITE);
		plusEND.setForeground(Color.BLACK);
		plusEND.setOpaque(true);
		plusEND.setBounds(25, 230, 200, 20);
		plusEND.setBorder(border3);
		plusEND.addActionListener(listen);
		plusEND.setActionCommand("+END");	
		plusEND.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				plusEND.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				plusEND.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(plusEND);
		
		plusCHR = new JButton("DRINK: +CHR(4 Energy)");
		plusCHR.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusCHR.setBackground(Color.WHITE);
		plusCHR.setForeground(Color.BLACK);
		plusCHR.setOpaque(true);
		plusCHR.setBounds(25, 260, 200, 20);
		plusCHR.setBorder(border4);
		plusCHR.addActionListener(listen);
		plusCHR.setActionCommand("+CHR");	
		plusCHR.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				plusCHR.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				plusCHR.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(plusCHR);
		
		nameLabel = new JLabel("Player Name: " + characterName);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(25, 20, 300, 22);
		bodyPanel.add(nameLabel);
		
		moraleLabel = new JLabel("Morale: " + morale);
		moraleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		moraleLabel.setForeground(Color.WHITE);
		moraleLabel.setBounds(25, 50, 176, 18);
		bodyPanel.add(moraleLabel);
		
		energyLabel = new JLabel("Energy: " + energy);
		energyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		energyLabel.setForeground(Color.WHITE);
		energyLabel.setBounds(25, 80, 176, 20);
		bodyPanel.add(energyLabel);
		
		intelligenceLabel = new JLabel("INT: " + intelligence);
		intelligenceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		intelligenceLabel.setForeground(Color.WHITE);
		intelligenceLabel.setBounds(25, 110, 176, 20);
		bodyPanel.add(intelligenceLabel);
		
		enduranceLabel = new JLabel("END: " + endurance);
		enduranceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		enduranceLabel.setForeground(Color.WHITE);
		enduranceLabel.setBounds(25, 140, 176, 20);
		bodyPanel.add(enduranceLabel);
		
		charismaLabel = new JLabel("CHR: " + charisma);
		charismaLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		charismaLabel.setForeground(Color.WHITE);
		charismaLabel.setBounds(25, 170, 176, 20);
		bodyPanel.add(charismaLabel);
		
		backgroundLabel = new JLabel(new ImageIcon(background));
		backgroundLabel.setBounds(0, 0, 600, 400);
		bodyPanel.add(backgroundLabel);
	}

	public void initialCharacterInfo(){
		this.characterName = character.getName();
		this.morale = character.getMorale();
		this.energy = character.getEnergy();
		this.intelligence = character.getInt();
		this.endurance = character.getEnd();
		this.charisma = character.getChr();
	}
	
	public void updateStats(int morale, int energy){
		this.morale = morale;
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
		if(energy >= 8){
			character.setEndurance(1);
			character.damageEnergy(8);
		}
	}
	
	public void increaseCHR(){
		if(energy >= 4){
			character.setCharisma(1);
			character.damageEnergy(4);
		}
	}
	
	public void displayMessage(boolean isEnabled){
		
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

	@Override
	public void updateCalendar() {
		// TODO Auto-generated method stub
		
	}

}
