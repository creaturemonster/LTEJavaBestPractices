package com.ltree.crs516.domain;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ltree.crs516.data.SamplesGenerator;
import com.ltree.crs516.domain.CharDataEntry.CharDataType;

/**
 * 
 * @author Crs516 Development Team
 * @version k4
 *
 */
public class CharDataEntryTest {

	private CharDataEntry testSubject;
	private String data = "data";
	private CharDataType type = CharDataType.ORIGINATORS_CRUISE;
	private PrincipalInvestigator[] pis = SamplesGenerator.getTestPis();

	@BeforeEach
	public void setUp() throws Exception {
		testSubject = new CharDataEntry();
		testSubject.setData(data);
		testSubject.setPis(pis);
		testSubject.setType(type);
	}

	@Test
	public void testGetData() {
		assertThat(testSubject.getData(),is(equalTo(data)));
	}

	@Test
	public void testGetPis() {
		assertThat(testSubject.getPis()[1],is(equalTo(pis[1])));
	}

	@Test
	public void testGetType() {
		assertThat(testSubject.getType(),is(equalTo(type)));
	}

}
