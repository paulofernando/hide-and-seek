package com.hideandseek.gameplay;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

/** 
 * @author paulofernando
 *
 */
public class Gameplay extends BaseGameActivity {

	private Camera mCamera;
	/** Informations on the screen */
	private HUD hud;
	
	public Texture mTexture;	
	public static TiledTextureRegion mPlayerTextureRegion;
	protected Scene scene;
	
	private 
	
	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoadResources() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		return null;
	}

}
