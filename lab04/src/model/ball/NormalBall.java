package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

/**
 * An concrete subclass of ABall
 * A NormalBall keeps its velocity unless when hitting walls.
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0
 */
public class NormalBall extends ABall {

	/**
	 * Constructor of NormalBall
	 * @param startLoc Initial location of the ball
	 * @param startRadius Initial radius of the ball
	 * @param startVel Initial velocity of the ball
	 * @param startColor Initial color of the ball
	 * @param theCanvas The canvas jpanel object
	 */
	public NormalBall(Point initialLocation, int initialRadius, Point initialVelocity, Color initialColor, Component theCanvas) {
		super(initialLocation, initialRadius, initialVelocity, initialColor, theCanvas);
	}

	@Override
	public void updateBalls() {
	}

}
