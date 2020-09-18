package com.ltree.crs516;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumbertoWordsConverterTestJUnit4 {

private int input;
private String expected;

	@Parameters(name = "{0} should be \"{1}\"")
	public static Collection<Object[]> parameters() {

//TODO 1: As your code passes each test uncomment the next parameter pair. Don't 
//forget to throw an IllegalArgumentException if the number is out of the 
//prescribed range. You will probably go through several strategies before you 
//settle for one.

		Object[][] data = new Object[][] { 	
			{1, "one"}
//			, {0,"zero"}
//			, {7,"seven"}
//			, {11,"eleven"}
//			, {12,"twelve"}
//			, {-2, "minus two"}
//			, {17, "seventeen"}
//			, {20, "twenty"}
			};
		return Arrays.asList(data);
	}


	public NumbertoWordsConverterTestJUnit4(int input, String expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void testConvert() {
		assertThat(new NumbertoWordsConverter().convert(input)
													, is(equalTo(expected)));
	}

}

//------------- Bonus 1: Extend your code to pass pairs like -----------------

//{23, "twenty three"},{34, "thirty four"}, {-77, "minus seventy seven"}


//------------- Bonus 2: Extend your code to pass pairs like -----------------

//{100, "one hundred"}, {110, "one hundred ten"}
//, {131, "one hundred thirty one"}
//,{222, "two hundred twenty two"}
//, {1000, "one thousand"}
		
