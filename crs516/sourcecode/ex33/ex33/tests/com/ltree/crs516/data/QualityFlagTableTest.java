package com.ltree.crs516.data;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 
 * @author Crs516 Development Team
 * @version k4
 *
 */
public class QualityFlagTableTest {

	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource( {
		" 0, accepted cast" , 
		" 1,failed annual standard deviation check" ,
		" 2, two or more density inversions ( Levitus; 1982 criteria )" , 
		" 3, flagged cruise" ,
		" 4, failed seasonal standard deviation check" , 
		" 5, failed monthly standard deviation check" ,
		" 6, failed annual and seasonal standard deviation check" ,
		" 7, bullseye from standard level data or failed annual and monthly standard deviation check" 
	})
	public void testConvert(int qualityControlFlagInt, String expected) {
		assertThat(CodeTables.getqualityFlag(qualityControlFlagInt),is(equalTo(expected)));
	}

}
