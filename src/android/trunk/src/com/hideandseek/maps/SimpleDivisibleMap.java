package com.hideandseek.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import com.hideandseek.exceptions.InvalidDoorException;
import com.hideandseek.exceptions.InvalidMapException;
import com.hideandseek.maps.objects.MarkedPosition;
import com.hideandseek.maps.objects.Objects;

import android.graphics.Point;
import android.graphics.PointF;

/**
 * Simple map to create
 * @author paulofernando
 *
 */
public class SimpleDivisibleMap extends Map {

	/** Walls in the area */
	public static final int LEFT_WALL = 0;
	public static final int UP_WALL = 1;
	public static final int RIGHT_WALL = 2;
	public static final int BOTTOM_WALL = 3;
	
	/** Width of the wall */
	private static final int markedPlaceWidth = 20;
	/** Identifier of the area and a array with the left corner and lower right corner of the area */
	private HashMap<String, Point[]> areas;	
	/** Identifier of the area and the walls in the area that have a door */
	private HashMap<String, Vector<Integer>> doors;
	/** Identify the walls that won't be raised up */
	private HashMap<String, Vector<Integer>> netralizedWalls;
	
	private static final int doorWidth = 70;
	
	/**
	 * Areas that defines the map. The first point indicates the upper left corner of the area and
	 * the second point indicates the lower right corner of the area
	 * @param areas Map with all the areas in the map. Each record in the map must be the name identifier of the area
	 * and the area (the vector with two Points)
	 */
	public void setWalls(HashMap<String, Point[]> areas) throws InvalidMapException {				
		if(!validateWalls(areas)) throw new InvalidMapException();
		this.areas = areas;
	}
	
	/**
	 * Sets up the doors in the walls of the area
	 * @param doors walls where the doors are 
	 */
	public void setDoors(HashMap<String, Vector<Integer>> doors) throws InvalidDoorException {		
		if(!validateDoors(doors)) throw new InvalidDoorException();
		this.doors = doors;
	}
	
