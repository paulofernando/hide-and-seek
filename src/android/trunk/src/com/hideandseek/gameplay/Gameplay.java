package com.hideandseek.gameplay;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.graphics.Color;
import android.graphics.Typeface;

import com.hideandseek.players.HiddenPlayer;

/** 
 * @author paulofernando
 *
 */
public class Gameplay extends BaseGameActivity {

	private Camera mCamera;
	/** Informations on the screen */
	private HUD hud;
	private ChangeableText scoreText;
	
	public BitmapTextureAtlas mTexture;	
	public static TextureRegion mPlayerTextureRegion;
	protected Scene scene;
	
	private BitmapTextureAtlas mFontTexture;
	private Font mFont;
	
	public static final int CAMERA_WIDTH = 720;
	public static final int CAMERA_HEIGHT = 480;
	
	public Gameplay() {
		super();
	}
	
	@Override
	public Engine onLoadEngine() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera));	
	}

	@Override
	public void onLoadResources() {
		this.scene = new Scene();
		
		this.mTexture = new BitmapTextureAtlas(256, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		Gameplay.mPlayerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mTexture, this, "gfx/player.png", 0, 0);
        this.mEngine.getTextureManager().loadTexture(this.mTexture);
        
        // 	-------- Text -------
		// this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		// this.mFont = new Font(this.mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 36, true, Color.WHITE);
		// this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
		// this.mEngine.getFontManager().loadFont(this.mFont);
 		// ---------------------
	}
	
	@Override
	public void onLoadComplete() {
			
	}
	

	@Override
	public Scene onLoadScene() {
		scene.setBackground(new ColorBackground(1, 0, 0));
		
		// this.scoreText = new ChangeableText(20, 10, this.mFont, "Score: ", "Highcore: XXXXX".length());
		// scene.getLastChild().attachChild(scoreText);
		
		return scene;
	}

}
