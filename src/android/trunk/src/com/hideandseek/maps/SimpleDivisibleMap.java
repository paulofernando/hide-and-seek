package com.hideandseek.maps;

import java.util.HashMap;
import java.util.Vector;

import com.hideandseek.exceptions.InvalidMapException;

import android.graphics.Point;

/**
 * Simple map to create
 * @author paulofernando
 *
 */
public class SimpleDivisibleMap extends Map {

	
	private HashMap<String, Point[]> areas;
	
	/**
	 * Areas that defines the map. The first point indicates the upper left corner of the area and
	 * the second point indicates the lower right corner of the area
	 * @param areas Map with all the areas in the map. Each record in the map must be the name identifier of the area
	 * and the area (the vector with two Points)
	 */
	public SimpleDivisibleMap(HashMap<String, Point[]> areas) throws InvalidMapException {
		super();
		this.areas = areas;
		
		if(!validateMap()) throw new InvalidMapException();
		riseUpTheWall();
	}
	
	/** Verifies if the map is a valid map	
	 * @return true if a map is a valid map
	 */
	private boolean validateMap() {
		//TODO improve the algorithm of comparison. Maybe, will need improve the data structure
		for (Point[] area: areas.values()) {
			if(area.length != 2) return false;
			for (Point[] area2: areas.values()) {
				if(area != area2) { //Don't verifies the same object
					//if the rectangles intersect
					if(((area2[0].x > area[0].x) && (area2[0].x < area[1].x) && (area2[0].y > area[0].y) && (area2[0].y < area[1].y)) || 
						(((area2[1].x > area[0].x) && (area2[1].x < area[1].x) && (area2[1].y > area[0].y) && (area2[1].y < area[1].y)))) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/** Builds the walls */
	private void riseUpTheWall() {
		
	}
	
	@Override
	protected void createObjects() {
		
	}

}
