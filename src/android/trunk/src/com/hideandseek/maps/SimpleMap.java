package com.hideandseek.maps;

import java.util.Vector;

import com.hideandseek.gameplay.Gameplay;
import com.hideandseek.maps.Map.LittleSquare;
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
		
		Vector<LittleSquare> objectsPlaced = new Vector();
		
		
		this.setObjectsPlaced(objectsPlaced);
	}

}
