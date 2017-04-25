import java.util.ArrayList;

public class Calendar implements Subject{
	private String month[] = {"August", "September", "October", "November", "December", "January", "February", "March", "April", "May"};
	private int[] day = {31, 30, 31, 30, 31, 31, 28, 31, 30, 31};
	private int currentMonth;
	private int currentDay;
	private int currentYear;
	private int index; //The max day for that month
	private ArrayList<Observer> observers;

	public Calendar(){
		observers = new ArrayList<Observer>();

		index = 0;
		
		currentYear = 2017;
		currentMonth = index;
		currentDay = 1;
	}

	/* Increments the calendar to tomorrow */
	public void nextDay(){
		// End of month case
		if(currentDay == day[index]){
			index++;
			currentDay = 0;
		}
		// End of year case
		else if(currentMonth == 4 && currentDay == day[4]){
			index++;
			currentDay = 1;
			currentYear = 2018;
		}
		else{
			currentDay++;
		}
		notifyObservers();
	}
	
	public int getYear() {
		return currentYear;
	}
	
	public String getMonth(){
		return month[currentMonth];
	}

	public int getDay() {
		return currentDay;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);		
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.updateCalendar();
		}
	}
	
}
