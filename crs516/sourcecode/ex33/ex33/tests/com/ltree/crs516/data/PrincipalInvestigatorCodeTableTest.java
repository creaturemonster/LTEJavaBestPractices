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
public class PrincipalInvestigatorCodeTableTest {

	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource( {
		" 1551, AMAROV; G." , 
		" 960, ANGOT; MICHEL" , 
		" 241, ASADA; E." ,
		" 278, BAARS; DR. MARTIEN A." , 
		" 312, BALTZ; KENNEY" , 
		" 316, BAUER; DR. ROGER" ,
		" 2616,BELLAIL; ROBERT" , 
		" 2478, BETHOUX; JEAN-PIERRE" 
	})
	public void testConvert(int piCode, String expected) {
		assertThat(CodeTables.getPI(piCode), is(equalTo(expected)));
	}

}
