package com.ltree.crs516;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

//TODO 1: Change the declaration so that this class implements PropertyChangeListener.
@SuppressWarnings("serial")
public abstract class CardsViewer extends JPanel implements PropertyChangeListener   {

private JPanel centerPanel = new JPanel();
protected JLabel[][] tiles = new JLabel[4][13];

public CardsViewer() {
	setBorder(BorderFactory.createLineBorder(Color.BLACK));
	setLayout(new BorderLayout());
	centerPanel.setLayout(new GridLayout(4, 13));
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 13; j++) {
			tiles[i][j] = new JLabel("", JLabel.CENTER);
			tiles[i][j].setText(Rank.convertIntToRank(j + 1).getName());
			centerPanel.add(tiles[i][j]);
		}
	}
	add(centerPanel, BorderLayout.CENTER);
}

/**
 * Updates the GUI.
 * @param evt an Event whose newValue() yields an int[] with ranks of cards.
 */
public abstract void propertyChange(PropertyChangeEvent evt);
}
