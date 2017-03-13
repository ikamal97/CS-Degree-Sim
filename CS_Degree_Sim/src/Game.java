import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements Subject {
	private Character player;
	private EventTimer eventTimer;
	private Timer timer;
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
	
	public void startDay(){
		System.out.println("Day is starting");
		eventTimer = new EventTimer();
	}
	
	public class EventTimer{
	    Timer timer;
	    int seconds = 5;
	    
	    public EventTimer() {
	        timer = new Timer();
	        timer.schedule(new EventTimerTask(), 0, 1*1000);
	    }
	    
	    class EventTimerTask extends TimerTask{
	    	public void run() {
	    		System.out.println("second: " + seconds);
	    		seconds--;
	    		if(seconds == 0){
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
	
	
	
	public abstract class Event{
		
	}
	

}
