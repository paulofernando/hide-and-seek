package com.hideandseek.maps;

import java.util.Vector;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import com.hideandseek.gameplay.Gameplay;
import com.hideandseek.maps.objects.MarkedPosition;

/**
 * Generic map
 * @author paulofernando
 *
 */
public abstract class Map extends Gameplay {
	
	/** Vector of the positions where the objects was placed in the map*/
	protected Vector<MarkedPosition> objectsPlaced;
	
	public Map() {
		super();		
	}
	
	/** @return list of the objects saved in the map */
	public Vector<MarkedPosition> getObjectsPlaced() {
		return objectsPlaced;
	}

	/**
	 * Sets up the objects and its positions in the map
	 * @param objectsPlaced
	 */
	public void setObjectsPlaced(Vector<MarkedPosition> objectsPlaced) {
		this.objectsPlaced = objectsPlaced;
	}
	
	@Override
	public Scene onLoadScene() {		
		Scene ret =  super.onLoadScene();
		collisionModeOn();
		return ret;
	}

	private void collisionModeOn() {
		scene.registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {}

			@Override
			public void onUpdate(final float pSecondsElapsed) {
				if (collisionWithAnObject()) {
					hiddenPlayer.stop(true);
				}
			}
		});
	}
	
	protected boolean collisionWithAnObject() {
		for (MarkedPosition obj : objectsPlaced) {
			if (obj.getRectangle().collidesWith(hiddenPlayer)) {				
				return true;
			}
		}
		return false;
	}
	

}
