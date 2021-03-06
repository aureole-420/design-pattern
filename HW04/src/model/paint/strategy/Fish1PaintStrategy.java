package model.paint.strategy;

import java.awt.geom.AffineTransform;

import model.paint.shape.Fish1PolygonFactory;

/**
 * Paint strategy that paints a fish-shaped Polygon generated by a Fish1PolyfonFactory.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class Fish1PaintStrategy extends ShapePaintStrategy {

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use
	 */
	public Fish1PaintStrategy() {
		super(new Fish1PolygonFactory().makeShape(0, 0, 1.0, 1.0));
	}

	/**
	 * Constructor that takes an external AffineTransform
	 * @param at The AffineTransform to use for internal use.
	 */
	public Fish1PaintStrategy(AffineTransform at) {
		super(at, new Fish1PolygonFactory().makeShape(0, 0, 1, 1));
	}

}
