package com.oschrenk.fsm;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link StateMachine}.
 * 
 * @author Oliver Schrenk
 * 
 */
public class TestStateMachine {

	private TransitioningModel<ExampleState> model;

	/**
	 * Setup example data using {@link ExampleState}.
	 */
	@Before
	public void setUp() {
		model = new TransitioningModel<ExampleState>();
		model.allow(ExampleState.PLANNING, ExampleState.BUILDING);
		model.allow(ExampleState.BUILDING, ExampleState.WORKING);
		model.allow(ExampleState.WORKING, ExampleState.DEFECTIVE);
		model.allow(ExampleState.DEFECTIVE, ExampleState.DECOMMISONING);

		model.allow(ExampleState.DEFECTIVE, ExampleState.WORKING);
	}

	/**
	 * Check if the {@link StateMachine} throws {@link StateTransitionException}
	 * if making a invalid transition
	 * 
	 * @throws StateTransitionException
	 *             Invalid transition
	 */
	@Test(expected = StateTransitionException.class)
	public void testStateMachine() throws StateTransitionException {
		StateMachine<ExampleState> stateMachine = new StateMachine<ExampleState>(
				model, ExampleState.PLANNING);
		stateMachine.transition(ExampleState.DECOMMISONING);
	}

}
