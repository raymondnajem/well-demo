package well.demo.strings;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class StringDetectorService {

	private final static Map<String, Integer> stringCollection = new ConcurrentHashMap<String, Integer>();

	/**
	 * If a String is not in the map, it is added to the map. If it is already in
	 * the map, it is just increased by 1. This maps to the POST Request
	 * 
	 * @param newline
	 */
	public void addString(String newline) {
		if (stringCollection.containsKey(newline)) {
			int j = stringCollection.get(newline);
			int NewValue = j + 1;
			stringCollection.replace(newline, NewValue);

		} else {
			stringCollection.put(newline, 1);
		}
	}

	/*
	 * Check to see if the String is in the collection. If it is it returns the
	 * number of times it was seen by the server. If it is not it returns 0 THis
	 * maps to the GET Request
	 */
	public String hasKey(String key) {
		int keyfreq = 0;
		if (stringCollection.containsKey(key)) {
			keyfreq = stringCollection.get(key);
		} else {
			keyfreq = 0;
		}
		return new String(Integer.toString(keyfreq));

	}

}
