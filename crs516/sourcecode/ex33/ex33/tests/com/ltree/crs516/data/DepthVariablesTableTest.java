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
public class DepthVariablesTableTest {

	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0},{1}\" should be {2}")
	@CsvSource( {
		" 1, Temperature, Degrees Celsius (&#0176;C)" ,
		" 21, Dissolved Inorganic carbon [DIC], Millimole per liter (mM)" ,
		" 33, Tritium [3H], Tritium Unit (TU)" , 
		" 43, Delta Oxygen-18 [18O], Per mille ()"
	})
	public void testConvert(int number, String expected, String expectedUnit) {
		assertThat(CodeTables.getDepthVariableName(number), is(equalTo(expected)));
		assertThat(CodeTables.getDepthVariableUnit(number), is(equalTo(expectedUnit)));
	}

}
