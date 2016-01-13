package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import event.Event;
import event.KillEvent;
import event.StartMatchEvent;
import event.WorldKillEvent;

public class Match {

	private long match;

	private LinkedList<Event> events = new LinkedList<Event>();

	private HashMap<String, PlayerStatistic> players = new HashMap<String, PlayerStatistic>();

	public long getMatch() {
		return match;
	}

	public void setMatch(long match) {
		this.match = match;
	}

	public ArrayList<PlayerStatistic> getRanking() {
		ArrayList<PlayerStatistic> list = new ArrayList<PlayerStatistic>();
		for (PlayerStatistic p : players.values())
			list.add(p);
		Collections.sort(list);
		Collections.reverse(list);
		return list;
	}
	
	public String getWinnerFavouriteWeapon() {		
		
		return this.getRanking().get(0).getFavouriteWeapon();
	}

	public HashMap<String, PlayerStatistic> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap<String, PlayerStatistic> players) {
		this.players = players;
	}

	public LinkedList<Event> getEvents() {
		return events;
	}

	public void setEvents(LinkedList<Event> events) {
		this.events = events;
	}

	public void addEvent(Event e) {
		this.events.add(e);
		if (e instanceof StartMatchEvent)
			this.match = ((StartMatchEvent) e).getMatchNumber();
		if (e instanceof KillEvent) {
			String killer = ((KillEvent) e).getKiller();
			String killed = ((KillEvent) e).getKilled();
			// kills
			if (players.get(killer) == null) {
				players.put(killer, new PlayerStatistic(killer));
			}
			players.get(killer).addKill();
			players.get(killer).addWeapon(((KillEvent)e).getWeapon());
			// killed
			if (players.get(killed) == null) {
				players.put(killed, new PlayerStatistic(killed));
			}
			players.get(killed).addDeath();

		}
		if (e instanceof WorldKillEvent) {
			String killed = ((WorldKillEvent) e).getKilled();
			if (players.get(killed) == null) {
				players.put(killed, new PlayerStatistic(killed));
			}
			players.get(killed).addDeath();
		}
	}

}
