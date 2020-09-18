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
public class CountryCodeTableTest {

	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource( {
			"CO, COLOMBIA" , 
			"ID, INDONESIA" , 
			"NO, NORWAY" ,
			"CN, CHINA" , 
			"AG, ANTIGUA" , 
			"HN, HONDURAS" , 
			"NG, NIGERIA" ,
			"TT, TRINIDAD AND TOBAGO"
	})
	public  void testConvert(String codeStr, String expected) {
		assertThat(CodeTables.getCountry(codeStr).trim(), is(equalTo(expected.trim())));
	}

}
