package com.ltree.crs516.util;

import  org.junit.jupiter.api.*;
import  static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class WODThreadPoolsTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testDelay() {
		assertTimeout(Duration.ofNanos(3_000_000_000L), () -> {
		long startTime = System.nanoTime();
		WODThreadPools.delay(1.5F);
		long endTime = System.nanoTime();
		long sleepDuration = endTime - startTime;
		assertTrue(sleepDuration>1_000_000_000L);
		});
	}

	@Test
	public void testGetDaemonThreadService() throws InterruptedException, ExecutionException {
		Future<String> future = WODThreadPools.getDaemonThreadService().submit(new TestCallable());
		String result = future.get();
		assertEquals(result, "daemon");
	}

	@Test
	public void testGetThreadService() throws InterruptedException, ExecutionException {
		Future<String> future = WODThreadPools.getThreadService().submit(new TestCallable());
		String result = future.get();
		assertEquals(result, "non-daemon");
	}

	private class TestCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			String result = "non-daemon";
			if(Thread.currentThread().isDaemon()){
				result = "daemon";
			}
			return result;
		}
	}
	
}
