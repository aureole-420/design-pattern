package model;

import model.ball.Ball;
import util.IDispatcher;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * This strategy merges two child strategy such that a ball behaves in both manner.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public class MultiStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/**
	 * The first child strategy to merge with
	 */
	private IUpdateStrategy<TDispMsg> strat1;

	/**
	 * The second child strategy to merge with
	 */
	private IUpdateStrategy<TDispMsg> strat2;

	/**
	 * Constructor of MultiStrategy.
	 * @param strat1 The first child strategy to merge with.
	 * @param strat2 The second child strategy to merge with.
	 */
	public MultiStrategy(IUpdateStrategy<TDispMsg> strat1, IUpdateStrategy<TDispMsg> strat2) {
		this.strat1 = strat1;
		this.strat2 = strat2;
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	@Override
	public void updateState(Ball context, IDispatcher<TDispMsg> disp) {
		strat1.updateState(context, disp);
		strat2.updateState(context, disp);
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	@Override
	public void init(Ball context) {
		strat1.init(context);
		strat2.init(context);
	}

}
