package com.hideandseek.maps.objects;

import org.anddev.andengine.entity.scene.background.ColorBackground;

/**
 * Type of objects what can be placed in the map
 * @author paulofernando
 *
 */
public class Objects {
	
	public static int OBJECT_WALL = 0;
	
	public static ColorBackground colors[] = {new ColorBackground(1, 0, 0) //OBJECT_WALL
											 };
	
	/**
	 * Retrieve the color of the object.
	 * @param type Type of object
	 * @return Color of the object. If the type does not exists, the color returned will be green
	 */
	public static ColorBackground getTypeColor(int type) {
		if((type >= 0) && (type < colors.length)) {
			return colors[type];
		}
		return new ColorBackground(0, 1, 0);
	}
	
}
