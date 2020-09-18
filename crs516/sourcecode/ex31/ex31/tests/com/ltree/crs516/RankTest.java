package com.ltree.crs516;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

	@DisplayName("Ranks to Enums")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource( {
		"1, ACE", "2, TWO",
		"3, THREE", "4, FOUR", "5, FIVE",
		"6, SIX", "7, SEVEN", "8, EIGHT",
		"9, NINE", "10, TEN", "11, JACK",
		"12, QUEEN", "13, KING" 
	})
	public void testConvertIntToRank(int rankNumber, Rank expectedRank) {
		Rank rank = Rank.convertIntToRank(rankNumber);
		assertThat(rank, is(equalTo(expectedRank)));
	}
	
	@DisplayName("Rank names")
	@ParameterizedTest(name = "\"{0}\" should be the name of {1}")
	@CsvSource( {
		"A, ACE", "2, TWO",
		"3, THREE", "4, FOUR", "5, FIVE",
		"6, SIX", "7, SEVEN", "8, EIGHT",
		"9, NINE", "10, TEN", "J, JACK",
		"Q, QUEEN", "K, KING"  
	})
	public void testGetName(String rankName, Rank rank) {
			assertTrue(rank.getName().equals(rankName));
	}

	@DisplayName("Ranks to Enums")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource( {
		"1, ACE", "2, TWO",
		"3, THREE", "4, FOUR", "5, FIVE",
		"6, SIX", "7, SEVEN", "8, EIGHT",
		"9, NINE", "10, TEN", "11, JACK",
		"12, QUEEN", "13, KING" 
	})
	public void testGetRankNumber(int rankNumber, Rank rank) {
			assertTrue(rank.getRankNumber() == rankNumber);
	}

	//Test how random the card dealing is: Will occasionally fail.
	@Test
	public void testChooseRank() {
		int[] tally = new int[13];
		for(int i=0; i<65000;i++){
			Rank r = (Rank.chooseRank());
			tally[r.getRankNumber()-1]++;
		}
		for(int i=0;i<tally.length;i++){
			assertTrue(Math.abs(tally[i]-5000)<250);
		}
	}
}
