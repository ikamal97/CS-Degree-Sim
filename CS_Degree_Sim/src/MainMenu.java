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
	private Image background;
	private ImageIcon backgroundIcon;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel, titleLabel, backgroundLabel;
	private JButton newGame, loadGame, options, exit;
	private MainMenuListener listen;
	
	public MainMenu(csDegreeSim sim){
		this.sim = sim;
		
		createPanels();
		
		listen = new MainMenuListener();
		//addKeyListener(this);
		
		createComponents();
		
	}
	
	public void createPanels(){
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));
		
		bodyPanel = new JPanel();
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
		
		background = Toolkit.getDefaultToolkit().getImage("images/main_menu_background_600x402.png");
	}

	public void createComponents(){

		newGame = new JButton("NEW GAME");
		newGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		newGame.setBackground(Color.BLACK);
		newGame.setForeground(Color.WHITE);
		newGame.setBounds(210, 205, 200, 30);//210, 90, 200, 30
		newGame.setBorder(border);
		newGame.addActionListener(listen);
		newGame.setActionCommand("newGame");	
		bodyPanel.add(newGame);
		
		loadGame = new JButton("LOAD GAME");
		loadGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.WHITE, 2);
		loadGame.setBackground(Color.BLACK);
		loadGame.setForeground(Color.WHITE);
		loadGame.setBounds(205, 255, 220, 30);//205, 160, 220, 30
		loadGame.setBorder(border2);
		loadGame.addActionListener(listen);
		loadGame.setActionCommand("loadGame");
		bodyPanel.add(loadGame);
		
		options = new JButton("OPTIONS");
		options.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border3 = BorderFactory.createLineBorder(Color.WHITE, 2);
		options.setBackground(Color.BLACK);
		options.setForeground(Color.WHITE);
		options.setBounds(215, 305, 200, 30);//215, 230, 200, 30
		options.setBorder(border3);
		options.addActionListener(listen);
		options.setActionCommand("options");
		bodyPanel.add(options);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border4 = BorderFactory.createLineBorder(Color.WHITE, 2);
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBounds(255, 355, 110, 30);//255, 300, 110, 30
		exit.setBorder(border4);
		exit.addActionListener(listen);
		exit.setActionCommand("exit");
		bodyPanel.add(exit);
		
		backgroundLabel = new JLabel(new ImageIcon(background));
		backgroundLabel.setBounds(0, 0, 600, 400);
		bodyPanel.add(backgroundLabel);
		
		
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
