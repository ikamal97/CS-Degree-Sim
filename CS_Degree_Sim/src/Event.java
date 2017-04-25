import java.awt.Image;
import java.util.Random;

public abstract class Event {
	public String eventType;
	public String dialog;
	public String statLimit;
	public int statSuccess;
	public int successChance;
	public int moralModifier;
	public int energyModifier;
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
	int eventRange = 13;
	
	public SimpleEvent() {
		eventType = "simple";
		eventNum = randomNumberGenerator(eventRange);//0-1
		selectEvent(eventNum);
	}
	
	public void selectEvent(int eventNumber){
		switch(eventNumber){
		case 0:
			dialog = "A Professor has extended an assignment deadline by a week. (+2 moral)";
			moralModifier = 2;
			return;
		case 1:
			dialog = "Your computer crashes, losing the progress you have made on your next assignment. (-4 moral)";
			moralModifier = -4;
			return;
		case 2:
			dialog = "You found the exact solution to an assignment online. (+2 moral)";
			moralModifier = 2;
			return;
		case 3:
			dialog = "You missed the bus and missed a lecture as a result. (-3 moral)";
			moralModifier = -3;
			return;
		case 4:
			dialog = "You tripped on your way to the next lecture. (-1 moral)";
			moralModifier = -1;
			return;
		case 5:
			dialog = "You completed extra credit. (+2 moral)";
			moralModifier = 2;
			return;
		case 6:
			dialog = "You forgot your laptop at the previous lecture. However a classmate approaches you after and returns the laptop. (+2 moral)";
			moralModifier = 2;
			return;
		case 7:
			dialog = "At a lecture, the professor pulls up your previous assignment as an example of good coding. (+3 moral)";
			moralModifier = 3;
			return;
		case 8:
			dialog = "On your way to class you find a $20 dollar bill by the pavement. (+1 moral)";
			moralModifier = 1;
			return;	
		case 9:
			dialog = "Someone good-looking starts conversation with you during lecture. (+1 moral)";
			moralModifier = 1;
			return;	
		case 10:
			dialog = "You do a risky click on a link that promises homework solutions. You download a virus. (-2 moral)";
			moralModifier = -2;
			return;	
		case 11:
			dialog = "It starts raining and you forgot your umbrella. All the items in your bag are soaked. (-1 moral)";
			moralModifier = -1;
			return;	
		case 12:
			dialog = "You forgot your student password. As a result you were unable to complete the required lab-work that day. (-3 moral)";
			moralModifier = -3;
			return;
		case 13:
			dialog = "You missed the deadline to register for a class are interested in. (-2 moral)";
			moralModifier = -2;
			return;
		}
	}
}


class ChoiceEvent extends Event{
	int eventNum;
	int eventRange = 4;
	
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
			statSuccess = 16;
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
			moralDamage = 4;
			return;
		case 2:
			dialog = "A pop quiz happens in a lecture.";
			statLimit = "INT";
			statSuccess = 14;
			successChance = 25;
			moralIncrease = 3;
			moralDamage = 7;
			return;
		case 3:
			dialog = "You are called up to present your project design that you forgot to prepare for.";
			statLimit = "CHR";
			statSuccess = 20;
			successChance = 20;
			moralIncrease = 5;
			moralDamage = 7;
			return;
		case 4:
			dialog = "You just missed the bus but a sheet assignment needs to be turned in to the professor before the next bus arrives. You run for it.";
			statLimit = "END";
			statSuccess = 12;
			successChance = 15;
			moralIncrease = 2;
			moralDamage = 10;
			return;
		}
	}

}

