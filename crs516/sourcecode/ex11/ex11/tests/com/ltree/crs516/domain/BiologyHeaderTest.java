package com.ltree.crs516.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ltree.crs516.data.SamplesGenerator;

/**
 * 
 * @author Crs516 Development Team
 * @version k4
 *
 */
public class BiologyHeaderTest {

	private BiologyHeader testSubject;
	private String header = "header";
	private int headerCode = 1;
	private String headerString = "headerString";
	private Datum value = SamplesGenerator.getTestDatum();
	private String valueMeaning = "valueMeaning";

	@BeforeEach
	public void setUp() throws Exception {
		testSubject = new BiologyHeader();
		testSubject.setHeader(header);
		testSubject.setHeaderCode(headerCode);
		testSubject.setHeaderString(headerString);
		testSubject.setValue(value);
		testSubject.setValueMeaning(valueMeaning);
	}

	@Test
	public void testGetHeaderCode() {
		assertThat(testSubject.getHeaderCode(),is(equalTo(headerCode)));
	}

	@Test
	public void testGetHeaderString() {
		assertThat(testSubject.getHeaderString(),is(equalTo(headerString)));
	}

	@Test
	public void testGetPrecision() {
		assertThat(testSubject.getPrecision(),is(equalTo(value.getPrecision())));
	}

	@Test
	public void testGetSigFig() {
		assertThat(testSubject.getSigFig(),is(equalTo(value.getSigFig())));
	}

	@Test
	public void testGetTotalFig() {
		assertThat(testSubject.getTotalFig(),is(equalTo(value.getTotalFig())));
	}

	@Test
	public void testGetValue() {
		assertThat(testSubject.getValue(),is(equalTo(value)));
	}

	@Test
	public void testGetValueMeaning() {
		assertThat(testSubject.getValueMeaning(),is(equalTo(valueMeaning)));
	}

	@Test
	public void testGetValueString() {
		assertThat(testSubject.getValueString(),is(equalTo(value.getValueString())));
	}

}
