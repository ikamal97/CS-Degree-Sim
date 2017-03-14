import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void damageMoraleTest() {
		Character character = new Character();
		character.damageMorale(10);
		assertEquals(90, character.getMorale());
		
	}
	
	@Test
	public void damageEnergyTest() {
		Character character = new Character();
		character.damageEnergy(10);
		assertEquals(90, character.getEnergy());
	}

}
