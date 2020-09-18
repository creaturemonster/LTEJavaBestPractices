package com.ltree.crs516.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.ltree.crs516.client.WODClient;
import com.ltree.crs516.data.DataService;
import com.ltree.crs516.data.SamplesGenerator;
import com.ltree.crs516.domain.Station;


public class WODControllerTest {

	private WODController testSubject;
	private DataService dataService;
	private PropertyChangeListener observer;
	private Station station; 
	
	@BeforeEach
	public void setUp() throws Exception {
		WODClient owner = mock(WODClient.class);
		dataService = mock(DataService.class);
		when(dataService.size()).thenReturn(50);
		station = SamplesGenerator.getTestStation();
		when(dataService.read(anyInt())).thenReturn(station);
		testSubject = new WODController(owner);
		testSubject.setDataService(dataService);
		observer = mock(PropertyChangeListener.class);
		testSubject.addPropertyChangeListener(observer);
	}

	@Test
	public void testNext(){
		testSubject.setCurrentStation(10);
		testSubject.next();
		assertThat(testSubject.getCurrentIndex(),equalTo(11));
		verify(dataService, atLeastOnce()).size();
		assertPropertyChangeCalled(2);
	}
	
	@Test
	public void testGetCurrentStation() {
		assertThat(testSubject.getCurrentIndex(),equalTo(0));
	}

	@Test
	public void testSetCurrentStation() {
		testSubject.setCurrentStation(10);
		assertThat(testSubject.getCurrentIndex(),equalTo(10));
		verify(dataService, atLeastOnce()).size();
	}
	
	@Test
	public void testSetCurrentStationTopBoundary() {
		testSubject.setCurrentStation(51);
		assertThat(testSubject.getCurrentIndex(),equalTo(50));
		verify(dataService, atLeastOnce()).size();
		assertPropertyChangeCalled(1);
	}
	
	@Test
	public void testSetCurrentStationBottomBoundary() {
		testSubject.setCurrentStation(0);
		assertThat(testSubject.getCurrentIndex(),equalTo(1));
		assertPropertyChangeCalled(1);	}

	@Test
	public void testObserversNotifiedWhenStationSet() {
		testSubject.setCurrentStation(10);
		assertThat(testSubject.getCurrentIndex(),equalTo(10));
		assertPropertyChangeCalled(1);	
	}
	
	@Test
	public void testNextAtTop(){
		testSubject.setCurrentStation(50);
		testSubject.next();
		assertThat(testSubject.getCurrentIndex(),equalTo(50));
		verify(dataService, atLeastOnce()).size();
		assertPropertyChangeCalled(2);
	}

	@Test
	public void testPreviousAtBottom() {
		testSubject.setCurrentStation(1);
		testSubject.previous();
		assertThat(testSubject.getCurrentIndex(),equalTo(1));
		verify(dataService, atLeastOnce()).size();
		assertPropertyChangeCalled(2);
	}
	
	private void assertPropertyChangeCalled(int n) {
		ArgumentCaptor<PropertyChangeEvent> argument = ArgumentCaptor.forClass(PropertyChangeEvent.class);
		verify(observer, times(n)).propertyChange(argument.capture());
		PropertyChangeEvent evt = argument.getValue();
		Station stationfromEvent = (Station)evt.getNewValue();
		assertEquals(station, stationfromEvent);
	}
}
