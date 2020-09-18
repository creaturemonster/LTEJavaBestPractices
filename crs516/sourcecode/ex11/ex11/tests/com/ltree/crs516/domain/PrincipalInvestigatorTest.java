package com.ltree.crs516.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Crs516 Development Team
 * @version k4
 *
 */
public class PrincipalInvestigatorTest {
	
	private PrincipalInvestigator testSubject;
	private String piName = "piName";
	private int piCode = 1;
	private int variableCode = 2;
	private String variableCodeString = "variableCodeString";

	@BeforeEach
	public void setUp() throws Exception {
		testSubject = new PrincipalInvestigator();
		testSubject.setPiCode(piCode);
		testSubject.setPiName(piName);
		testSubject.setVariableCode(variableCode);
		testSubject.setVariableCodeString(variableCodeString);
	}

	@Test
	public void testGetPiCode() {
		assertThat(testSubject.getPiCode(),is(equalTo(piCode)));
	}

	@Test
	public void testGetPiName() {
		assertThat(testSubject.getPiName(),is(equalTo(piName)));
	}

	@Test
	public void testGetVariableCode() {
		assertThat(testSubject.getVariableCode(),is(equalTo(variableCode)));

	}

	@Test
	public void testGetVariableCodeString() {
		assertThat(testSubject.getVariableCodeString(),is(equalTo(variableCodeString)));

	}

}
