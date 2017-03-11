import java.util.ArrayList;
import javax.swing.*;


public class csDegreeSim{
	
	public static void main(String[] args){
		
	}
	
	public csDegreeSim(){
		
	}
	
	public interface Subject{
		public void registerObserver(Observer o);
		public void removeObserver(Observer o);
		public void notifyObservers();
	}
	
	public interface Observer{
		public void update(int stats);
	}
	
	public interface DisplayElement{
		public void display();
	}
	
	public class Game implements Subject{
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
	
	public class Character implements Subject{
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
		
		public void notifyObservers(){
			
		}
		
	}
	
	public class mainMenu implements Observer, DisplayElement{
		private int screenStats;
		private Subject Character;
		
		public mainMenu(Subject Character){
			this.Character = Character;
			Character.registerObserver(this);
		}
		
		public void update(int stats){
			this.screenStats = stats;
			display();
		}
		
		public void display(){
			//code for updating display
		}
			
	}
	
	
	
	
}

