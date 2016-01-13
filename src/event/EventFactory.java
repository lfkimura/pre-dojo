package event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class EventFactory {
	static Pattern worldKillPattern = Pattern.compile("<WORLD> killed.*");
	static Pattern killPattern = Pattern.compile(".*killed.*using.*");
	static Pattern endPattern = Pattern.compile("Match \\d* has ended");
	static Pattern startPattern = Pattern.compile("New match \\d* has started");

	public static Event createEvent(String eventLine) {
		String time = eventLine.split(" - ")[0];
		SimpleDateFormat f = new SimpleDateFormat("ss/MM/yyyy HH:mm:ss");
		Date d = null;
		try {
			d = f.parse(time);
			String log = eventLine.split(" - ")[1];
			if (worldKillPattern.matcher(log).matches())
				return new WorldKillEvent(d, log.split(" "));
			if (killPattern.matcher(log).matches())
				return new KillEvent(d, log.split(" "));
			if (endPattern.matcher(log).matches())
				return new EndMatchEvent(d, log.split(" "));
			if (startPattern.matcher(log).matches())
				return new StartMatchEvent(d, log.split(" "));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Event();

	}

}
