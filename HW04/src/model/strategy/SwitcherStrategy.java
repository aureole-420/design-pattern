package model.strategy;

import model.ball.Ball;
import util.Dispatcher;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * The ball taking this strategy can take different strategies during runtime!
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public class SwitcherStrategy implements IUpdateStrategy {

	/**
	 * The actual strategy that a switch ball is taking.
	 */
	private IUpdateStrategy strategy;

	/**
	 * Constructor of SwitcherStrategy.
	 */
	public SwitcherStrategy() {

	}

	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	@Override
	public void updateState(Ball context, Dispatcher disp) {
		if (strategy != null)
			strategy.updateState(context, disp);

	}

	/**
	 * Strategy setter that modifield that actual strategy a switch ball is taking.
	 * @param newStrategy The new strategy that a switch ball is going to take.
	 */
	public void setStrategy(IUpdateStrategy newStrategy) {
		strategy = newStrategy;
	}

}
