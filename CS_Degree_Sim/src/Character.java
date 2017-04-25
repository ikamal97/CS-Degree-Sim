import java.util.ArrayList;
import java.awt.*;

/*
 * A Character has three stats: morale, energy, and charisma
 * and three traits, intelligence, endurance, charisma
 * 
 * Type of Subject that maintains observers (the various menus)
 * 
 * */
public class Character implements Subject {
	private String name;
	private Image characterSprite;
	private int morale, energy, maxEnergy;
	private int intelligence, endurance, charisma;
	private ArrayList<Observer> observers;
	private boolean dropOut;
	
	public Character(){
		observers = new ArrayList<Observer>();
		name = "New Character";
		morale = 100;
		maxEnergy = 20;
		energy = 20;
		intelligence = 5;
		endurance = 5;
		charisma = 5;
		dropOut = false;
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
	
	public String getName(){
		return name;
	}
	
	public Image getCharacterSprite(){
		return characterSprite;
	}
	
	public void increaseMorale(int increase){
		morale += increase;
		notifyObservers();
	}
	
	public void modifyMorale(int modifier){
		morale += modifier;
		notifyObservers();
	}
	
	public void increaseEnergy(int increase){
		energy += increase;
		notifyObservers();
	}
	
	public void damageMorale(int damage){
		morale -= damage;
		if(morale <= 0){
			morale = 0;
			dropOut();
		}
		notifyObservers();
	}
	
	public void dropOut(){
		dropOut = true;
	}
	
	public boolean isDropOut(){
		return dropOut;
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
	
	public void setName(String characterName){
		name = characterName;
	}
	
	public void setCharacterSprite(Image sprite){
		characterSprite = sprite;
	}
	
	public void resetDailyEnergy(){
		energy = maxEnergy;
	}

}
