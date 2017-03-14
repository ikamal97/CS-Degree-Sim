import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements Subject {
	private Character character;
	public EventTimer eventTimer;
	private Timer timer;
	//public int seconds;
	private ArrayList<Observer> observers;
	
	
	public Game(Character character){
		this.character = character;
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
		for(Observer observer : observers){
			observer.updateTimer(eventTimer.seconds);
		}	
	}
	
	public void depleteEnergy(){
		if(character.getEnergy() > 0)
			character.damageEnergy(1);
	}
	
	public void startDay(){
		System.out.println("Day is starting");
		eventTimer = new EventTimer();
	}
	
	public void stopTimer(){
		timer.cancel();
	}
	
	public class EventTimer{
	    //Timer timer;
	    int seconds = 1;
	    
	    public EventTimer() {
	        timer = new Timer();
	        timer.schedule(new EventTimerTask(), 0, 1*1000);
	    }
	    
	    public int getSeconds(){
	    	return seconds;
	    }
	    
	    class EventTimerTask extends TimerTask{
	    	public void run() {
	    		System.out.println("second: " + seconds);
	    		notifyObservers();
	    		depleteEnergy();
	    		eventSelector();
	    		seconds++;
	    		if(seconds == 11){
	    			timer.cancel();
	    			return;
	    		}
	    	}
	    }	
	}
	
	public int randomNumberGenerator(){
		Random RNG = new Random();
		int randomNumber = RNG.nextInt(100); //0-100
		return randomNumber;
	}
	
	
	public Event chooseEventType(int randomNumber){
		if(randomNumber >=0 && randomNumber <= 50){
			System.out.println("Good Event");
			GoodEvent goodEvent = new GoodEvent();
			return goodEvent;
		}
		else if(randomNumber > 50 && randomNumber <= 100){
		    System.out.println("Bad Event");
		    BadEvent badEvent = new BadEvent();
		    return badEvent;
		     
		}
	    
	  return null;
	}
	
	public void eventSelector(){
		int randomNumber = randomNumberGenerator();
		
		Event event = chooseEventType(randomNumber);
		
	}

	public abstract class Event{
	
	
	   
	}
	
	public class GoodEvent extends Event{

		public GoodEvent() {
			
			// TODO Auto-generated constructor stub
		}
		
	}
	public class BadEvent extends Event{

		public BadEvent() {
			
		}
		
	}
	

}
