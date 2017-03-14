import java.util.ArrayList;

public class Character implements Subject {
	private String name;
	private int morale, energy;
	private int intelligence, endurance, charisma;
	private ArrayList<Observer> observers;
	
	public Character(){
		observers = new ArrayList<Observer>();
		name = "New Character";
		morale = 100;
		energy = 100;
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
			observer.updateStats(morale, energy);
			observer.updateTraits(intelligence, endurance, charisma);
		}
	}
	
	public int getMorale(){
		return morale;
	}
	
	public int getEnergy(){
		return energy;
	}
	
	public int getInt(){
		return intelligence;
	}
	
	public int getEnd(){
		return endurance;
	}
	
	public int getChr(){
		return charisma;
	}
	
	public void damageMorale(int damage){
		morale -= damage;
		notifyObservers();
	}
	
	public void damageEnergy(int damage){
		energy -= damage;
		notifyObservers();
	}
	
	public void setIntelligence(int value){
		intelligence += value;
		System.out.println(intelligence);
		notifyObservers();
	}
	
	public void setEndurance(int value){
		endurance += value;
		System.out.println(endurance);
		notifyObservers();
	}
	

}
