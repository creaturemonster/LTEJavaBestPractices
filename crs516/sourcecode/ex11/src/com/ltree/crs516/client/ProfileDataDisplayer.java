package com.ltree.crs516.client;

import com.ltree.crs516.domain.Datum;
import com.ltree.crs516.domain.Level;
import com.ltree.crs516.domain.Station;
import com.ltree.crs516.domain.Station.ProfileType;
import com.ltree.crs516.domain.Variable;

/**
*
* This class prepares the HTML string for the 
* Profile Data to display (Strategy Pattern).
* 
* @author crs516 development team
*
*/
public final class ProfileDataDisplayer implements Displayer {

	/**
	 * Generates the HTML string
	 * @param station, station whose data is to be displayer
	 * @return a String with the data represented as HTML. The <html> tag is not close
	 * as is common in Swing.
	 */
	public String createDisplayString(Station station) {
		StringBuilder strb = new StringBuilder("<html>");
		StringBuilder summaryBuilder  = new StringBuilder();
		if (station.isProfilePresent()) {
			Level[] profile = station.getProfile();
			int numOfLevels = profile.length;
			int numOfVars = station.getVariablesInProfile();
			if(profile.length>0){
				strb.append("<h1>Profile Data</h1>")
					.append("<h2>Details for each level</h2>");
				summaryBuilder.append("<h2>Summary Table</h2>");
			}
			else{
				strb.append("<h1>No Profile Data</h1>");
			}
			String[][] tableData = new String[numOfLevels][numOfVars+1];
			/* Depth of level i is item [i][0]*/
			for (int i = 0; i < profile.length; i++) {
				Level level = profile[i];
				strb.append("<table border='0'>")
					.append("<tr>");
				if(station.getProfileType()== ProfileType.OBSERVED){
					strb.append("<td>")
						.append("<table>" +
							"<tr><td>Depth: "+level.getDepthString()+"</td></tr>" +
							"<tr><td>Depth Err Code: "+level.getDepthErrorCode()+"</td></tr>" +
							"<tr><td>Orig Depth Err Code Flag: "+level.getOrigDepthErrorFlag()+"</td></tr>" +
							"</table>")
						.append("</td>");
				}else{strb.append("<td>Depth: "+level.getDepthString()+"</td>");}
				tableData[i][0]=level.getDepthString();
				strb.append("<td>");
				if (level.isDataPresent()) {
					Variable[] variables = station.getVariables();
					strb.append("<table border='1'>")
					/*Headings*/
						.append("<tr>")
						.append("<th>Variable</th>")
						.append("<th>Value</th>")
						.append("<th>Qual. Flag</th>")
						.append("<th>Orig. Flag</th>")
						.append("</tr>");
					/*Data*/
					Datum[] observations = level.getData();
					int obsCounter = 0;
					for (Datum obs : observations) {

						if(obs == null){
							strb.append("<tr>")
								.append("<td>"+variables[obsCounter++].getCodeString()+"</td>")
								.append("<td>missing</td>")
								.append("<td></td>")
								.append("<td></td>")
								.append("</tr>");
							tableData[i][obsCounter]="-";
							continue;
						}
						strb.append("<tr>")
							.append("<td>"+variables[obsCounter++].getCodeString()+"</td>")
							.append("<td>"+obs.getValueString()+"</td>")
							.append("<td>"+obs.getQualityFlag()+"</td>")
							.append("<td>"+obs.getOriginatorsFlag()+"</td>")
							.append("</tr>");
						tableData[i][obsCounter]=obs.getValueString();
					}
					strb.append("</table>");
				}
				strb.append("</td></tr></table>");//end of whole row
			}
			//make the summary table using tableData;
			summaryBuilder.append("<table border='1'>");
			//row for depth
			summaryBuilder.append("<tr><th>Depth</th>");
			for(int i = 0; i<numOfLevels;i++){
				summaryBuilder.append("<td>"+tableData[i][0]+"</td>");
			}
			summaryBuilder.append("</tr>");
			//the other rows
			for(int j=0; j< numOfVars;j++){
			summaryBuilder.append("<tr><th>")
					.append(station.getVariables()[j].getCodeString())
					.append("</th>");
			for(int i = 0; i<numOfLevels;i++){
				summaryBuilder.append("<td>"+tableData[i][j+1]+"</td>");
			}
			summaryBuilder.append("</tr>");
			}
			summaryBuilder.append("</table>");
			if(numOfLevels>0){strb = strb.append(summaryBuilder);}
		} else {
			strb.append("<h1>No Profile Data Present</h1>");
		}
		return(strb.toString());
	}

}
