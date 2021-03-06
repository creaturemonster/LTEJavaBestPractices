package com.ltree.crs516;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Represents a card.
 * 
 * @author crs 516 development team.
 *
 */
@SuppressWarnings("serial")
public final class PlayingCard extends JPanel {

	private final Suite suite;
	private final Rank rank;
	private final boolean faceCard;
	private BufferedImage image;
	private static double magnification = 0.7; //scales the cards

	public static void setMagnification(double magnificationIn) {
		magnification = magnificationIn;
	}

	public boolean isFaceCard() {
		return faceCard;
	}

	public Suite getSuite() {
		return suite;
	}

	public Rank getRank() {
		return rank;
	}

	public PlayingCard(Suite suite, Rank rank) {
		super();
		this.suite = suite;
		this.rank = rank;
		if (rank.compareTo(Rank.TEN) > 0) {
			faceCard = true;
		} else {
			faceCard = false;
		}
		setImage();
		setPreferredSize(new Dimension((int)(200*magnification),(int)(250*magnification)));
	}

	public void setImage() {
		try {
			image = ImageIO.read(new File("images/200px-Playing_card_" + suite
					+ "_" + rank + ".svg.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Card [suite=" + suite + ", rank=" + rank + "]";
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, (int)(200*magnification),(int)(250*magnification),null);
	}

}
