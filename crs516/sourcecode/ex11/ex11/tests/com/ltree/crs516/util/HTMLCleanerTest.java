package com.ltree.crs516.util;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HTMLCleanerTest {
	String testString ;
	
	@BeforeEach
	public void setUp() throws Exception {
		testString = "<sdfsdfa> dfdf,<ertertert<<sdfsdfsdfds>><<>";
	}

	@Test
	public void testEscape() {
		String testString = "<sdfsdfa> dfdf,<ertertert<<sdfsdfsdfds>><<>";
		assertThat(HTMLCleaner.escape(testString), not(containsString("<")));
		assertThat(HTMLCleaner.escape(testString), not(containsString(">")));
	}

}
