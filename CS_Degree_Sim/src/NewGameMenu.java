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
		startGame.setBackground(Color.GRAY);
		startGame.setForeground(Color.BLACK);
		startGame.setBounds(210, 300, 300, 30);
		startGame.setBorder(border);
		startGame.addActionListener(listen);
		startGame.setActionCommand("startGame");	
		bodyPanel.add(startGame);
		
		minusINT = new JButton("-");
		minusINT.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
		minusINT.setBackground(Color.GRAY);
		minusINT.setForeground(Color.BLACK);
		minusINT.setBounds(200, 110, 46, 20);
		minusINT.setBorder(border2);
		minusINT.addActionListener(listen);
		minusINT.setActionCommand("-INT");	
		bodyPanel.add(minusINT);
		
		plusINT = new JButton("+");
		plusINT.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusINT.setBackground(Color.GRAY);
		plusINT.setForeground(Color.BLACK);
		plusINT.setBounds(250, 110, 52, 20);
		plusINT.setBorder(border3);
		plusINT.addActionListener(listen);
		plusINT.setActionCommand("+INT");	
		bodyPanel.add(plusINT);
		
		minusEND = new JButton("-");
		minusEND.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
		minusEND.setBackground(Color.GRAY);
		minusEND.setForeground(Color.BLACK);
		minusEND.setBounds(200, 140, 46, 20);
		minusEND.setBorder(border4);
		minusEND.addActionListener(listen);
		minusEND.setActionCommand("-END");	
		bodyPanel.add(minusEND);
		
		plusEND = new JButton("+");
		plusEND.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border5 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusEND.setBackground(Color.GRAY);
		plusEND.setForeground(Color.BLACK);
		plusEND.setBounds(250, 140, 52, 20);
		plusEND.setBorder(border5);
		plusEND.addActionListener(listen);
		plusEND.setActionCommand("+END");	
		bodyPanel.add(plusEND);
		
		minusCHR = new JButton("-");
		minusCHR.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border6 = BorderFactory.createLineBorder(Color.BLACK, 2);
		minusCHR.setBackground(Color.GRAY);
		minusCHR.setForeground(Color.BLACK);
		minusCHR.setBounds(200, 170, 46, 20);
		minusCHR.setBorder(border6);
		minusCHR.addActionListener(listen);
		minusCHR.setActionCommand("-CHR");	
		bodyPanel.add(minusCHR);
		
		plusCHR = new JButton("+");
		plusCHR.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border7 = BorderFactory.createLineBorder(Color.BLACK, 2);
		plusCHR.setBackground(Color.GRAY);
		plusCHR.setForeground(Color.BLACK);
		plusCHR.setBounds(250, 170, 52, 20);
		plusCHR.setBorder(border7);
		plusCHR.addActionListener(listen);
		plusCHR.setActionCommand("+CHR");	
		bodyPanel.add(plusCHR);
		
		prevSprite = new JButton("<");
		prevSprite.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border8 = BorderFactory.createLineBorder(Color.BLACK, 2);
		prevSprite.setBackground(Color.GRAY);
		prevSprite.setForeground(Color.BLACK);
		prevSprite.setBounds(350, 150, 20, 20);
		prevSprite.setBorder(border8);
		prevSprite.addActionListener(listen);
		prevSprite.setActionCommand("<");	
		bodyPanel.add(prevSprite);
		
		nextSprite = new JButton(">");
		nextSprite.setFont(new Font("Dialog", Font.BOLD, 15));
		Border border9 = BorderFactory.createLineBorder(Color.BLACK, 2);
		nextSprite.setBackground(Color.GRAY);
		nextSprite.setForeground(Color.BLACK);
		nextSprite.setBounds(550, 150, 20, 20);
		nextSprite.setBorder(border8);
		nextSprite.addActionListener(listen);
		nextSprite.setActionCommand(">");	
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
		
		characterPointsLabel = new JLabel("Character points: " + characterPoints);
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
		this.characterPointsLabel.setText("Character points: " + characterPoints);
	}
	public void addEnd(){
		if(characterPoints > 0){
			character.setEndurance(1);
			characterPoints--;
		}
		this.characterPointsLabel.setText("Character points: " + characterPoints);
	}
	public void addChr(){
		if(characterPoints > 0){
			character.setCharisma(1);
			characterPoints--;
		}
		this.characterPointsLabel.setText("Character points: " + characterPoints);
	}
	
	public void subInt(){
		if(character.getInt() > 0){
			character.setIntelligence(-1);
			characterPoints++;
		}
		this.characterPointsLabel.setText("Character points: " + characterPoints);
	}
	public void subEnd(){
		if(character.getEnd() > 0){
			character.setEndurance(-1);
			characterPoints++;
		}
		this.characterPointsLabel.setText("Character points: " + characterPoints);
	}
	public void subChr(){
		if(character.getChr() > 0){
			character.setCharisma(-1);
			characterPoints++;
		}
		this.characterPointsLabel.setText("Character points: " + characterPoints);
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

}
