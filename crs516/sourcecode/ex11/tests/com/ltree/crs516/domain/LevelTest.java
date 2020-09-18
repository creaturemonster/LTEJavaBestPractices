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
public class LevelTest {
	
	private Level testSubject;
	private Datum[] data = SamplesGenerator.getTestData();
	private Datum value = SamplesGenerator.getTestDatum();

	@BeforeEach
	public void setUp() throws Exception {
		testSubject = new Level();
		testSubject.setData(data);
		testSubject.setDepth(value);
		testSubject.setDepth(value);
	}

	@Test
	public void testGetData() {
		assertThat(testSubject.getData()[0],is(equalTo(data[0])));
	}

	@Test
	public void testGetOrigDepthErrorFlag() {
		assertThat(testSubject.getOrigDepthErrorFlag(),is(equalTo(value.getOriginatorsFlag())));
	}

	@Test
	public void testGetDepthErrorCodeString() {
		assertThat(testSubject.getDepthErrorCodeString(),is(equalTo(value.getQualityFlagString())));
	}

	@Test
	public void testGetDepthErrorCode() {
		assertThat(testSubject.getDepthErrorCode(),is(equalTo(value.getQualityFlag())));
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
	public void testGetDepth() {
		assertThat(testSubject.getDepth(),is(equalTo(value)));
	}

	@Test
	public void testGetDepthString() {
		assertThat(testSubject.getDepthString(),is(equalTo(value.getValueString())));
	}

}
