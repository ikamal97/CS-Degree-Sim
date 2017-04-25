import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class NewGameMenu extends JPanel implements Observer, DisplayMenu {

	private int initialCharacterPoints;
	private Character character;
	private int morale, energy, intelligence, endurance, charisma; 
	private csDegreeSim sim;
	private int characterPoints = 10;
	private int spriteNum = 0;
	private JPanel bodyPanel;
	private Image characterSprite;
	private Image spriteArray[] = new Image[3];
	private JTextField playerName;
	private JLabel headerLabel, moraleLabel, energyLabel, nameLabel;
	private JLabel intelligenceLabel, enduranceLabel, charismaLabel; 
	private JLabel characterPointsLabel, characterSpriteLabel;
	private JButton startGame, minusINT, plusINT, minusEND, plusEND;
	private JButton minusCHR, plusCHR, prevSprite, nextSprite;
	private NewGameMenuListener listen;


	public NewGameMenu(csDegreeSim sim, Character character){
		this.sim = sim;
		this.character = character;
		character.registerObserver(this);

		getAllCharacterSprites();

		initialCharacterInfo();

		createPanels();

		listen = new NewGameMenuListener();

		createComponents();

	}

	public void createPanels(){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 350));

		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.BLUE);
		add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(null);
	}

	public void createComponents(){

		startGame = new JButton("START GAME");
		startGame.setFont(new Font("Dialog", Font.BOLD, 30));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		startGame.setBackground(Color.WHITE);
		startGame.setForeground(Color.BLACK);
		startGame.setOpaque(true);
		startGame.setBounds(210, 300, 300, 30);
		startGame.setBorder(border);
		startGame.addActionListener(listen);
		startGame.setActionCommand("startGame");
		// Controls the mouse hover effect that changes the button color
		startGame.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				startGame.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				startGame.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(startGame);

		minusINT = new JButton("-");
		minusINT.setFont(new Font("Dialog", Font.BOLD, 15));
		minusINT.setBackground(Color.WHITE);
		minusINT.setForeground(Color.BLACK);
		minusINT.setOpaque(true);
		minusINT.setBounds(200, 110, 46, 20);
		minusINT.setBorder(border);
		minusINT.addActionListener(listen);
		minusINT.setActionCommand("-INT");
		minusINT.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				minusINT.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				minusINT.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(minusINT);

		plusINT = new JButton("+");
		plusINT.setFont(new Font("Dialog", Font.BOLD, 15));
		plusINT.setBackground(Color.WHITE);
		plusINT.setForeground(Color.BLACK);
		plusINT.setOpaque(true);
		plusINT.setBounds(250, 110, 52, 20);
		plusINT.setBorder(border);
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

		minusEND = new JButton("-");
		minusEND.setFont(new Font("Dialog", Font.BOLD, 15));
		minusEND.setBackground(Color.WHITE);
		minusEND.setForeground(Color.BLACK);
		minusEND.setOpaque(true);
		minusEND.setBounds(200, 140, 46, 20);
		minusEND.setBorder(border);
		minusEND.addActionListener(listen);
		minusEND.setActionCommand("-END");	
		minusEND.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				minusEND.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				minusEND.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(minusEND);

		plusEND = new JButton("+");
		plusEND.setFont(new Font("Dialog", Font.BOLD, 15));
		plusEND.setBackground(Color.WHITE);
		plusEND.setForeground(Color.BLACK);
		plusEND.setOpaque(true);
		plusEND.setBounds(250, 140, 52, 20);
		plusEND.setBorder(border);
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

		minusCHR = new JButton("-");
		minusCHR.setFont(new Font("Dialog", Font.BOLD, 15));
		minusCHR.setBackground(Color.WHITE);
		minusCHR.setForeground(Color.BLACK);
		minusCHR.setOpaque(true);
		minusCHR.setBounds(200, 170, 46, 20);
		minusCHR.setBorder(border);
		minusCHR.addActionListener(listen);
		minusCHR.setActionCommand("-CHR");
		minusCHR.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				minusCHR.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				minusCHR.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(minusCHR);

		plusCHR = new JButton("+");
		plusCHR.setFont(new Font("Dialog", Font.BOLD, 15));
		plusCHR.setBackground(Color.WHITE);
		plusCHR.setForeground(Color.BLACK);
		plusCHR.setOpaque(true);
		plusCHR.setBounds(250, 170, 52, 20);
		plusCHR.setBorder(border);
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

		prevSprite = new JButton("<");
		prevSprite.setFont(new Font("Dialog", Font.BOLD, 15));
		prevSprite.setBackground(Color.WHITE);
		prevSprite.setForeground(Color.BLACK);
		prevSprite.setOpaque(true);
		prevSprite.setBounds(350, 150, 20, 20);
		prevSprite.setBorder(border);
		prevSprite.addActionListener(listen);
		prevSprite.setActionCommand("<");	
		prevSprite.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				prevSprite.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				prevSprite.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(prevSprite);

		nextSprite = new JButton(">");
		nextSprite.setFont(new Font("Dialog", Font.BOLD, 15));
		nextSprite.setBackground(Color.WHITE);
		nextSprite.setForeground(Color.BLACK);
		nextSprite.setOpaque(true);
		nextSprite.setBounds(550, 150, 20, 20);
		nextSprite.setBorder(border);
		nextSprite.addActionListener(listen);
		nextSprite.setActionCommand(">");
		nextSprite.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent evt) {
				nextSprite.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent evt) {
				nextSprite.setBackground(Color.WHITE);
			}
		});
		bodyPanel.add(nextSprite);

		nameLabel = new JLabel("Player Name: ");
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(50, 20, 180, 18);
		bodyPanel.add(nameLabel);

		playerName = new JTextField();
		playerName.setText("New Player");
		playerName.setBounds(190, 20, 114, 23);
		bodyPanel.add(playerName);
		playerName.setColumns(15);

		moraleLabel = new JLabel("Morale: " + morale);
		moraleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		moraleLabel.setForeground(Color.WHITE);
		moraleLabel.setBounds(50, 50, 176, 18);
		bodyPanel.add(moraleLabel);

		energyLabel = new JLabel("Energy: " + energy);
		energyLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		energyLabel.setForeground(Color.WHITE);
		energyLabel.setBounds(50, 80, 176, 20);
		bodyPanel.add(energyLabel);

		characterPointsLabel = new JLabel("Points: " + characterPoints);
		characterPointsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		characterPointsLabel.setForeground(Color.WHITE);
		characterPointsLabel.setBounds(180, 50, 176, 20);
		bodyPanel.add(characterPointsLabel);

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

		characterSpriteLabel = new JLabel(new ImageIcon(spriteArray[0]));
		characterSpriteLabel.setBounds(400, 10, 120, 300);
		bodyPanel.add(characterSpriteLabel);

	}

	public void initialCharacterInfo(){
		this.morale = character.getMorale();
		this.energy = character.getEnergy();
		this.intelligence = character.getInt();
		this.endurance = character.getEnd();
		this.charisma = character.getChr();

		character.setCharacterSprite(spriteArray[0]);
	}

	public void updateStats(int morale, int energy){
		this.morale = morale;
		this.energy = energy;
		//display();
	}

	public void updateTraits(int intelligence, int endurance, int charisma){
		this.intelligence = intelligence;	
		this.endurance = endurance;
		this.charisma = charisma;

		this.intelligenceLabel.setText("INT: " + intelligence);
		this.enduranceLabel.setText("END: " + endurance);
		this.charismaLabel.setText("CHR: " + charisma);
	}

	public void getAllCharacterSprites(){
		spriteArray[0] = Toolkit.getDefaultToolkit().getImage("images/character1.png");
		spriteArray[1] = Toolkit.getDefaultToolkit().getImage("images/character2.png");
		spriteArray[2] = Toolkit.getDefaultToolkit().getImage("images/character3.png");
	}

	public void updateTimer(int time){
		//display();
	}
	
	public void displayMessage(boolean isEnabled){
		
	}

	//public void display(){
	//code for updating display
	//}

	public class NewGameMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("startGame")) {
				character.setName(playerName.getText());
				sim.startDay();
			}
			if (event.getActionCommand().equals("-INT"))
				subInt();
			if (event.getActionCommand().equals("+INT"))
				addInt();
			if (event.getActionCommand().equals("-END"))
				subEnd();
			if (event.getActionCommand().equals("+END"))
				addEnd();
			if (event.getActionCommand().equals("-CHR"))
				subChr();
			if (event.getActionCommand().equals("+CHR"))
				addChr();
			if (event.getActionCommand().equals("<"))
				prevSprite();
			if (event.getActionCommand().equals(">"))
				nextSprite();
		}
	}

	public void addInt(){
		if(characterPoints > 0){
			character.setIntelligence(1);
			characterPoints--;
		}
		this.characterPointsLabel.setText("Points: " + characterPoints);
	}
	public void addEnd(){
		if(characterPoints > 0){
			character.setEndurance(1);
			characterPoints--;
		}
		this.characterPointsLabel.setText("Points: " + characterPoints);
	}
	public void addChr(){
		if(characterPoints > 0){
			character.setCharisma(1);
			characterPoints--;
		}
		this.characterPointsLabel.setText("Points: " + characterPoints);
	}

	public void subInt(){
		if(character.getInt() > 0){
			character.setIntelligence(-1);
			characterPoints++;
		}
		this.characterPointsLabel.setText("Points: " + characterPoints);
	}
	public void subEnd(){
		if(character.getEnd() > 0){
			character.setEndurance(-1);
			characterPoints++;
		}
		this.characterPointsLabel.setText("Points: " + characterPoints);
	}
	public void subChr(){
		if(character.getChr() > 0){
			character.setCharisma(-1);
			characterPoints++;
		}
		this.characterPointsLabel.setText("Points: " + characterPoints);
	}

	public void nextSprite(){
		spriteNum++;
		if(spriteNum == 3){
			spriteNum = 0;
		}
		character.setCharacterSprite(spriteArray[spriteNum]);
		characterSpriteLabel.setIcon(new ImageIcon(spriteArray[spriteNum]));
	}

	public void prevSprite(){
		spriteNum--;
		if(spriteNum == -1){
			spriteNum = 2;
		}
		character.setCharacterSprite(spriteArray[spriteNum]);
		characterSpriteLabel.setIcon(new ImageIcon(spriteArray[spriteNum]));
	}

	@Override
	public void updateCalendar() {
		// TODO Auto-generated method stub
		
	}

}
