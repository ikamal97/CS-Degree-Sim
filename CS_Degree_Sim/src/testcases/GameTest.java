
import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
        public void checkEnergyDepletion (){
	  Character character=new Character();
	  Game game= new Game(character);
	  game.startDay();
	  assertEquals(10,game.getCharacterEnergy());
	}
	
	@Test
        public void checkNumberOfSeconds(){
	  EventTimer eventTimer;
	  startDay();
	  int seconds=eventTimer.getSeconds();
	   assertEquals(11,seconds);	
	}	
}
