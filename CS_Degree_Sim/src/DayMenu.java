import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class DayMenu extends JPanel implements Observer, DisplayMenu {

	private Character character;
	private int moral, energy, time;
	private csDegreeSim sim;
	private Game game;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel, timerLabel, moralLabel, energyLabel;
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
		initialCharacterInfo(character.getMorale(), character.getEnergy());
		
		createPanels();
		
		listen = new DayMenuListener();
		
		createComponents();
		
	}
	
	public void createPanels(){
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
	}
	
	public void createComponents(){
		quit = new JButton("QUIT");
		quit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		quit.setBackground(Color.ORANGE);
		quit.setForeground(Color.GRAY);
		quit.setBounds(110, 300, 172, 30);
		quit.setBorder(border);
		quit.addActionListener(listen);
		quit.setActionCommand("quit");;	
		bodyPanel.add(quit);
		
		endDay = new JButton("END DAY");
		endDay.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.GRAY, 2);
		endDay.setBackground(Color.ORANGE);
		endDay.setForeground(Color.GRAY);
		endDay.setBounds(310, 300, 172, 30);
		endDay.setBorder(border2);
		endDay.addActionListener(listen);
		endDay.setActionCommand("endDay");	
		bodyPanel.add(endDay);
		
		timerLabel = new JLabel("Time: " + time);
		timerLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		timerLabel.setForeground(Color.WHITE);
		timerLabel.setBounds(500, 10, 176, 18);
		bodyPanel.add(timerLabel);
		
		moralLabel = new JLabel("Moral: " + moral);
		moralLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		moralLabel.setForeground(Color.WHITE);
		moralLabel.setBounds(10, 10, 176, 18);
		bodyPanel.add(moralLabel);
		
		energyLabel = new JLabel("Energy: " + energy);
		energyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		energyLabel.setForeground(Color.WHITE);
		energyLabel.setBounds(10, 40, 176, 20);
		bodyPanel.add(energyLabel);
		
	}
	
	public void initialCharacterInfo(int moral, int energy){
		this.moral = moral;
		this.energy = energy;
	}
	
	public void updateStats(int moral, int energy){
		this.moral = moral;
		this.energy = energy;
		
		this.moralLabel.setText("Moral: " + moral);
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
