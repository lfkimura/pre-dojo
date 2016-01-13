package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import event.EndMatchEvent;
import event.Event;
import event.EventFactory;
import event.StartMatchEvent;
import game.Match;
import game.PlayerStatistic;

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

			ArrayList<Match> matches = new ArrayList<Match>();

			Match currentMatch = new Match();

			// reading data
			while ((sCurrentLine = br.readLine()) != null) {

				Event createdEvent = EventFactory.createEvent(sCurrentLine);

				if (createdEvent instanceof StartMatchEvent) {
					currentMatch = new Match();
				}
				currentMatch.addEvent(createdEvent);

				if (createdEvent instanceof EndMatchEvent) {
					matches.add(currentMatch);
				}

			}
			// generate results
			System.out.println("##############################");
			System.out.println("#### RANKING #############");
			for (Match match : matches) {
				System.out.println("## MATCH "+ match.getMatch() +"###");
				System.out.println("PlayerName Kills Deaths");
				for (PlayerStatistic player : match.getRanking()) {

					System.out.println(player.getName() + "  " + player.getKilled() + "  " + player.getDeaths());
				}
				System.out.println("##############################");
				System.out.println("Winner favourite weapon :"+ match.getWinnerFavouriteWeapon());
				System.out.println("##############################");


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
