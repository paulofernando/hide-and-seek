package com.hideandseek.gui.menu;

import com.hideandseek.R;
import com.hideandseek.controller.GameStateController;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;

/**
 * Main Menu of the game. This is the screen what presents the options to start and set up the game
 * @author paulofernando
 *
 */
public class MainMenuActivity extends Activity {
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setupBtListeners();
        
    }

	private void setupBtListeners() {
		findViewById(R.id.btStart).setOnClickListener(
	        new OnClickListener() {
	            public void onClick(View v) {
	            	GameStateController.startNewGame();
	            }
	        }
        );
	}
}