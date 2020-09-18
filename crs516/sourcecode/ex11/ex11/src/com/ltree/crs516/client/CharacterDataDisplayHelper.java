package com.ltree.crs516.client;

import com.ltree.crs516.domain.CharDataEntry;
import com.ltree.crs516.domain.PrincipalInvestigator;
import com.ltree.crs516.domain.Station;

public class CharacterDataDisplayHelper implements DisplayHelper {

	public String mineStation(Station station) {
		//{{Marker 1
				StringBuilder strb = new StringBuilder("<html>");
				if(station.isCharacterDataPresent()){
					strb.append("<h1>Character Data and Principal Investigator</h1>")
					.append("<h3>There are "+ station.getNumCharacterDataEntries()
																	+" entries</h3>")
					.append("<table border='1'>")
					
					/*Headings*/
					.append("<tr>")
					.append("<th>Entry Type</th>")
					.append("<th>Value</th>")
					.append("</tr>");
		
					/*Data*/
					CharDataEntry[] entries = station.getCharacterDataEntries();
					for(CharDataEntry entry : entries){						
						strb.append("<tr>")
						.append("<td >"+entry.getType()+"</td>");
						if(entry.getType()
								==CharDataEntry.CharDataType.PRINCIPAL_INVESTIGATOR){
							strb.append("<td><table border='0'  id='investigators'>")
							.append("<tr><th>Code</th><th>Name</th></tr>");
							PrincipalInvestigator[] pis = entry.getPis();
							for(PrincipalInvestigator pi : pis){
								strb.append("<tr>")
								.append("<td>"+pi.getPiCode()+"</td>")
								.append("<td>"+pi.getPiName()+"</td>")
								.append("</tr>");
							}							
							strb.append("</table></td>");
						}else{
							strb.append("<td>"+entry.getData()+"</td>");
						}
						strb.append("</tr>");
					}
					strb.append("</table>");
				}
				else{
					strb.append("<h1>No Character Data Present</h1>");
					
				}
				String theDisplayString = strb.toString();
		
		//}}end Marker 1
		return theDisplayString;
	}

}
