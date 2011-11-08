package com.hideandseek.gameplay;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.hideandseek.players.HiddenPlayer;

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
	
	public static final int CAMERA_WIDTH = 720;
	public static final int CAMERA_HEIGHT = 480;
	
	@Override
	public Engine onLoadEngine() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));	
	}

	@Override
	public void onLoadResources() {
		this.scene = new Scene(1);
//		this.mTexture = new Texture(1024, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
//		Gameplay.mPlayerTextureRegion = TextureRegionFactory.createTiledFromAsset(this.mTexture, this, "gfx/player.png", 0, 0, 0, 0);
	}
	
	@Override
	public void onLoadComplete() {
			
	}
	

	@Override
	public Scene onLoadScene() {
		scene.setBackground(new ColorBackground(1, 0, 0));
		return null;
	}

}
