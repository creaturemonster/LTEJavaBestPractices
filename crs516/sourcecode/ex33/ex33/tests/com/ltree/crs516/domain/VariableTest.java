package com.ltree.crs516.domain;

import static org.hamcrest.CoreMatchers.equalTo;
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
public class VariableTest {

	private Variable testSubject;
	private String codeString = "codeString";
	private int code = 1;
	private String depthVariableUnit = "depthVariableUnit";
	private String qualityFlagString = "qualityFlagString";
	private VariableMeta[] metaData = SamplesGenerator.getTestVariableMeta();
	private int qualityFlag = 0;
	
	@BeforeEach
	public void setUp() throws Exception {
		testSubject = new Variable();
		testSubject.setCode(code);
		testSubject.setCodeString(codeString);
		testSubject.setCodeUnit(depthVariableUnit);
		testSubject.setMetaData(metaData);
		testSubject.setQualityFlag(qualityFlag);
		testSubject.setQualityFlagString(qualityFlagString);
	}

	@Test
	public void testGetMetaData() {
		assertThat(testSubject.getMetaData(),equalTo(metaData));
	}

	@Test
	public void testGetNumMetaData() {
		assertThat(testSubject.getNumMetaData(),equalTo(metaData.length));
	}

	@Test
	public void testGetQualityFlag() {
		assertThat(testSubject.getQualityFlag(),equalTo(qualityFlag));
	}

	@Test
	public void testGetQualityFlagString() {
		assertThat(testSubject.getQualityFlagString(),equalTo(qualityFlagString));
	}

	@Test
	public void testGetCode() {
		assertThat(testSubject.getCode(),equalTo(code));
	}

	@Test
	public void testGetCodeString() {
		assertThat(testSubject.getCodeString(),equalTo(codeString));
	}

	@Test
	public void testGetCodeUnit() {
		assertThat(testSubject.getCodeUnit(),equalTo(depthVariableUnit));
	}

}
