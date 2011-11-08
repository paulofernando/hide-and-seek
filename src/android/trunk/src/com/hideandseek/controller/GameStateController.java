package com.hideandseek.controller;

import com.hideandseek.gameplay.Gameplay;

import android.app.Activity;
import android.content.Intent;

/**
 * Controls the actual state and the flow of the game
 * @author paulofernando
 *
 */
public class GameStateController {
	
	/** Start a new game */
	public static void startNewGame(Activity screen) {
		Intent i = new Intent(screen, Gameplay.class);
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
