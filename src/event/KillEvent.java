package event;

import java.util.Date;

public class KillEvent extends Event {

	private String killed;
	private String killer;
	private String weapon;

	public String getKilled() {
		return killed;
	}

	public void setKilled(String killed) {
		this.killed = killed;
	}

	public String getKiller() {
		return killer;
	}

	public void setKiller(String killer) {
		this.killer = killer;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public KillEvent(Date d, String[] split) {
		this.date = d;
		this.killer = split[0];
		this.killed = split[2];
		this.weapon = split[4];

	}

}
