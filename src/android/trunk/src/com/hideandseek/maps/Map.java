package com.hideandseek.maps;

import java.util.Vector;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import com.hideandseek.gameplay.Gameplay;
import com.hideandseek.maps.objects.LittleSquare;

/**
 * Generic map
 * @author paulofernando
 *
 */
public abstract class Map extends Gameplay {
	
	/** Vector of the positions where the objects was placed in the map*/
	protected Vector<LittleSquare> objectsPlaced;
	
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
		for (LittleSquare obj : objectsPlaced) {
			if (obj.getRectangle().collidesWith(hiddenPlayer)) {				
				return true;
			}
		}
		return false;
	}
	

	

}
