package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

/**
 * An concrete subclass of ABall
 * A CurvingBall does the rotational motion.
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0
 */
public class CurvingBall extends ABall {

	/**
	 * The angular velocity (theta/_timeslice)
	 */
	private double theta = Math.PI / 10;

	/**
	 * Constructor of CurvingBall
	 * @param startLoc Initial location of the ball
	 * @param startRadius Initial radius of the ball
	 * @param startVel Initial velocity of the ball
	 * @param startColor Initial color of the ball
	 * @param theCanvas The canvas jpanel object
	 */
	public CurvingBall(Point initialLocation, int initialRadius, Point initialVelocity, Color initialColor, Component theCanvas) {
		super(initialLocation, initialRadius, initialVelocity, initialColor, theCanvas);
	}

	/**
	 * Overriden method that simulate the movement of the curving ball
	 * Vnew = Vold*exp(i*theta).
	 */
	@Override
	public void updateBalls() {
		int tempx = velocity.x;
		velocity.x = (int) Math.round(tempx * Math.cos(theta) - velocity.y * Math.sin(theta));
		velocity.y = (int) Math.round(velocity.y * Math.cos(theta) + tempx * Math.sin(theta));
	}
}
