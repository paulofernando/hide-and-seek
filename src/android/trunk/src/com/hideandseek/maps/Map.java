package com.hideandseek.maps;

import java.util.Vector;

import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.graphics.PointF;

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
	
	public Map() {
		super();		
	}
	
	/** @return list of the objects saved in the map */
	public Vector<LittleSquare> getObjectsPlaced() {
		return objectsPlaced;
	}

	/**
	 * Sets up the objects and its positions in the map
	 * @param objectsPlaced
	 */
	public void setObjectsPlaced(Vector<LittleSquare> objectsPlaced) {
		this.objectsPlaced = objectsPlaced;
	}


	/**
	 * Square where can position a object in the map
	 * @author paulofernando
	 *
	 */
	public class LittleSquare {
		
		/** Height of the square */
		private int height;
		/** Width of the square	*/
		private int width;
		/** The object's position in the scene */		
		private PointF position;
		
		/** Type of the object. Can be */
		private int type;
		
		public LittleSquare(int width, int height, int type) {
			this.width = width;
			this.height = height;
			this.type = type;
		}
		
		public LittleSquare(int width, int height, int type, PointF position) {
			this(width, height, type);
			this.position = position;
		}
		
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
