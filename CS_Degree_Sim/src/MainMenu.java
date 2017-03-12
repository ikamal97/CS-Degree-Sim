import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainMenu extends JPanel implements Observer, DisplayMenu{
	private int screenStats;
	private Subject Character;
	private JPanel panel;
	private csDegreeSim sim;
	private JTextField playerName;

	public MainMenu(csDegreeSim sim){
		this.sim = sim;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));

		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		add(headerPanel, BorderLayout.NORTH);

		JLabel headerLabel = new JLabel("Main Menu");
		headerPanel.add(headerLabel);

		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLUE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);

		JButton newGame = new JButton("NEW GAME");
		newGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		newGame.setBackground(Color.GREEN);
		newGame.setForeground(Color.WHITE);
		newGame.setBounds(210, 20, 170, 30);
		newGame.setBorder(border);
		bodyPanel.add(newGame);

		JButton loadGame = new JButton("LOAD GAME");
		loadGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 1);
		loadGame.setBackground(Color.GREEN);
		loadGame.setForeground(Color.WHITE);
		loadGame.setBounds(205, 90, 183, 30);
		loadGame.setBorder(border2);
		bodyPanel.add(loadGame);

		JButton options = new JButton("OPTIONS");
		options.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 1);
		options.setBackground(Color.GREEN);
		options.setForeground(Color.WHITE);
		options.setBounds(215, 160, 136, 30);
		options.setBorder(border3);
		bodyPanel.add(options);

		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border4 = BorderFactory.createLineBorder(Color.BLACK, 1);
		exit.setBackground(Color.GREEN);
		exit.setForeground(Color.WHITE);
		exit.setBounds(255, 230, 70, 30);
		exit.setBorder(border4);
		bodyPanel.add(exit);


	}

	/*public MainMenu(Subject Character){//recieves reference to subject
		this.Character = Character;
		Character.registerObserver(this);//registers this observer with subject
	}*/

	public void update(int stats){
		this.screenStats = stats;
		display();
	}

	public void display(){
		//code for updating display

	}

}
