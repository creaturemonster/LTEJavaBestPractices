package com.ltree.crs516.client;

import com.ltree.crs516.domain.Station;
import com.ltree.crs516.domain.Variable;
import com.ltree.crs516.domain.VariableMeta;

public class PrimaryDisplayerHelper implements DisplayHelper {

	public String mineStation(Station station) {
		StringBuilder strb = new StringBuilder("<html>");
		strb.append("<table>")
			.append("<tr><td>OCL unique station number</td><td>"
				+ station.getStationNumber() + "</td></tr>")
			.append("<tr><td>Cruise code</td><td>" + station.getCruiseNumber()
				+ "</td></tr>")
			.append("<tr><td>NODC country code</td><td>"
				+ station.getCountryCode() + "</td></tr>")
			.append("<tr><td>Country</td><td>" + station.getCountry()
				+ "</td></tr>")
			.append("<tr><td>Year</td><td>" + station.getYear() + "</td></tr>")
			.append("<tr><td>Month</td><td>" + station.getMonth()
				+ "</td></tr>")
			.append("<tr><td>Day</td><td>" + station.getDay() + "</td></tr>")
			.append("<tr><td>Time</td><td>");
		if (station.isTimePresent()) {
			strb.append(station.getTimeString());
		} else {
			strb.append("Time: missing");
		}
		strb.append("</td></tr>")
			.append("<tr><td>Latitude</td><td>");
		if (station.isLatitudePresent()) {
			strb.append(station.getLatitudeString());
		} else {
			strb.append("missing");
		}
		strb.append("</td></tr>")
			.append("<tr><td>Longitude</td><td>");
		if (station.isLongitudePresent()) {
			strb.append(station.getLongitudeString());
		} else {
			strb.append("missing");
		}
		strb.append("</td></tr>")
			.append("<tr><td>Profile type</td><td>"
				+ station.getProfileTypeString() + "</td></tr>")
			.append("<tr><td>Number of levels</td><td>" + station.getLevels()
				+ "</td></tr>")
			.append("<tr><td># Variables in profile</td><td>"
				+ station.getVariablesInProfile() + "</td></tr>")
			.append("</table>");
		Variable[] variables = station.getVariables();
		if (variables.length > 0) {
			strb.append("<h3>Variables</h3>")
				.append("<table border='1'>")
			/* Headings */
				.append("<tr>")
				.append("<th>Variable</th>")
				.append("<th>Quality</th>")
				.append("<th>Variable-specific metadata</th>")
				.append("</tr>");
			for (Variable var : variables) {
				strb.append("<tr>")
					.append("<td>" + var.getCodeString() + "</td>")
					.append("<td>" + var.getQualityFlagString() + "</td>")
					.append("<td>");
				if (var.getNumMetaData() > 0) {
					VariableMeta[] metaData = var.getMetaData();
					strb.append("<ul>");
					for (VariableMeta meta : metaData) {
						strb.append("<li>")
							.append("Code: " + meta.getCode() + "  "
								+ meta.getVarCode() + "  " + "("
								+ meta.getVarComment() + ")" + "<br />")
							.append("Value: " + meta.getValueString()
								+ "  " + meta.getValueMeaning())
							.append("</li>");
					}
					strb.append("</ul>");
				} else {
					strb.append("None.");
				}
				strb.append("</td></tr>");
			}
			strb.append("</table>");
		}
		return(strb.toString());
	}

}
