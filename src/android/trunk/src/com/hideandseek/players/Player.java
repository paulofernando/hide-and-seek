package com.hideandseek.players;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

/**
 * The generic player
 * @author paulofernando
 *
 */
public abstract class Player extends AnimatedSprite implements Walker {
	
	/** New position in axis X to the Player */
	protected float newPosX;
	/** New position in axis Y to the Player */
	protected float newPosY;
	
	/** Started position in axis X to the Player when he moves */
	protected float startPosX;
	/** Started position in axis Y to the Player when he moves */
	protected float startPosY;
	
	protected final PhysicsHandler mPhysicsHandler;
	
	/** Milliseconds by frame of the texture */
	protected int millisecondsByFrame = 150;
	
	private float velocity = 100f;
	
	private boolean stoped = true;
	
	/**
	 * @param pX Position of the pigeon on the Axis X
	 * @param pY Position of the pigeon on the Axis Y
	 * @param pTextureRegion Texture of the character
	 */
	public Player(final float pX, final float pY, final TiledTextureRegion pTextureRegion) {
		super(pX, pY, pTextureRegion);
		newPosX = pX;
		newPosY = pY;
		
		this.mPhysicsHandler = new PhysicsHandler(this);
		this.registerUpdateHandler(this.mPhysicsHandler);
	}
	
	@Override
	public void move(float posX, float posY) {		 
		newPosX = posX;
		newPosY = posY;
		startPosX = this.getX();
		startPosY = this.getY();
		stoped = false;
	}
	
	public void stop(boolean collided) {		
		if(collided) {
			newPosX = (startPosX > this.getX() ? this.getX() + 5 : this.getX() - 5);
			newPosY = (startPosY > this.getY() ? this.getY() + 5 : this.getY() - 5);
			this.setPosition(newPosX, newPosY);
		} else {
			newPosX = startPosX = this.getX();
			newPosY = startPosY = this.getY();
		}
		stoped = true;
	}
	
	@Override
	/** This method is called constantly. It's is called each interval of "pSecondsElapsed" */
	 protected void onManagedUpdate(final float pSecondsElapsed) {		
		if (((Math.abs(newPosX - this.getX()) > 10) || (Math.abs(newPosY - this.getY()) > 10)) && (!stoped)) {			
			if (Math.abs(newPosX - this.getX()) > Math.abs(newPosY - this.getY())) {
				this.mPhysicsHandler.setVelocityY(this.velocity * (newPosY < this.getY() ? - 1: 1));
				this.mPhysicsHandler.setVelocityX((newPosX - this.getX()) * (this.getY()/newPosY));
			} else {
				this.mPhysicsHandler.setVelocityX(this.velocity * (newPosX < this.getX() ? - 1: 1));		
				this.mPhysicsHandler.setVelocityY((newPosY - this.getY()) * (this.getX()/newPosX));
				
			}			
		} else {
			this.mPhysicsHandler.setVelocityY(0.f);
			this.mPhysicsHandler.setVelocityX(0.f);
		}		
		super.onManagedUpdate(pSecondsElapsed);
	 }	

}