	/** Verifies if the map is a valid map.
	 * @return true if a map is a valid map
	 */
	private boolean validateWalls(HashMap<String, Point[]> areas) {
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
	
	/** Verifies if the doors are valid
	 * @return true if the doors are valid
	 */
	private boolean validateDoors(HashMap<String, Vector<Integer>> doors) {
		for (Vector<Integer> ds: doors.values()) {
			if((ds.size() < 1) || (ds.size() > 4)) return false;
			for(int wall: ds) {
				if((wall != LEFT_WALL) && (wall != UP_WALL) && (wall != RIGHT_WALL) && (wall != BOTTOM_WALL)) return false; 
			}
		}
		return true;
	}
	
	/** Don't rise up the walls chosen here */	 
	private boolean validateNeutralizedWalls(HashMap<String, Vector<Integer>> neutralizedWalls) {
		for (Vector<Integer> nw: neutralizedWalls.values()) {
			if((nw.size() < 1) || (nw.size() > 4)) return false;
			for(int wall: nw) {
				if((wall != LEFT_WALL) && (wall != UP_WALL) && (wall != RIGHT_WALL) && (wall != BOTTOM_WALL)) return false;
			}
		}
		return true;
	}
	
	/** Don't rise up the walls chosen here */	 
	public void neutralizeTheWalls(HashMap<String, Vector<Integer>> neutralizedWalls) throws InvalidMapException {
		if(!validateNeutralizedWalls(neutralizedWalls)) throw new InvalidMapException();
		this.netralizedWalls = neutralizedWalls;
	}
	
	/** Builds the walls */
	public void riseUpTheWalls() {
		objectsPlaced = new Vector<MarkedPosition>();
		
	    for(Entry<String, Point[]> area: areas.entrySet()) {
	    	Point[] points = area.getValue();
	        Vector<Integer> doorsInThisArea = doors.get(area.getKey());
	        Vector<Integer> neutralizedWallsInThisArea = this.netralizedWalls.get(area.getKey());
	        
	        //left wall
	        if ((neutralizedWallsInThisArea == null) || !neutralizedWallsInThisArea.contains(new Integer(LEFT_WALL))) {
		   		if ((doorsInThisArea != null) && doorsInThisArea.contains(new Integer(LEFT_WALL))) {
		   			objectsPlaced.add(new MarkedPosition(markedPlaceWidth, ( ((points[1].y - points[0].y)>>1) - (doorWidth>>1) ), Objects.OBJECT_WALL, new PointF(points[0].x, points[0].y)));
		   			objectsPlaced.add(new MarkedPosition(markedPlaceWidth, ( ((points[1].y - points[0].y)>>1) - (doorWidth>>1) ), Objects.OBJECT_WALL, new PointF(points[0].x, (( ((points[1].y - points[0].y)>>1) - (doorWidth>>1) )) + doorWidth + markedPlaceWidth + points[0].y)));
		   		} else {			
		   			objectsPlaced.add(new MarkedPosition(markedPlaceWidth, points[1].y - points[0].y, Objects.OBJECT_WALL, new PointF(points[0].x, points[0].y)));
		   		}
	        }
			
			//up wall
	        if ((neutralizedWallsInThisArea == null) || !neutralizedWallsInThisArea.contains(new Integer(UP_WALL))) {
		   		if ((doorsInThisArea != null) && doorsInThisArea.contains(new Integer(UP_WALL))) {
		   			objectsPlaced.add(new MarkedPosition(( ((points[1].x - points[0].x)>>1) - (doorWidth>>1) ), markedPlaceWidth, Objects.OBJECT_WALL, new PointF(points[0].x, points[0].y)));
		   			objectsPlaced.add(new MarkedPosition(( ((points[1].x - points[0].x)>>1) - (doorWidth>>1) ), markedPlaceWidth, Objects.OBJECT_WALL, new PointF((( ((points[1].x - points[0].x)>>1) - (doorWidth>>1) )) + doorWidth + markedPlaceWidth + points[0].x, points[0].y)));
		   		} else {
		   			objectsPlaced.add(new MarkedPosition(points[1].x - points[0].x, markedPlaceWidth, Objects.OBJECT_WALL, new PointF(points[0].x, points[0].y)));
		   		}
	        }
			
			//right wall
	        if ((neutralizedWallsInThisArea == null) || !neutralizedWallsInThisArea.contains(new Integer(RIGHT_WALL))) {
		   		if ((doorsInThisArea != null) && doorsInThisArea.contains(new Integer(RIGHT_WALL))) {
		   			objectsPlaced.add(new MarkedPosition(markedPlaceWidth, ( ((points[1].y - points[0].y)>>1) - (doorWidth>>1) ), Objects.OBJECT_WALL, new PointF(points[1].x, points[0].y)));
		   			objectsPlaced.add(new MarkedPosition(markedPlaceWidth, ( ((points[1].y - points[0].y)>>1) - (doorWidth>>1) ), Objects.OBJECT_WALL, new PointF(points[1].x, (( ((points[1].y - points[0].y)>>1) - (doorWidth>>1) )) + doorWidth + markedPlaceWidth + points[0].y)));
		   		} else {
		   			objectsPlaced.add(new MarkedPosition(markedPlaceWidth, points[1].y - points[0].y + markedPlaceWidth, Objects.OBJECT_WALL, new PointF(points[1].x, points[0].y)));
		   		}
	        }
			
			//bottom wall
	        if ((neutralizedWallsInThisArea == null) || !neutralizedWallsInThisArea.contains(new Integer(BOTTOM_WALL))) {
		   		if ((doorsInThisArea != null) && doorsInThisArea.contains(new Integer(BOTTOM_WALL))) {
		   			objectsPlaced.add(new MarkedPosition((( ((points[1].x - points[0].x)>>1) - (doorWidth>>1))), markedPlaceWidth, Objects.OBJECT_WALL, new PointF(points[0].x, points[1].y)));
		   			objectsPlaced.add(new MarkedPosition((( ((points[1].x - points[0].x)>>1) - (doorWidth>>1) )), markedPlaceWidth, Objects.OBJECT_WALL, new PointF((( ((points[1].x - points[0].x)>>1) - (doorWidth>>1) )) + doorWidth + markedPlaceWidth + points[0].x, points[1].y)));
		   		} else {
		   			objectsPlaced.add(new MarkedPosition(points[1].x - points[0].x, markedPlaceWidth, Objects.OBJECT_WALL, new PointF(points[0].x, points[1].y)));
		   		}
	        }
		}		
		this.setObjectsPlaced(objectsPlaced);
	}
	
	@Override
	protected void createObjects() {
		for (MarkedPosition obj : objectsPlaced) {
			scene.attachChild(obj.getRectangle());
		}
	}

}
