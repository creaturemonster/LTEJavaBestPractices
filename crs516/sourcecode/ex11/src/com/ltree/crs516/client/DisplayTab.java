package com.ltree.crs516.client;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ltree.crs516.domain.Station;

 /**
  * Superclass for the GUI tabs.
  * @author Crs 516 Development Team.
  * @version k4.
  */
@SuppressWarnings("serial")
public class DisplayTab extends JPanel implements PropertyChangeListener{
	/**
	 * To display the data.
	 */
	protected JEditorPane textArea = new JEditorPane("text/html", "");
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private DisplayHelper helper;
	private String title;
	protected Station station;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public DisplayTab() {
		super();
		setLayout(new BorderLayout());
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	/**
	 * Displays the data that goes with a station.
	 * @param theStation
	 *            The Station whose data is to be displayed.
	 *            
	 */
	public void display(Station theStation) {
		station = (Station)theStation;
		textArea.setText("");
		String theDisplayString = createDisplayString(theStation);
		textArea.setText(theDisplayString);
	}

	public void setTextArea(JEditorPane textArea) {
		this.textArea = textArea;
	}

	public void setHelper(DisplayHelper helper) {
		this.helper = helper;
	}
	
	protected String createDisplayString(Station station) {
		String theDisplayString = helper.mineStation(station);
		return theDisplayString;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		Station theStation = (Station)event.getNewValue();
		display((Station)theStation);
	}

}
