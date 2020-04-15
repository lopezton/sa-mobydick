package com.tonelope.demos.sa.mobydick.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Utility class to count words given a data file.
 *
 * @author Tony Lopez
 *
 */
public class WordCounter {

	public static final String STOP_WORD_SKIP_CHAR = "#";
	public static final String EMPTY_STRING = "";
	public static final String SPACE = " ";

	private Set<String> stopWords = new HashSet<>();
	private Map<String, Integer> countMap = new HashMap<>();

	public WordCounter(String textFilename) throws IOException {
		process(textFilename, null);
	}

	public WordCounter(String textFilename, String stopFilename) throws IOException {
		process(textFilename, stopFilename);
	}

	private void process(String textFilename, String stopFilename) throws IOException {
		// load stop words from file: stopFileName
		if (null != stopFilename) {
			try (BufferedReader rdr = new BufferedReader(new FileReader(stopFilename))) {
				String line;
				while (null != (line = rdr.readLine())) {
					String stopWord = line.trim().toLowerCase();
					if (stopWord.startsWith(STOP_WORD_SKIP_CHAR)) {
						continue;
					}

					// TODO Consider sanity checks (e.g. we are assuming that stopWords file will be
					// formatted correctly.)
					this.stopWords.add(stopWord);
				}
			}
		}

		// load/process words from file textFilename
		try (BufferedReader rdr = new BufferedReader(new FileReader(textFilename))) {
			String line;
			while (null != (line = rdr.readLine())) {
				String[] words = line.split(SPACE);
				Stream.of(words)
					.map(String::toLowerCase)
					.map(s -> s.replaceAll("[^A-Za-z]+", ""))
					.forEach(s -> {
						if (EMPTY_STRING.equals(s) || this.stopWords.contains(s)) {
							return;
						}
						Integer existingCount = this.countMap.putIfAbsent(s, 1);
						if (null != existingCount) {
							this.countMap.put(s, existingCount + 1);
						}
				});
			}
		}
	}

	public Map<String, Integer> getCountMap() {
		return Collections.unmodifiableMap(countMap);
	}

	public Integer getCount(String word) {
		Integer value = this.countMap.get(word);
		return null != value ? value : 0;
	}
}
