package model.updateStrategy;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.MultiInteractStrategy;
import model.ball.Ball;
import util.IDispatcher;

/**
 * kill/removing behavior implemented purely as an interaction strategy.   
 * Combine with Overlap/Collide to see killing balls.
 * @author Yuhui Tong, Zhenwei Feng
 *
 * @param <TDispMsg> The message dispatched by dispatcher.
 */
public class KillStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/**
	 * {@inheritDoc}<br/>
	 * Initialize a pure interact strategy that removes target balls.
	 */
	public void init(Ball context) {
		// System.out.println("KILLING INIT!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				if (context == target) {
					return;
				}
				//System.out.println("I am killing!");
				disp.deleteObserver(target);
			}
		}));
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> disp) {
		//no-op
	}

}
