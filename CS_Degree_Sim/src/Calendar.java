public class Calendar {
	private String month[] = {"August", "September", "October", "November", "December", "January", "February", "March", "April", "May"};
	private int[] day = {31, 30, 31, 30, 31, 31, 28, 31, 30, 31};
	private int currentMonth;
	private int currentDay;
	private int currentYear;
	private int index; //The max day for that month

	public Calendar(){
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
			currentDay = 1;
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
	}
	
	public int getYear() {
		return currentYear;
	}
	
}
