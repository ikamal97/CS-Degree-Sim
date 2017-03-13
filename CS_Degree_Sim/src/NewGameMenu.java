import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class NewGameMenu extends JPanel implements Observer, DisplayMenu {

	private int screenStats;
	private Subject Character;
	private csDegreeSim sim;
	private int button = 0;
	private JPanel bodyPanel, headerPanel;
	private JLabel headerLabel;
	private JButton quit;
	private NewGameMenuListener listen;
	
	
	public NewGameMenu(csDegreeSim sim){
		this.sim = sim;
		
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

		headerLabel = new JLabel("Character Creation Screen");
		headerPanel.add(headerLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLUE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
	}
	
	public void createButtons(){
		quit = new JButton("START GAME");
		quit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		quit.setBackground(Color.BLUE);
		quit.setForeground(Color.BLACK);
		quit.setBounds(210, 20, 172, 30);
		quit.setBorder(border);
		quit.addActionListener(listen);
		quit.setActionCommand("startGame");
		//newGame.requestFocus();	
		bodyPanel.add(quit);
	}
	
	public void update(int stats, int energy){
		this.screenStats = stats;
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
		}
	}

}
