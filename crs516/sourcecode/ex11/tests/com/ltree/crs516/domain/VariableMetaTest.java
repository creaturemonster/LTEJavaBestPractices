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
public class VariableMetaTest {

	private VariableMeta testSubject;
	private String varCode = "varCode";
	private String code = "code";
	private String varComment = "varComment";
	private Datum value = SamplesGenerator.getTestDatum();
	
	@BeforeEach
	public void setUp() throws Exception {
		testSubject = new VariableMeta();
		testSubject.setCode(code);
		testSubject.setValue(value);
		testSubject.setVarCode(varCode);
		testSubject.setVarComment(varComment);
	}

	@Test
	public void testGetVarCode() {
		assertThat(testSubject.getVarCode(),is(equalTo(varCode)));
	}

	@Test
	public void testGetCode() {
		assertThat(testSubject.getCode(),is(equalTo(code)));
	}

	@Test
	public void testGetVarComment() {
		assertThat(testSubject.getVarComment(),is(equalTo(varComment)));
	}

	@Test
	public void testGetValueString() {
		assertThat(testSubject.getValueString(),is(equalTo(value.getValueString())));
	}

	@Test
	public void testGetValuePrecision() {
		assertThat(testSubject.getValuePrecision(),is(equalTo(value.getPrecision())));
	}

	@Test
	public void testIsValuePresent() {
		assertThat(testSubject.isValuePresent(),is(equalTo(true)));
	}

	@Test
	public void testGetValueSigFig() {
		assertThat(testSubject.getValueSigFig(),is(equalTo(value.getSigFig())));
	}

	@Test
	public void testGetValueTotalFig() {
		assertThat(testSubject.getValueTotalFig(),is(equalTo(value.getTotalFig())));
	}

	@Test
	public void testGetValueMeaning() {
		assertThat(testSubject.getValueMeaning(),is(equalTo(value.getMeaning())));

	}

	@Test
	public void testGetValue() {
		assertThat(testSubject.getValue(),is(equalTo(value)));
	}

}
