package com.ltree.crs516.client;

import com.ltree.crs516.domain.BiologyHeader;
import com.ltree.crs516.domain.Station;

/**
 * 
 * @author Crs 516 Development Team
 * @version k4
 *
 */
public class BiologyDisplayHelper implements DisplayHelper {

	public String mineStation(Station station) {
		//{{Marker 1
				
				StringBuilder strb = new StringBuilder("<html>");
				if (station.isBiologyHeadersPresent()) {
					strb.append("<table border='1'>")
		
					/* Headings */
					.append("<tr>")
					.append("<th>OCL code</th>")
					.append("<th>Meaning</th>")
					.append("<th>Value</th>")
					.append("<th>Value Meaning</th>")
					.append("</tr>");
					/* Data */
					BiologyHeader[] headers = station.getBiologyHeaders();
					for (BiologyHeader header : headers) {
						strb.append("<tr>")
						.append("<td align='right'>" + header.getHeaderCode()
								+ "</td>")
						.append("<td>" + header.getHeaderString() + "</td>")
						.append("<td align='right'>" + header.getValueString()
								+ "</td>")
						.append("<td>" + header.getValueMeaning() + "</td>")
						.append("</tr>");
					}
					strb.append("</table>");
				} else {
					strb.append("<h1>No Biology Headers Present</h1>");
				}
				String theDisplayString = strb.toString();
		
		//}}end Marker 1	
		return theDisplayString;
	}

}
