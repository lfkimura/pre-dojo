package game;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeSet;

import event.Event;

public class Match {

	private LinkedList<Event> events = new LinkedList<Event>();
	
	private TreeSet<PlayerStatistic>  ranking = new TreeSet();
	
	private Hashtable<String,PlayerStatistic> players = new Hashtable<String,PlayerStatistic>();
	
	public LinkedList<Event> getEvents() {
		return events;
	}

	public void setEvents(LinkedList<Event> events) {
		this.events = events;
	}

	public void addEvent(Event e) {
		this.events.add(e);
	}

}
