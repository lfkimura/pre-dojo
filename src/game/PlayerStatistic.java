package game;

public class PlayerStatistic implements Comparable<PlayerStatistic> {
	
	private String name ;
	private int killed;
	private int deaths;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKilled() {
		return killed;
	}
	public void setKilled(int killed) {
		this.killed = killed;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;		
	}
	
	@Override
	public int compareTo(PlayerStatistic player) {		
		if ( this.killed < player.killed)
			return -1;
		if ( this.killed > player.killed)
			return -1;
		return 0;
	}
	
	
	

}