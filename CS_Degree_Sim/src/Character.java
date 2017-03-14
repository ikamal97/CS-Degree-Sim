import java.util.ArrayList;

public class Character implements Subject {
	private String name;
	private int morale, energy, maxEnergy;
	private int intelligence, endurance, charisma;
	private ArrayList<Observer> observers;
	
	public Character(){
		observers = new ArrayList<Observer>();
		name = "New Character";
		morale = 100;
		maxEnergy = 20;
		energy = 20;
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
	
	public int getMaxEnergy(){
		return maxEnergy;
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
	
	public void increaseMorale(int increase){
		morale += increase;
		notifyObservers();
	}
	
	public void increaseEnergy(int increase){
		energy += increase;
		notifyObservers();
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
	
	public void setCharisma(int value){
		charisma += value;
		System.out.println(charisma);
		notifyObservers();
	}
	
	public void resetDailyEnergy(){
		energy = maxEnergy;
	}
	

}
