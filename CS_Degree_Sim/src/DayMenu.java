import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class DayMenu extends JPanel implements Observer, DisplayMenu {

	private int screenStats;
	private Subject Character;
	private int moral, energy, time;
	private csDegreeSim sim;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel;
	private JButton quit;
	private DayMenuListener listen;
	
	
	public DayMenu(csDegreeSim sim){
		this.sim = sim;
		
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
		quit.setBounds(210, 20, 172, 30);
		quit.setBorder(border);
		quit.addActionListener(listen);
		quit.setActionCommand("quit");
		//newGame.requestFocus();	
		bodyPanel.add(quit);
	}
	
	/*public MainMenu(Subject Character){//recieves reference to subject
		this.Character = Character;
		Character.registerObserver(this);//registers this observer with subject
	}*/
	
	
	public void updateStats(int moral, int energy){
		this.moral = moral;
		this.energy = energy;
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
	
	public class DayMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("quit")) 
				sim.startGame();
		}
	}

}
