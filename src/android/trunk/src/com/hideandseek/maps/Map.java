package com.hideandseek.maps;

import java.util.Vector;

/**
 * The genirc map
 * @author paulofernando
 *
 */
public abstract class Map {
	
	/** Vector of the positions where the objects was placed in the map*/
	private Vector<LittleSquare> objectsPlaced; 
		
	
	public Vector<LittleSquare> getObjectsPlaced() {
		return objectsPlaced;
	}


	public void setObjectsPlaced(Vector<LittleSquare> objectsPlaced) {
		this.objectsPlaced = objectsPlaced;
	}


	/**
	 * Square where can position a object in the map
	 * @author paulofernando
	 *
	 */
	private class LittleSquare {
		
		/** Height of the square */
		private int height;
		/** Width of the square	*/
		private int width;
		
		/** Type of the object. Can be */
		private int type;
		
		/**
		 * Get the type of the object placed in the square
		 * @return Type of the object placed in the square
		 */
		public int getType() {
			return type;
		}
		
		/**
		 * Defines the type of object. List of the types in com.hideandseek.maps.objects.Objects
		 * @param type
		 */
		public void setType(int type) {
			this.type = type;
		}
		
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
	}

}
