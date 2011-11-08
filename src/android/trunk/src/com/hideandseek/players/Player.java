package com.hideandseek.players;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

/**
 * The generic player
 * @author paulofernando
 *
 */
public abstract class Player extends AnimatedSprite implements Walker {

	/**
	 * @param pX Position of the pigeon on the Axis X
	 * @param pY Position of the pigeon on the Axis Y
	 * @param pTextureRegion Texture of the pigeon
	 */
	public Player(float pX, float pY, TiledTextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		// TODO Auto-generated constructor stub
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
