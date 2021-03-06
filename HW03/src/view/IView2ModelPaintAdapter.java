package view;

import java.awt.Graphics;

/**
 * The interface of the adapter from the view to the model that enables the view to talk to the model.
 * @author Yuhui Tong, Shengqi Wang.
 * @version 1.0
 */
public interface IView2ModelPaintAdapter {
	/**
	 * let the model paint
	 * @param g The graphic object
	 */
	public void paint(Graphics g);

	/**
	 * "null" object to insure that view's operation is valid.
	 */
	public static final IView2ModelPaintAdapter NULL_OBJECT = new IView2ModelPaintAdapter() {

		public void paint(Graphics g) {

		}
	};	
}
