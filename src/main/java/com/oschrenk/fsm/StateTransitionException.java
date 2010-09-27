package com.oschrenk.fsm;

/**
 * This exception represents a transitioning error, when the underlying
 * {@link TransitioningModel} of a {@link StateMachine} doesn't allow a specific
 * transition.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class StateTransitionException extends Exception {

	/**
	 * Generated serial version uid
	 */
	private static final long serialVersionUID = -2277464661324665174L;

	/**
	 * Constructs a new {@link StateTransitionException} with the given message
	 * 
	 * @param s
	 */
	public StateTransitionException(String s) {
		super(s);
	}

}
