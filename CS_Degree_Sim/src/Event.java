import java.awt.Image;
import java.util.Random;

public abstract class Event {
	private Image background;
	public String eventType;
	public String dialog;
	public String statLimit;
	public int statSuccess;
	public int successChance;
	public int moralModifier;
	public int moralDamage;
	public int moralIncrease;
	public int energyDamage;
	public int energyIncrease;
	
	public int randomNumberGenerator(int numLimit){
		Random RNG = new Random();
		int randomNumber = RNG.nextInt(numLimit); //0-numLimit
		return randomNumber;
	}
	
}

class SimpleEvent extends Event{
	int eventNum;
	int eventRange = 3;
	
	public SimpleEvent() {
		eventType = "simple";
		eventNum = randomNumberGenerator(eventRange);//0-1
		selectEvent(eventNum);
	}
	
	public void selectEvent(int eventNumber){
		switch(eventNumber){
		case 0:
			dialog = "A Professor has extended an assignment deadline by a week.";
			moralModifier = 2;
			return;
		case 1:
			dialog = "Your computer crashes, losing the progress you have made on your next assignment";
			moralModifier = -4;
			return;
		case 2:
			dialog = "You found an exact solution to an assignment online";
			moralModifier = 2;
			return;
		}
	}
	
}


class ChoiceEvent extends Event{
	int eventNum;
	int eventRange = 2;
	
	public ChoiceEvent() {
		eventType = "choice";
		eventNum = randomNumberGenerator(eventRange);
		selectEvent(eventNum);
	}
	
	public void selectEvent(int eventNumber){
		switch(eventNumber){
		case 0:
			dialog = "A classmate claims to have the solution to a current assignment, you try to persuade him to give it to you.";
			statLimit = "CHR";
			statSuccess = 12;
			successChance = 30;
			moralIncrease = 5;
			moralDamage = 3;
			return;
		case 1:
			dialog = "Your professor calls on you in the middle of the lecture to answer a question.";
			statLimit = "INT";
			statSuccess = 10;
			successChance = 45;
			moralIncrease = 2;
			moralDamage = 3;
			return;
		}
	}

}

