package com.ltree.crs516.data;

import static org.hamcrest.CoreMatchers.equalTo;
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
public class VariableHeaderCodesTablesTest {
	
	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0},{1}\" should be {2}")
	@CsvSource( {
		" 2,304,BEST (BENGUELA SOURCE & TRANSPORT)",
		" 3,203,Salinity: unknown (pre-PSS78)",
		" 4,1068,KERNFORSCHUNGSANLAGE JUELICH- ATMOSPHAERISCHE CHEMIE (KFAAC) (JUELICH)",
		" 5,774,BOTTLE: Fluorometer  Turner Designs  model 10-AU-005-CE",
		" 6,1262,Nondispersive Infrared spectrometry (NDIR) xCO2 at analysis temperature",
		" 8,64,molesC&#0183;m-2&#0183;day<sup>-1</sup>",
		" 10,1630,Laminar flow design",
		" 11,102,Whatman GF/F 25",
		" 12,25,dawn  noon"
	})
	public void testConvert(int varCode, int varCodeVal, String expected) {
		assertThat(CodeTables.getMetaMeaning(varCode, varCodeVal),equalTo(expected));
	}

}
