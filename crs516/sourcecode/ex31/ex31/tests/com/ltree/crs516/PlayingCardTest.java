package com.ltree.crs516;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayingCardTest {

	private PlayingCard subject;
	
	@BeforeEach
	public void setUp() throws Exception {
		subject = new PlayingCard(Suite.chooseSuite(), Rank.chooseRank());
	}

	@Test
	public void testIsFaceCard() {
		for(int i=0;i<10;i++){
			subject = new PlayingCard(Suite.chooseSuite(), Rank.values()[i]);
			assertTrue(!subject.isFaceCard());
		}
		for(int i=10;i<13;i++){
			subject = new PlayingCard(Suite.chooseSuite(), Rank.values()[i]);
			assertTrue(subject.isFaceCard());
		}
	}

}
