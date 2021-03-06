package model.paint.strategy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import model.ball.Ball;

/**
 * Paint strategy that paints a filled circle with the Ball's radius. 
 * This functionality is duplicated by the EllipsePaintStrategy.
 * The class demonstrates a direct implementation of IPaintStrategy.
 * @author Yuhui Tong, Haoyuang Yue
 *
 */
public class BallPaintStrategy implements IPaintStrategy {

	/**
	 * The AffineTransformed used for internal calculations.
	 */
	private AffineTransform at;

	/**
	 * Unit sized circle used as a prototype
	 */
	private Ellipse2D.Double ball;

	/**
	 * No parameter constructor that creates a 1 pixel radius ball at the origin.
	 */
	public BallPaintStrategy() {
		this.at = new AffineTransform();
		this.ball = new Ellipse2D.Double(-1.0, -1.0, 2.0, 2.0);
	}

	/**
	 * Constructor that allows one to create the prototype ball of arbitrary dimension and location.
	 * @param at The given AffineTransformed used for internal calculations.
	 * @param x floating point x-coordinate of center of circle
	 * @param y floating point y-coordinate of center of circle
	 * @param width floating point x-radius of the circle (ellipse)
	 * @param height floating point y-radius of the circle (ellipse)
	 */
	public BallPaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		this.at = at;
		this.ball = new Ellipse2D.Double(x - width, y - height, 2 * width, 2 * height);
	}

	/**
	 * Paints on the given graphics context using the color, scale and direction provided by the host. 
	 * This is done by setting up the AffineTransform to scale then translate. 
	 * Calls paintXfrm to actually perform the painting, 
	 * using the set up transform. Calls paintCfg just before calling paintXfrm 
	 * param g The Graphics context that will be paint on param host The host Ball
	 *  that the required information will be pulled from.
	 *  @param g The graphics context to draw upon.
	 *  @param host The host ball.
	 */
	@Override
	public void paint(Graphics g, Ball host) {
		double scale = host.getRadius();

		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.rotate(host.getVelocity().x, host.getVelocity().y);
		at.scale(scale, scale);
		Shape newShape = at.createTransformedShape(ball);
		g.setColor(host.getColor());
		((Graphics2D) g).fill(newShape);

	}

	/**
	 * By default, do nothing for initialization.
	 * @param host The ball to initialize.
	 */
	@Override
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}

}
