package com.ltree.crs516.client;

import com.ltree.crs516.domain.SecondaryHeader;
import com.ltree.crs516.domain.Station;

/**
*
* This class prepares the display HTML string for the 
* Secondary Header Data (Strategy Pattern).
* 
* @author crs516 development team
*
*/
public final class SecondaryHeaderDisplayer implements Displayer {

	/**
	 * Generates the HTML string
	 * @param station, station whose data is to be displayer
	 * @return a String with the data represented as HTML. The <html> tag is not close
	 * as is common in Swing.
	 */
	@Override
	public String createDisplayString(Station station) {
		StringBuilder strb = new StringBuilder("<html>");
		if (station.isSecondaryHeadersPresent()) {
			strb.append("<h1>Secondary Headers</h1>")
				.append("<table border='1'>")
			/*Headings*/
				.append("<tr>")
				.append("<th>Code</th>")
				.append("<th>Meaning</th>")
				.append("<th>Value</th>")
				.append("<th>Value Meaning</th>")
				.append("</tr>");
			/*Data*/
			SecondaryHeader[] headers = station.getSecondaryHeaders();
			for (SecondaryHeader header : headers) {
				strb.append("<tr>")
					.append("<td>"+ header.getHeaderCode() + "</td>")
					.append("<td>"+ header.getHeaderString() +"</td>")
					.append("<td>"+header.getValueString()+"</td>")
					.append("<td>"+header.getValueMeaning()+"</td>")
					.append("</tr>");
			}
			strb.append("</table>");
		} else {
			strb.append("<h1>No Secondary Headers Present</h1>");
		}
		return(strb.toString());
	}

}
