package event;

import java.util.Date;

public class EndMatchEvent  extends Event{

	private long matchNumber;

	
	public long getMatchNumber() {
		return matchNumber;
	}


	public void setMatchNumber(long matchNumber) {
		this.matchNumber = matchNumber;
	}


	public EndMatchEvent(Date d, String[] split) {
		this.date = d;
		this.matchNumber = Long.parseLong(split[1]);
	}
}
