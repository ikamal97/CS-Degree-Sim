import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class csDegreeSim{
	
	public static void main(String[] args){
		csDegreeSim CSDegreeSimulator = new csDegreeSim();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	CSDegreeSimulator.start();
            }
        });

	}
	
	public csDegreeSim(){
		//constructor
	}
		
	private void start(){
		//new mainMenu/Game/etc...
	}
	
}


interface Subject{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

interface Observer{
	public void update(int stats);
}

interface DisplayElement{
	public void display();
}

class Game implements Subject{
	private ArrayList<Observer> observers;
	
	public Game(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}
	
	public void notifyObservers(){
		
	}
	
}

class Character implements Subject{
	int characterStats;
	private ArrayList<Observer> observers;
	
	public Character(){
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}
	
	//notify all observers that character stats changed and to update
	public void notifyObservers(){
		for(Observer observer : observers){
			observer.update(characterStats);
		}
	}
	
	public void statsChanged(){
		notifyObservers();
	}
	
}

class MainMenu implements Observer, DisplayElement{
	private int screenStats;
	private Subject Character;
	private JLabel label;
	
	
	public MainMenu(Subject Character){//recieves reference to subject
		this.Character = Character;
		Character.registerObserver(this);//registers this observer with subject
	}
	
	public void update(int stats){
		this.screenStats = stats;
		display();
	}
	
	public void display(){
		//code for updating display
		
	}
		
}



