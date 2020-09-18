package com.ltree.crs516;

import java.beans.PropertyChangeEvent;

@SuppressWarnings("serial")
public class FutureCardsViewer extends CardsViewer {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//TODO 1: In this method  
		//cast the Object returned from evt.getNewValue() to CardDeck.
		//Obtain an int[] of ranks left from the CardDeck
		//Call updateChart with the input argument the int[] of ranks not yet dealt.




	}

	/**
	 * {@inheritDoc}
	 */
	protected void updateChart(int[] ranksNotDealt) {
		for (int j = 0; j < ranksNotDealt.length; j++) {
			int numberOfcardsDealt = ranksNotDealt[j];
			for (int i = 0; i < 4 - numberOfcardsDealt; i++) {
				tiles[i][j].setText("");
			}
			for (int i = 4 - numberOfcardsDealt; i < 4; i++) {
				tiles[i][j].setText(Rank.convertIntToRank(j + 1).getName());
			}			
		}
	}


}
