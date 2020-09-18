package com.ltree.crs516.client;

import java.util.List;

import com.ltree.crs516.domain.Station;
import com.ltree.crs516.domain.Taxa;
import com.ltree.crs516.domain.TaxaList;
import com.ltree.crs516.util.HTMLCleaner;

public class TaxaDisplayHelper implements DisplayHelper {

	@Override
	public String mineStation(Station station) {
		StringBuffer strb = new StringBuffer("<html>");
		if (station.isTaxaDataPresent()) {
			strb.append("<h1>Taxonomic Data Sets and Integrated Parameters: "
					+ station.getNumTaxaSets() + " sets.</h1>");
			List<TaxaList> taxaSets = station.getTaxaSets();
			for (int i = 0; i < taxaSets.size(); i++) {
				strb.append("<h2>Set " + (i + 1) + ":</h2>")
					.append("<table border='1'>")
				/* Headings */
					.append("<tr>")
					.append("<th>Code</th>")
					.append("<th>Code Meaning</th>")
					.append("<th>Value</th>")
					.append("<th>Value Meaning</th>")
					.append("<th>Quality Flag</th>")
					.append("<th>Quality Flag Meaning</th>")
					.append("</tr>");
				/* Data */
				TaxaList taxaSet = taxaSets.get(i);
				for (int j = 0; j < taxaSet.size(); j++) {
					Taxa taxa = taxaSet.get(j);
					strb.append("<tr>")
						.append("<td>" + taxa.getCode() + "</td>")
						.append("<td>" + HTMLCleaner.escape(taxa.getTaxVar()) + "</td>")
						.append("<td>" + taxa.getValueString() + "</td>");
					/* 
					 * Below, replace angle brackets with entities 
					 * so that the GUI does not try to 
					 * interpret them.
					 */
					String meaningString = HTMLCleaner.escape(taxa.getValueMeaning());
					strb.append("<td>" + meaningString + "</td>")
						.append("<td>" + taxa.getQualityFlag() + "</td>")
						.append("<td>" + taxa.getQualityFlagString() + "</td>")
						.append("</tr>");
				}
				strb.append("</table><p/>");
			}// end of a set
		}// All sets (if any) are done
		else {
			strb.append("<h1>No Taxa or integrated parameter data</h1>");
		}
		return(strb.toString());
	}

}
