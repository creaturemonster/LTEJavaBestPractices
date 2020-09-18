package com.ltree.crs516;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumbertoWordsConverterTestJUnit5 {
		
//TODO 1: As your code passes each test uncomment the next parameter pair. in the @CsvSource annotation.
//Don't forget to throw an IllegalArgumentException if the number is out of the 
//prescribed range. You will probably go through several strategies before you 
//settle for one.
	@DisplayName("Numbers to Words")
	@ParameterizedTest(name = "{0} should be \"{1}\"")
	@CsvSource( {
		"1, one" 
//		, "0, zero" 
//		, "7, seven" 
//		, "11, eleven" 
//		, "12, twelve" 
//		, "-2, minus two" 
//		, "17, seventeen" 
//		, "20, twenty"
	})



	public void testConvert(int input, String expected) {
		assertThat(new NumbertoWordsConverter().convert(input)
													, is(equalTo(expected)));
	}

}

	
