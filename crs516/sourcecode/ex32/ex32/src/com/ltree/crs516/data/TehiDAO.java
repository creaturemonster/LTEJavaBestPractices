package com.ltree.crs516.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.ltree.crs516.controller.TehiGame;
import com.ltree.crs516.controller.TehiGame.StateName;
import com.ltree.crs516.domain.CardDeck;
import com.ltree.crs516.domain.PlayingCard;
import com.ltree.crs516.domain.TehiHand;

/**
 * Interface for Data Accessor
 * @author Crs516 Development Team
 * @version k4
 *
 */
public interface TehiDAO {

//TODO 1: Add a method called saveDeck that accepts an argument of type CardDeck.
//The return type should be void.	
 void saveDeck(CardDeck deck);
	

//TODO 2: Add a method called getDeck that takes no argument and 
//returns a CardDeck. It should throw DAOException.	
	 CardDeck getDeck() throws DAOException;

	void saveState(StateName stateName);
	StateName getState() throws DAOException;
	void saveSystemHand(TehiHand systemHand);
	TehiHand getSystemHand(TehiGame tehiGame) throws DAOException;	
	void savePlayerHand(TehiHand playerHand);
	TehiHand getPlayerHand(TehiGame tehiGame) throws DAOException;
	int[] getScores() throws DAOException, DAOException;
	void saveScores(int cumulativePlayerScore, int cumulativeSytemScore);
	
}
