package com.tonelope.demos.sa.mobydick;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.tonelope.demos.sa.mobydick.utils.WordCounter;

/**
 * A technical showcase.
 *
 * @author Tony Lopez
 *
 */
public class MobyDickApplication {

	public static void main(String[] args) {
		String textFilename = null;
		String stopFilename = null;
		if (null != args) {
			if (args.length > 0) {
				textFilename = args[0];
			}
			if (args.length > 2) {
				stopFilename = args[1];
			}
		}

		WordCounter wordCounter = new WordCounter(textFilename, stopFilename);

		// get the map, stream it, sort it by value in descending order and print it
		wordCounter.getCountMap().entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
	}
}
