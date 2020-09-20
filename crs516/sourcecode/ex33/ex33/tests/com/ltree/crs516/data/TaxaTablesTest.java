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
public class TaxaTablesTest {

	@DisplayName("Test table lookup")
	@ParameterizedTest(name = "\"{0},{1}\" should be {2}")
	@CsvSource( {
		" 16,8,FOLSOM SPLITTER; complete enumeration using Folsom Splitter",
		" 17,2,spp.  (multiple species) ",
		" 18,-2,MEDIUM",
		" 19,-4,VERY SMALL",
		" 20,70,per m<sup>3</sup> -- Parameter per cubic meter",
		" 26,23,Perez IMECOCAL; Folsom splitter to 1/8-1/16 (~ 800-900 individuals) then stereoscopic microscope",
		" 27,4000000,Zooplankton Counts",
		" 30,-400,  All Biomass Types (excluding ichthyoplankton)",
		" 30,4262500,Mollusca:  Gastropoda (snails & slugs)",
		" 18,-2,MEDIUM",
		" 5,9,LARVA+JUV+ADULTS  (Codes 6+7+8)",
		" 6,5,GROUPED  BOTH SEXES PRESENT",
		" 7,8,VERY RARE; VR; RR",
		" 8,5,HETEROTROPH-PARASITIC",
		" 9,4,MEROPLANKTONIC ; Adults are benthic or nektonic"
	})
	public void testConvert(int code, int codeVal, String expected) {
		assertThat(CodeTables.getTaxaMeaning(code, codeVal).trim(),equalTo(expected.trim()));
	}
	
}
