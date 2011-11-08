package com.hideandseek.controller;

import android.app.Activity;
import android.content.Intent;

import com.hideandseek.maps.SimpleMap;

/**
 * Controls the actual state and the flow of the game
 * @author paulofernando
 *
 */
public class GameStateController {
	
	/** Start a new game */
	public static void startNewGame(Activity screen) {
		Intent i = new Intent(screen, SimpleMap.class);
		i.putExtra("type", "new");
		screen.startActivity(i);
	}
	
	/** Continues a old game */
	public static void continueOldGame() {
		
	}

	/** Sets up the game options */
	public static void setupGame() {
		
	}
	
}
