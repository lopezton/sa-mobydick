package com.tonelope.demos.sa.mobydick;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

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

		WordCounter wordCounter;
		try {
			wordCounter = new WordCounter(textFilename, stopFilename);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Please ensure the provided file names are correct.", e);
		} catch (IOException ioe) {
			throw new RuntimeException("An unknown error occurred.", ioe);
		} 

		// get the map, stream it, sort it by value in descending order and print it
		wordCounter.getCountMap().entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
	}
}
