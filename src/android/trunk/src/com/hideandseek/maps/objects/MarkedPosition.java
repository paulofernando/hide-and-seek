package com.hideandseek.maps.objects;

import org.anddev.andengine.entity.primitive.Rectangle;

import android.graphics.PointF;

/**
 * Rectangle where can position an object in the map
 * @author paulofernando
 *
 */
public class MarkedPosition {
	
	/** Height of the rectangle */
	private int height;
	/** Width of the rectangle	*/
	private int width;
	/** The object's position in the scene */		
	private PointF position;
	
	/** Type of the object. Can be */
	private int type;
	
	private Rectangle rect;
		
	/**
	 * Instances a new rectangle to position an object
	 * @param width Width of the rectangle
	 * @param height Height of the rectangle
	 * @param type Type of the object
	 * @param position The object's position in the scene
	 */
	public MarkedPosition(int width, int height, int type, PointF position) {
		this.width = width;
		this.height = height;
		this.type = type;
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
	
	public Rectangle getRectangle() {
		if(rect == null) {
			rect = new Rectangle(position.x, position.y, width, height);
			rect.setColor(0.3f, 0.3f, 0.3f);
		}
		return rect;
	}
	
	public PointF getPosition() {
		return position;
	}

	public void setPosition(PointF position) {
		this.position = position;
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