import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Game implements Subject {
	private Character character;
	public EventTimer eventTimer;
	private Timer timer;
	public int currentSecond;
	public boolean displayMessage;
	public Event event;
	private ArrayList<Observer> observers;

	public Game(){
		this.character = null;
		this.displayMessage = false;
		observers = new ArrayList<Observer>();
	}
	
	public Game(Character character){
		this.character = character;
		observers = new ArrayList<Observer>();
	}

	/* Observer Pattern Functions */
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
			observer.updateTimer(eventTimer.getSeconds());
			observer.displayMessage(displayMessage);
		}	
	}

	/* Character's energy is depleted every second */
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
	
	public void pauseTimer(){
		currentSecond = eventTimer.getSeconds();
		stopTimer();
	}
	
	public void resumeTimer(){
		displayMessage = false;
		event = null;
		if(currentSecond != 10){
			eventTimer = new EventTimer();
			eventTimer.setSeconds(currentSecond + 1);
		}
	}
	
	public int randomNumberGenerator(){
		Random RNG = new Random();
		int randomNumber = RNG.nextInt(100); //0-100
		return randomNumber;
	}

	public void eventSelector(){
		//pauseTimer();
		int randomNumber = randomNumberGenerator();
		event = chooseEventType(randomNumber);
		
		if(event != null){
			displayMessage = true;
			notifyObservers();
			pauseTimer();
		}
	}
	
	public Event getEvent(){
		return event;
	}

	public Event chooseEventType(int randomNumber){
		// 20% Chance of a good event every second
		if(randomNumber >=0 && randomNumber <= 20){
			System.out.println("Simple Event");
			displayGoodEventNotification();
			SimpleEvent simpleEvent = new SimpleEvent();
			return simpleEvent;
		}

		//20% chance of a bad event every second
		else if(randomNumber > 80 && randomNumber <= 100){
			System.out.println("Choice Event");
			ChoiceEvent choiceEvent = new ChoiceEvent();
			return choiceEvent;
		}
		//60% chance of a neutral event every second
		else{
			//System.out.println("Neutral Event");
			return null;
		}
	}

	public void displayGoodEventNotification(){
		JLabel notificationLabel = new JLabel();
	}
	
	public class EventTimer{
	    private int seconds = 1;
	    
	    public EventTimer() {
	        timer = new Timer();
	        timer.schedule(new EventTimerTask(), 0, 1*1000);
	    }
	    
	    public int getSeconds(){
	    	return seconds;
	    }
	    
	    public void setSeconds(int curSecond){
	    	seconds = curSecond;
	    }
	    
	    class EventTimerTask extends TimerTask{
	    	public void run() {
	    		System.out.println("second: " + seconds);
	    		notifyObservers();
	    		depleteEnergy();
	    		eventSelector();
	    		seconds++;
	    		if(seconds == 11 || seconds > 11){
	    			timer.cancel();
	    			return;
	    		}
	    	}
	    }	
	}
}


