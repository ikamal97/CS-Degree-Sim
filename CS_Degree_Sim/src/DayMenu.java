import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class DayMenu extends JPanel implements Observer, DisplayMenu {

	private Character character;
	private int morale, energy, time;
	private csDegreeSim sim;
	private Game game;
	private int button = 0;
	private Image background, characterSprite;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel, timerLabel, moraleLabel, energyLabel;
	private JLabel characterSpriteLabel, backgroundLabel;
	private JButton quit, endDay;
	private DayMenuListener listen;
	
	
	public DayMenu(csDegreeSim sim, Game game, Character character){
		this.sim = sim;
		this.character = character;
		this.game = game;
		this.time = 0;
		
		character.registerObserver(this);
		game.registerObserver(this);
		
		character.resetDailyEnergy();
		initialCharacterInfo();
		
		createPanels();
		
		listen = new DayMenuListener();
		
		createComponents();
	}
	
	public void createPanels(){
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		bodyPanel = new JPanel();
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		background = Toolkit.getDefaultToolkit().getImage("images/day_menu_background_600x402.png");
	}
	
	public void createComponents(){
		quit = new JButton("QUIT");
		quit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		quit.setBackground(Color.ORANGE);
		quit.setForeground(Color.WHITE);
		quit.setBounds(310, 350, 172, 30);
		quit.setBorder(border);
		quit.addActionListener(listen);
		quit.setActionCommand("quit");;	
		bodyPanel.add(quit);
		
		endDay = new JButton("END DAY");
		endDay.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 2);
		endDay.setBackground(Color.ORANGE);
		endDay.setForeground(Color.WHITE);
		endDay.setBounds(310, 310, 172, 30);
		endDay.setBorder(border2);
		endDay.addActionListener(listen);
		endDay.setActionCommand("endDay");	
		bodyPanel.add(endDay);
		
		timerLabel = new JLabel("Time: " + time);
		timerLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		timerLabel.setForeground(Color.WHITE);
		timerLabel.setBounds(500, 10, 176, 18);
		bodyPanel.add(timerLabel);
		
		moraleLabel = new JLabel("Morale: " + morale);
		moraleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		moraleLabel.setForeground(Color.WHITE);
		moraleLabel.setBounds(10, 10, 176, 18);
		bodyPanel.add(moraleLabel);
		
		energyLabel = new JLabel("Energy: " + energy);
		energyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		energyLabel.setForeground(Color.WHITE);
		energyLabel.setBounds(10, 40, 176, 20);
		bodyPanel.add(energyLabel);
		
		characterSpriteLabel = new JLabel(new ImageIcon(characterSprite));
		characterSpriteLabel.setBounds(100, 200, 120, 300);
		bodyPanel.add(characterSpriteLabel);
		
		backgroundLabel = new JLabel(new ImageIcon(background));
		backgroundLabel.setBounds(0, 0, 600, 400);
		bodyPanel.add(backgroundLabel);
		
	}
	
	public void initialCharacterInfo(){
		this.morale = character.getMorale();
		this.energy = character.getEnergy();
		this.characterSprite = character.getCharacterSprite();
	}
	
	public void updateStats(int morale, int energy){
		this.morale = morale;
		this.energy = energy;
		
		this.moraleLabel.setText("Morale: " + morale);
		this.energyLabel.setText("Energy: " + energy);
	}
	
	public void updateTraits(int intelligence, int endurance, int charisma){
		
		//display();
	}
	
	public void updateTimer(int time){
		this.time = time;
		this.timerLabel.setText("Time: " + time);
		if(time == 10)
			endDay.setBackground(Color.GREEN);
	}
	
	public class DayMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("quit")) {
				game.stopTimer();
				sim.startGame();
			}
			if (event.getActionCommand().equals("endDay")) {
				if(time == 10){
					sim.endDay();
				}
			}
		}
	}

}
