package com.hideandseek.players;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

/**
 * The generic player
 * @author paulofernando
 *
 */
public abstract class Player extends Sprite implements Walker {

	/** Milliseconds by frame of the texture */
	protected int millisecondsByFrame = 150;
	
	/**
	 * @param pX Position of the pigeon on the Axis X
	 * @param pY Position of the pigeon on the Axis Y
	 * @param pTextureRegion Texture of the pigeon
	 */
	public Player(float pX, float pY, TextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
	}

	protected static int playerPosX;
	protected static int playerPosY;
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

}
