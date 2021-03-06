import java.util.ArrayList;

public class Calendar implements Subject{
	private String month[] = {"August", "September", "October", "November", "December", "January", "February", "March", "April", "May"};
	private int[] day = {31, 30, 31, 30, 31, 31, 28, 31, 30, 31};
	private int currentMonth;
	private int currentDay;
	private int currentYear;
	private int index; //The max day for that month
	private int week;
	
	private ArrayList<Observer> observers;

	public Calendar(){
		observers = new ArrayList<Observer>();
		week = 1;
		index = 0;
		
		currentYear = 2017;
		currentMonth = index;
		currentDay = 0;
	}

	/* Increments the calendar to next week */
	public void nextWeek(){
		System.out.println("Week: " + week);
		// End of month case
		if(currentDay+7 >= day[index]){
			index++;
			week++;
			currentDay = 1;
			currentMonth = index; 
		}
		// End of year case
		else if(currentMonth == 4 && currentDay == day[4]){
			index++;
			week++;
			currentDay = 1;
			currentYear = 2018;
		}
		else{
			currentDay+=7;
			week++;
		}
		notifyObservers();
	}
	
	public int getWeek(){
		return week;
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
