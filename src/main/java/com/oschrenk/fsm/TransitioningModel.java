package com.oschrenk.fsm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The {@link TransitioningModel} describes the allowed transitions between the
 * states of a state machine.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 * @param <E>
 */
public class TransitioningModel<E extends Enum<?>> {

	private Map<Transition<E>, Boolean> map;

	/**
	 * Default constuctor.
	 */
	public TransitioningModel() {
		this.map = new HashMap<Transition<E>, Boolean>();
	}

	/**
	 * Allow a single transition
	 * 
	 * @param from
	 *            Start state
	 * @param to
	 *            End state
	 */
	public void allow(E from, E to) {
		this.map.put(new Transition<E>(from, to), true);
	}

	/**
	 * Convenience method to allow transitions from a single state to multiple
	 * states at once.
	 * 
	 * @param from
	 *            Start state
	 * @param to
	 *            Target states
	 */
	public void allow(E from, Set<E> to) {
		for (E e : to) {
			allow(from, e);
		}
	}

	/**
	 * Checks if a transition from one state to another is allowed using the
	 * constructed rules
	 * 
	 * @param from
	 *            Start state
	 * @param to
	 *            Target state
	 * @return <code>true</code>If valid transition, <code>false</code>otherwise
	 */
	protected boolean isValidTransition(E from, E to) {
		Boolean b = map.get(new Transition<E>(from, to));
		if (b == null) {
			return false;
		}
		return b;
	}
}
