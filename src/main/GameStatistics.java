package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import event.EndMatchEvent;
import event.Event;
import event.EventFactory;
import event.StartMatchEvent;

public class GameStatistics {

	private static String defaultLogName = "game.log";

	public static void main(String[] args) {
		String logName = defaultLogName;
		if (args.length > 0 && args[0] != null && !args[0].isEmpty())
			logName = args[0];
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(logName));

			LinkedList<Match> matches = new LinkedList();
			while ((sCurrentLine = br.readLine()) != null) {

				Match currentMatch = new Match();
				Event createdEvent = EventFactory.createEvent(sCurrentLine);
				if (createdEvent instanceof StartMatchEvent)
					currentMatch = new Match();

				currentMatch.addEvent(createdEvent);

				if (createdEvent instanceof EndMatchEvent)
					matches.addFirst(currentMatch);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
