package com.hideandseek.maps;

import java.util.Vector;

import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.hideandseek.gameplay.Gameplay;
import com.hideandseek.players.HiddenPlayer;

/**
 * The genirc map
 * @author paulofernando
 *
 */
public abstract class Map extends Gameplay {
	
	/** Vector of the positions where the objects was placed in the map*/
	private Vector<LittleSquare> objectsPlaced;
	
	private HiddenPlayer hiddenPlayer;
	
	public Map(Vector<LittleSquare> objectsPlaced) {
		this.objectsPlaced = objectsPlaced;
		
		//TODO to change the fixed values
		hiddenPlayer = new HiddenPlayer(30f, 30f, Gameplay.mPlayerTextureRegion);
		scene.getLastChild().attachChild(hiddenPlayer);
	}
	
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
	protected class LittleSquare {
		
		/** Height of the square */
		private int height;
		/** Width of the square	*/
		private int width;
		
		/** Type of the object. Can be */
		private int type;
		
		/**
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
