/*
 * Observers will be the various Menus
 */
public interface Observer {
	public void updateStats(int morale, int energy);
	public void updateTraits(int intelligence, int endurance, int charisma);
	public void updateTimer(int time);
}
