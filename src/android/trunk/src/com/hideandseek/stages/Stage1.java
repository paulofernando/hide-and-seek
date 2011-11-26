package com.hideandseek.stages;

import java.util.HashMap;

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
	    
	    try {
			setWalls(areas);
		} catch (InvalidMapException e) {			
			System.out.println("Error: " + e);
		}
	    
	  }
}
