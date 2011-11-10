package com.hideandseek.gameplay;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.handler.runnable.RunnableHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnAreaTouchListener;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;

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

	private BitmapTextureAtlas mFontTexture;
	private Font mFont;

	public static final int CAMERA_WIDTH = 720;
	public static final int CAMERA_HEIGHT = 480;

	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion mFaceTextureRegion;
	
	private HiddenPlayer hiddenPlayer;

	public Gameplay() {
		super();
	}

	@Override
	public Engine onLoadEngine() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT),
				this.mCamera));
	}

	@Override
	public void onLoadResources() {

		this.mBitmapTextureAtlas = new BitmapTextureAtlas(64, 32, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mFaceTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(this.mBitmapTextureAtlas, this, "face_circle_tiled.png", 0, 0, 2, 1);

		this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);

		// -------- Text -------
		this.mFontTexture = new BitmapTextureAtlas(256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mFont = new Font(this.mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 36, true, Color.WHITE);
		this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
		this.mEngine.getFontManager().loadFont(this.mFont);
		// ---------------------
	}

	@Override
	public void onLoadComplete() {

	}

	@Override
	public Scene onLoadScene() {
		final Scene scene = new Scene();
		scene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));

		this.scoreText = new ChangeableText(20, 10, this.mFont, "Score: ",
				"Highcore: XXXXX".length());
		scene.attachChild(scoreText);

		this.mEngine.registerUpdateHandler(new FPSLogger());

		final int centerX = (CAMERA_WIDTH - this.mFaceTextureRegion.getWidth()) / 2;
		final int centerY = (CAMERA_HEIGHT - this.mFaceTextureRegion.getHeight()) / 2;
		hiddenPlayer = new HiddenPlayer(centerX, centerY, this.mFaceTextureRegion);
		
		scene.attachChild(hiddenPlayer);

		scene.setOnAreaTouchListener(new IOnAreaTouchListener() {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final ITouchArea pTouchArea, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN) {
					final RunnableHandler runnableHandler = new RunnableHandler();
					Gameplay.this.mEngine.getScene().registerUpdateHandler(runnableHandler);
					runnableHandler.postRunnable(new Runnable() {
						@Override
						public void run() {
							System.out.println("Touched!");
							Gameplay.this.hiddenPlayer.move(pTouchAreaLocalX, pTouchAreaLocalY);
						}
					});
					return true;
				}
				return false;
			}
		});
		scene.setTouchAreaBindingEnabled(true);
		
		return scene;

	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
        int myEventAction = event.getAction(); 

        float x = event.getX();
        float y = event.getY();

        switch (myEventAction) {
           case MotionEvent.ACTION_DOWN:
        	   hiddenPlayer.move(x, y);
        	break;
        }
        return true;
    }
	
	/*@Override
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {
		if (pEvent.getAction() == KeyEvent.ACTION_DOWN) {
			if (pKeyCode == KeyEvent.KEYCODE_DPAD_UP) {
				hiddenPlayer.moveUp();
			} else if (pKeyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
				hiddenPlayer.moveDown();
			} else if (pKeyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
				hiddenPlayer.moveLeft();
			} else if (pKeyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
				hiddenPlayer.moveRight();
			} else {
				return super.onKeyDown(pKeyCode, pEvent);
			}
			return true;
		}
		return super.onKeyDown(pKeyCode, pEvent);
	}*/

}
