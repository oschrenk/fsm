package com.oschrenk.fsm;

/**
 * A very simplistic StateMachine modelling only the transitions but not valid
 * start or end points. As it uses an {@link Enum} it is typesafe and guaranteed
 * to deliver valid states (if the transition is valid).
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 * @param <E>
 */
public class StateMachine<E extends Enum<?>> {

	private TransitioningModel<E> model;
	private E currentState;

	/**
	 * Constructs a new start machine with an underlying
	 * {@link TransitioningModel} and a start point.
	 * 
	 * @param model
	 *            The underlying {@link TransitioningModel}
	 * @param start
	 *            The start point
	 */
	public StateMachine(TransitioningModel<E> model, E start) {
		this.currentState = start;
		this.model = model;
	}

	/**
	 * Transitions to the desired state.
	 * 
	 * @param to
	 *            The desired state
	 * @throws StateTransitionException
	 *             If transition isn't allowed by underlying
	 *             {@link TransitioningModel}
	 */
	public void transition(E to) throws StateTransitionException {
		if (!model.isValidTransition(currentState, to)) {
			throw new StateTransitionException(
					String.format(
							"Underlying transitioning model doesn't allow to transition to from %s to %s",
							currentState, to));
		}
	}

	/**
	 * Returns the current state
	 * 
	 * @return the current state
	 */
	public E getCurrentState() {
		return currentState;
	}

}
