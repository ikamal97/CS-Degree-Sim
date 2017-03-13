import java.util.ArrayList;

public class Character implements Subject {
	private String name;
	private int morale, energy;
	private int intelligence, endurance, charisma;
	private ArrayList<Observer> observers;
	
	public Character(){
		observers = new ArrayList<Observer>();
		name = "New Character";
		morale = 50;
		energy = 15;
		intelligence = 5;
		endurance = 5;
		charisma = 5;
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
			observer.update(morale, energy);
		}
	}
	
	public int getMorale(){
		return morale;
	}
	
	public int getEnergy(){
		return energy;
	}
	
	public void setMorale(int damage){
		morale -= damage;
		notifyObservers();
	}
	
	public void setEnergy(int damage){
		energy -= damage;
		notifyObservers();
	}
	

}
