package com.tonelope.demos.sa.mobydick.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Test class for WordCounter.
 *
 * @see com.tonelope.demos.sa.mobydick.utils.WordCounter
 * @author Tony Lopez
 *
 */
@DisplayName("WordCounter Demo")
public class WordCounterTest {

	private WordCounter testee;

	@Test
	@Tag("happy-path")
	public void testCountWords() {
		this.testee = new WordCounter("count-words-test-1.txt");
		assertFalse(this.testee.getCountMap().isEmpty());
		assertEquals(2, this.testee.getCount("lorem"));
		assertEquals(2, this.testee.getCount("eu"));
		assertEquals(1, this.testee.getCount("ipsum"));
		assertEquals(1, this.testee.getCount("dolor"));
		assertEquals(1, this.testee.getCount("sit"));
		assertEquals(1, this.testee.getCount("amet"));
		assertEquals(1, this.testee.getCount("consectetur"));
		assertEquals(1, this.testee.getCount("adipiscing"));
		assertEquals(1, this.testee.getCount("elit"));
		assertEquals(1, this.testee.getCount("morbi"));
		assertEquals(1, this.testee.getCount("finibus"));
		assertEquals(1, this.testee.getCount("tempor"));
		assertEquals(1, this.testee.getCount("lacus"));
		assertEquals(1, this.testee.getCount("malesuada"));
		assertEquals(1, this.testee.getCount("aliquam"));
		assertEquals(1, this.testee.getCount("accumsan"));
		assertEquals(1, this.testee.getCount("nisi"));
		assertEquals(1, this.testee.getCount("tortor"));
		assertEquals(1, this.testee.getCount("id"));
		assertEquals(1, this.testee.getCount("ultrices"));
		assertEquals(1, this.testee.getCount("dignissim"));
		assertEquals(1, this.testee.getCount("non"));
		assertEquals(1, this.testee.getCount("proin"));
		assertEquals(1, this.testee.getCount("ut"));
		assertEquals(1, this.testee.getCount("ornare"));
		assertEquals(1, this.testee.getCount("neque"));
		assertEquals(1, this.testee.getCount("duis"));
		assertEquals(1, this.testee.getCount("semper"));
		assertEquals(1, this.testee.getCount("sem"));
	}

	@Test
	@Tag("negative")
	public void testCountWordsBadFile1() {
		assertThrows(RuntimeException.class, () -> {
			this.testee = new WordCounter("unknown.txt");
		});
	}

	@Test
	@Tag("negative")
	public void testCountWordsBadFile2() {
		assertThrows(RuntimeException.class, () -> {
			this.testee = new WordCounter("count-words-test-1.txt", "unknown.txt");
		});
	}

	@Test
	@Tag("happy-path")
	public void testCountWordsExcludingStops() {
		this.testee = new WordCounter("count-words-test-1.txt", "count-words-stop-test-1.txt");

		assertFalse(this.testee.getCountMap().isEmpty());
		assertEquals(2, this.testee.getCount("lorem"));
		assertEquals(1, this.testee.getCount("ipsum"));
		assertEquals(1, this.testee.getCount("dolor"));
		assertEquals(1, this.testee.getCount("sit"));
		assertEquals(1, this.testee.getCount("amet"));
		assertEquals(1, this.testee.getCount("consectetur"));
		assertEquals(1, this.testee.getCount("adipiscing"));
		assertEquals(1, this.testee.getCount("elit"));
		assertEquals(1, this.testee.getCount("morbi"));
		assertEquals(1, this.testee.getCount("finibus"));
		assertEquals(1, this.testee.getCount("tempor"));
		assertEquals(1, this.testee.getCount("lacus"));
		assertEquals(1, this.testee.getCount("malesuada"));
		assertEquals(1, this.testee.getCount("aliquam"));
		assertEquals(1, this.testee.getCount("accumsan"));
		assertEquals(1, this.testee.getCount("nisi"));
		assertEquals(1, this.testee.getCount("tortor"));
		assertEquals(1, this.testee.getCount("id"));
		assertEquals(1, this.testee.getCount("ultrices"));

		assertEquals(0, this.testee.getCount("eu"));
		assertEquals(0, this.testee.getCount("dignissim"));
		assertEquals(0, this.testee.getCount("non"));
		assertEquals(0, this.testee.getCount("proin"));
		assertEquals(0, this.testee.getCount("ut"));
		assertEquals(0, this.testee.getCount("ornare"));
		assertEquals(0, this.testee.getCount("neque"));
		assertEquals(0, this.testee.getCount("duis"));
		assertEquals(0, this.testee.getCount("semper"));
		assertEquals(0, this.testee.getCount("sem"));
	}

}
