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
public class BiologyHeaderTablesTest {
	
	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0},{1}\" should be {2}")
	@CsvSource( {
		" 4,3, OTHER TYPE (oblique  double oblique  etc.)",
		" 6,1, yes",
		" 7,111,Rectangular Midwater Trawl (RMT)",
		" 10,8,10% filtered paraformaldehyde",
		" 11,4,PHYTOPLANKTON CALCULATED; Biomasses of phytoplankton algae were calculated considering cells' volumes by equating real or average volumes of cells to corresponding geometric figures",
		" 13,5,MUD (or MPN); Method of Ultimate Dilution ",
		" 13,5,MUD (or MPN); Method of Ultimate Dilution ",
		" 19,2,BY MANUFACTURER    ",
		" 24,1,OCL CALC  Calc by OCL from Wire out and Wire angle",
		" 25,2,WICKSTEAD (1965); Indonesian Data Reports"
	})
	public void testConvert(int code, int codeVal, String expected) {
		assertThat(CodeTables.getBiolHeaderMeaning(code, codeVal).trim(),is(equalTo(expected.trim())));
	}

}
