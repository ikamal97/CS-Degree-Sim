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
	private Event gameEvent;
	private Calendar calendar;
	private boolean messageEnabled;
	private Image background, characterSprite;
	private JPanel messagePanel;//bodyPanel;
	private JLayeredPane bodyPanel;
	private JLabel timerLabel, moraleLabel, energyLabel, calendarLabel;
	private JLabel characterSpriteLabel, backgroundLabel, messageLabel;
	private JButton quit, endDay, quitMessage, chanceButton, statButton;
	private DayMenuListener listen;
	
	
	public DayMenu(csDegreeSim sim, Game game, Character character){
		this.sim = sim;
		this.character = character;
		this.game = game;
		this.time = 0;
		this.messageEnabled = false;
		this.calendar = new Calendar();
		
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
		setSize(new Dimension(csDegreeSim.Width, csDegreeSim.Height));
		
		//bodyPanel = new JPanel();
		bodyPanel = new JLayeredPane();
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		background = Toolkit.getDefaultToolkit().getImage("images/day_menu_background_600x402.png");
	}
	
	public void createComponents(){
		quit = new JButton("QUIT");
		quit.setFont(new Font("Dialog", Font.BOLD, 30));
		quit.setBackground(Color.WHITE);
		quit.setForeground(Color.BLACK);
		quit.setOpaque(true);
		quit.setBounds(310, 350, 172, 30);
		quit.setBorder(null);
		quit.addActionListener(listen);
		quit.setActionCommand("quit");
		quit.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				quit.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				quit.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(quit);
		
		endDay = new JButton("END DAY");
		endDay.setFont(new Font("Dialog", Font.BOLD, 30));
		endDay.setBackground(Color.GRAY);
		endDay.setForeground(Color.BLACK);
		endDay.setOpaque(true);
		endDay.setBounds(310, 310, 172, 30);
		endDay.setBorder(null);
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
		backgroundLabel.setBounds(0, 0, 600, 402);
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
	
	public void displayMessage(boolean isEnabled){
		if(isEnabled){
			messageEnabled = true;
			
			Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
			
			
			
			gameEvent = game.getEvent();
			
			String html1 = "<html><body style='width: ";
	        String html2 = "px'>";
			
	        if(gameEvent.eventType.equals("simple")){
	        	messagePanel = new JPanel(new GridLayout(2, 1));//new BorderLayout()
				messagePanel.setBackground(Color.GRAY);
				messagePanel.setBounds(100, 100, 400, 200);
				messagePanel.setBorder(border);
				messagePanel.setOpaque(true);
	        	
				messageLabel = new JLabel(html1 + "200" + html2 + gameEvent.dialog);//
				//messageLabel.setFont(new Font("Dialog", Font.BOLD, 12));
				messageLabel.setHorizontalTextPosition(JLabel.CENTER);
				messageLabel.setForeground(Color.WHITE);
				messageLabel.setBounds(150, 150, 400, 18);
				messagePanel.add(messageLabel);
				
				quitMessage = new JButton("OKAY ("+ gameEvent.moralModifier + " moral)");
				quitMessage.setFont(new Font("Dialog", Font.BOLD, 30));
				quitMessage.setBackground(Color.BLUE);
				quitMessage.setForeground(Color.BLACK);
				quitMessage.setOpaque(true);
				quitMessage.setBounds(250, 250, 172, 30);
				quitMessage.setBorder(border);
				quitMessage.addActionListener(listen);
				quitMessage.setActionCommand("okay");	
				messagePanel.add(quitMessage);
	        	
	        }
	        else if(gameEvent.eventType.equals("choice")){
	        	messagePanel = new JPanel(new GridLayout(3, 1));//new BorderLayout()
				messagePanel.setBackground(Color.GRAY);
				messagePanel.setBounds(100, 100, 400, 200);
				messagePanel.setBorder(border);
				messagePanel.setOpaque(true);
	        	
				messageLabel = new JLabel(html1 + "200" + html2 + gameEvent.dialog);//
				//messageLabel.setFont(new Font("Dialog", Font.BOLD, 12));
				messageLabel.setHorizontalTextPosition(JLabel.CENTER);
				messageLabel.setForeground(Color.WHITE);
				messageLabel.setBounds(150, 150, 400, 18);
				messagePanel.add(messageLabel);
				
				chanceButton = new JButton(gameEvent.successChance + "% Success Chance");
				chanceButton.setFont(new Font("Dialog", Font.BOLD, 30));
				chanceButton.setBackground(Color.BLUE);
				chanceButton.setForeground(Color.BLACK);
				chanceButton.setOpaque(true);
				chanceButton.setBounds(250, 250, 172, 30);
				chanceButton.setBorder(border);
				chanceButton.addActionListener(listen);
				chanceButton.setActionCommand("chanceEvent");	
				messagePanel.add(chanceButton);
	        	
				statButton = new JButton(gameEvent.statSuccess + " " + gameEvent.statLimit);
				statButton.setFont(new Font("Dialog", Font.BOLD, 30));
				statButton.setBackground(Color.BLUE);
				statButton.setForeground(Color.BLACK);
				statButton.setOpaque(true);
				statButton.setBounds(250, 250, 172, 30);
				statButton.setBorder(border);
				statButton.addActionListener(listen);
				statButton.setActionCommand("statEvent");	
				messagePanel.add(statButton);
				
	        }
			
		
			bodyPanel.add(messagePanel);
		}
	}
	
	public void removeMessagePanel(){
		bodyPanel.remove(messagePanel);
		bodyPanel.revalidate();
		bodyPanel.repaint();
		messageEnabled = false;
	}
	
	public void rollChanceEvent(int chanceLimit){
		Random RNG = new Random();
		int randomNumber = RNG.nextInt(100); //0-100
		if(randomNumber < chanceLimit){
			character.increaseMorale(gameEvent.moralIncrease);
			System.out.println("Chance event succeeded");
		}
		else{
			character.damageMorale(gameEvent.moralDamage);
			System.out.println("Chance event failed");
		}
	}
	
	public int getStat(String stat){
		switch(stat){
		case "INT":
			return character.getInt();
		case "CHR":
			return character.getChr();
		case "END":
			return character.getEnd();
		default:
			return 0;
		}
	}
	
	public class DayMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("quit")) {
				game.stopTimer();
				sim.startGame();
			}
			if (event.getActionCommand().equals("endDay")) {
				if(time == 10 && messageEnabled == false){
					sim.endDay();
				}
			}
			if (event.getActionCommand().equals("okay")) {
				removeMessagePanel();
				character.modifyMorale(gameEvent.moralModifier);
				game.resumeTimer();	
			}
			if (event.getActionCommand().equals("chanceEvent")) {
				removeMessagePanel();
				rollChanceEvent(gameEvent.successChance);
				game.resumeTimer();	
			}
			if (event.getActionCommand().equals("statEvent")) {
				int statNum = getStat(gameEvent.statLimit);
				if(statNum == gameEvent.statSuccess || statNum > gameEvent.statSuccess){
					removeMessagePanel();
					character.increaseMorale(gameEvent.moralIncrease);
					game.resumeTimer();
				}
					
			}
		}
	}

}
