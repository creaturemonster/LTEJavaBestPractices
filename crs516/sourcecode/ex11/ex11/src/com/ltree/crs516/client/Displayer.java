package com.ltree.crs516.client;

import com.ltree.crs516.domain.Station;

/**
 * Interface for helpers that create the HTML for the tabs.
 * @author Crs 516 Development Team
 * @version k4
 *
 */
public interface Displayer {
	String createDisplayString(Station station);
}
