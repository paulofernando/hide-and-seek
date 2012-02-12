package com.hideandseek.stages;

import java.util.HashMap;
import java.util.Vector;

import com.hideandseek.exceptions.InvalidDoorException;
import com.hideandseek.exceptions.InvalidMapException;
import com.hideandseek.maps.SimpleDivisibleMap;

import android.graphics.Point;
import android.os.Bundle;

public class Stage1 extends SimpleDivisibleMap {

	@Override
	protected void onCreate(final Bundle pSavedInstanceState) {
	    super.onCreate(pSavedInstanceState);
	    
	    HashMap<String, Point[]> areas = new HashMap<String, Point[]>();
	    areas.put("pique", new Point[]{new Point(0, 0), new Point(300, 300)});
	    areas.put("room1", new Point[]{new Point(300, 0), new Point(600, 300)});
	    areas.put("room2", new Point[]{new Point(0, 300), new Point(600, 600)});
	    
	    try {
			setWalls(areas);
						
			HashMap<String, Vector<Integer>> neutralizedeWalls = new HashMap<String, Vector<Integer>>();
			
			Vector<Integer> nw = new Vector<Integer>();
			nw.add(new Integer(SimpleDivisibleMap.RIGHT_WALL));
			neutralizedeWalls.put("pique", nw);
			
			Vector<Integer> nw1 = new Vector<Integer>();
			nw1.add(new Integer(SimpleDivisibleMap.LEFT_WALL));
			neutralizedeWalls.put("room1", nw1);
			
			Vector<Integer> nw2 = new Vector<Integer>();
			nw2.add(new Integer(SimpleDivisibleMap.UP_WALL));			
			neutralizedeWalls.put("room2", nw2);
									
			neutralizeTheWalls(neutralizedeWalls);
						
			//---------------- Doors ------------------
			HashMap<String, Vector<Integer>> doors = new HashMap<String, Vector<Integer>>();
			Vector<Integer> d = new Vector<Integer>();
			d.add(new Integer(SimpleDivisibleMap.BOTTOM_WALL));			
			Vector<Integer> d2 = new Vector<Integer>();
			d2.add(new Integer(SimpleDivisibleMap.BOTTOM_WALL));
			
		    doors.put("pique", d);
		    doors.put("room1", d2);
		    //-------------------------------------------
		    
		    try {
				setDoors(doors);
			} catch (InvalidDoorException e) {			
				System.out.println("Error: " + e);
			}
		    
		    this.riseUpTheWalls();
		} catch (InvalidMapException e) {			
			System.out.println("Error: " + e);
		}
	  }
}
