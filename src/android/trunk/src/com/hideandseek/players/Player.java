package com.hideandseek.players;

import org.anddev.andengine.engine.handler.physics.PhysicsHandler;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.util.Log;

/**
 * The generic player
 * @author paulofernando
 *
 */
public abstract class Player extends AnimatedSprite implements Walker {
	
	/** New position in axis X to the Player */
	protected float newPosX;		
	/** Current position in axis X to the Player when he moves */
	protected float currentPosX;
	/** Previous position */
	protected float previousPosX;
	
	protected float startPosX;
	
	/** New position in axis Y to the Player */
	protected float newPosY;
	/** Current position in axis Y to the Player when he moves */
	protected float currentPosY;
	/** Previous position */
	protected float previousPosY;
	
	protected float startPosY;
	
	protected final PhysicsHandler mPhysicsHandler;
	
	/** Milliseconds by frame of the texture */
	protected int millisecondsByFrame = 150;
	
	private float velocity = 100f; // 100px/s
	
	private boolean stoped = true;
	
	private long initialTime, elapsedTime, finalTime;
	
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
		initialTime = System.currentTimeMillis();
		elapsedTime = 0L;
		finalTime = (long)((Math.max(Math.abs(posX - this.getX()), Math.abs(posY - this.getY()))/velocity) * 1000);
		
		newPosX = posX;
		newPosY = posY;
		startPosX = currentPosX = this.getX();
		startPosY = currentPosY = this.getY();
		
		stoped = false;
	}
	
	public void stop(boolean collided) {		
		if(collided) {
			newPosX = (currentPosX > this.getX() ? this.getX() + 5 : this.getX() - 5);
			newPosY = (currentPosY > this.getY() ? this.getY() + 5 : this.getY() - 5);
			this.setPosition(newPosX, newPosY);
		} else {
			newPosX = currentPosX = this.getX();
			newPosY = currentPosY = this.getY();
		}
		stoped = true;
	}
	
	@Override
	/** This method is called constantly. It's is called each interval of "pSecondsElapsed" */
	 protected void onManagedUpdate(final float pSecondsElapsed) {		
//		if (((Math.abs(newPosX - this.getX()) > 10) || (Math.abs(newPosY - this.getY()) > 10)) && (!stoped)) {
		if ((!stoped) && (elapsedTime < finalTime)) {
			elapsedTime = System.currentTimeMillis() - initialTime;
			
			previousPosX = currentPosX;
			previousPosY = currentPosY;
			currentPosX = (float)((elapsedTime * Math.abs(newPosX - startPosX)/finalTime));
			currentPosY = (float)((elapsedTime * Math.abs(newPosY - startPosY)/finalTime));
			
			currentPosX = (((Math.abs(newPosX - this.getX()) > Math.abs(newPosY - this.getY())) && (newPosX < this.getX())) ? -1 : 1) * currentPosX + this.getX();
			currentPosY = (((Math.abs(newPosX - this.getX()) > Math.abs(newPosY - this.getY())) && (newPosY < this.getY())) ? -1 : 1) * currentPosY + this.getY();
			Log.i("pos", "x: " + currentPosX + " e y: " + currentPosY + " | elapsed: " + elapsedTime);
			
			this.setPosition(currentPosX, currentPosY);			
		} else {
			this.mPhysicsHandler.setVelocityY(0.f);
			this.mPhysicsHandler.setVelocityX(0.f);
		}		
		super.onManagedUpdate(pSecondsElapsed);
	 }	

}
