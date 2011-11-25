package com.hideandseek.maps;

import java.util.Vector;

import org.anddev.andengine.entity.primitive.Rectangle;

import android.graphics.PointF;

import com.hideandseek.maps.objects.MarkedPosition;
import com.hideandseek.maps.objects.Objects;
import com.hideandseek.players.HiddenPlayer;

/**
 * Map very simple with 3 areas to the player to hide
 * @author paulofernando
 *
 */
public class SimpleMap extends Map {

	private HiddenPlayer hiddenPlayer;
	
	public SimpleMap() {
		super();
		
		objectsPlaced = new Vector<MarkedPosition>();
		objectsPlaced.add(new MarkedPosition(20, 300, Objects.OBJECT_WALL, new PointF(400.f, 0.f)));
		objectsPlaced.add(new MarkedPosition(300, 20, Objects.OBJECT_WALL, new PointF(0.f, 400.f)));
		this.setObjectsPlaced(objectsPlaced);
	}
	
	@Override
	protected void createObjects() {		
		for (MarkedPosition obj : objectsPlaced) {
			scene.attachChild(obj.getRectangle());
		}
	}


}
