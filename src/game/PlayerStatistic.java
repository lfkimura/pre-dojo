package game;

import java.util.HashMap;

public class PlayerStatistic implements Comparable<PlayerStatistic> {

	private String name;
	private int kills = 0;
	private int deaths = 0;

	HashMap<String, Integer> weaponsHash = new HashMap<String, Integer>();


	public PlayerStatistic(String name) {
		this.name = name;
	}

	public PlayerStatistic(String name, String weapon) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKilled() {
		return kills;
	}

	public void setKilled(int killed) {
		this.kills = killed;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public void addKill() {
		this.kills++;
	}

	public void addDeath() {
		this.deaths++;
	}

	public void addWeapon(String weapon) {
		if (weaponsHash.get(weapon) == null)
			weaponsHash.put(weapon, 0);
		weaponsHash.put(weapon, weaponsHash.get(weapon) + 1);

	}

	@Override
	public int compareTo(PlayerStatistic player) {
		if (this.kills < player.getKilled())
			return -1;
		if (this.kills > player.getKilled())
			return 1;
		return 0;
	}

	public String getFavouriteWeapon() {
		String favourite ="";
		int currentBest=0;
		for (String weapon:weaponsHash.keySet()) {
			if (weaponsHash.get(weapon) > currentBest) {
				favourite = weapon;
				currentBest =weaponsHash.get(weapon); 
			}
			
		}

		return favourite;
	}

}