package well.demo.strings;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class StringDetectorService {
	
	private static Map<String, Integer> sd = new ConcurrentHashMap<String, Integer>();
	
	/**
	 * If a String is not in the map, it is added to the map. If it is already in the map, it is just increased by 1.
	 * This maps to the POST Request
	 * @param newline
	 */
	public void addString(String newline) {
		if (sd.containsKey(newline)) {
			int j = sd.get(newline);
			int NewValue = j + 1;
			sd.replace(newline, NewValue);
		
		} else {
			sd.put(newline, 1);
		}

	}
	
	public void tempvalue() {
		this.addString("HELLOWORLD");
	}
	
	/*
	 * Check to see if the String is in the collection. 
	 * If it is it returns the number of times it was seen by the server. If it is not it returns 0
	 * THis maps to the GET Request
	 */
	public int hasKey(String key) {
		this.tempvalue();
		int keyfreq=0;
		if (sd.containsKey(key)) {
			keyfreq=sd.get(key);
		}
		else {
			keyfreq=0;
		}
		return keyfreq;
		
		
	}
	
	
	

}
