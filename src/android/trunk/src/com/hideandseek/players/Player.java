package com.hideandseek.players;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.view.KeyEvent;

/**
 * The generic player
 * @author paulofernando
 *
 */
public abstract class Player extends AnimatedSprite implements Walker {

	protected float myPosX;
	protected float myPosY;
	
	/** Milliseconds by frame of the texture */
	protected int millisecondsByFrame = 150;
	
	private int velocity = 10;
	
	/**
	 * @param pX Position of the pigeon on the Axis X
	 * @param pY Position of the pigeon on the Axis Y
	 * @param pTextureRegion Texture of the character
	 */
	public Player(final float pX, final float pY, final TiledTextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		myPosX = pX;
		myPosY = pY;
	}
	
	@Override
	public void moveUp() {
		myPosY -= velocity;
	}

	@Override
	public void moveDown() {
		myPosY += velocity;		
	}

	@Override
	public void moveLeft() {
		myPosX -= velocity;
	}

	@Override
	public void moveRight() {
		myPosX += velocity;
	}
	
	@Override
	/** This method is called constantly. It's is called each interval of "pSecondsElapsed" */
	 protected void onManagedUpdate(final float pSecondsElapsed) {  
		this.setPosition(myPosX, myPosY);
		super.onManagedUpdate(pSecondsElapsed);
	 	
	 }	

}
