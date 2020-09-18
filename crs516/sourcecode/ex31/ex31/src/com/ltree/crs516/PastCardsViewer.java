package com.ltree.crs516;

import java.beans.PropertyChangeEvent;

public class PastCardsViewer extends CardsViewer {

	/**
	 * Chart that displays cards that have been dealt.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//TODO 1: In this method 
		//cast the Object returned from evt.getNewValue() to CardDeck.
		//Obtain an int[] of ranks already dealt from the CardDeck
		//Call updateChart with the input argument the int[] of ranks dealt.
		CardDeck deck=(CardDeck) evt.getNewValue();
		int[] rankDelts=deck.getRanksDealt();
		updateChart(rankDelts);
	}


	/**
	 * {@inheritDoc}
	 */
	protected void updateChart(int[] ranksDealt) {
		for (int j = 0; j < ranksDealt.length; j++) {
			int numberOfcardsDealt = ranksDealt[j];
			for (int i = 0; i < 4 - numberOfcardsDealt; i++) {
				tiles[i][j].setText("");
			}
			for (int i = 4 - numberOfcardsDealt; i < 4; i++) {
				tiles[i][j].setText(Rank.convertIntToRank(j + 1).getName());
			}			
		}
	}


}
