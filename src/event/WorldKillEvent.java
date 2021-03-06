package event;

import java.util.Date;

public class WorldKillEvent extends Event {

	public String getKilled() {
		return killed;
	}

	public void setKilled(String killed) {
		this.killed = killed;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	private String killed;
	private String reason;

	public WorldKillEvent(Date d, String[] split) {
		this.killed = split[2];
		this.reason = split[4];
	}

}
