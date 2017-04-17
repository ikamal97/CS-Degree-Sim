import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Timer;
import java.util.TimerTask;

public class GameTest {

	@Test
	public void checkEnergyDepletion (){
		Character character=new Character();
		Game game= new Game(character);
		game.startDay();
		//assertEquals(10,game.getCharacterEnergy());
	}

//	@Test
//	public void checkNumberOfSeconds(){
//		Game game = new Game();
//		
//		Game.EventTimer eventTimer = new EventTimer();
//		game.startDay();
//		int seconds = eventTimer.getSeconds();
//		assertEquals(11,seconds);	
//	}	
}
