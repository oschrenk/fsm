package com.oschrenk.fsm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the {@link TransitioningModel}.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class TestTransitioningModel {

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
	 * Tests for valid and invalid transitions.
	 * 
	 * @throws StateTransitionException
	 */
	@Test
	public void testTransitinigModel() throws StateTransitionException {
		assertTrue(model.isValidTransition(ExampleState.PLANNING,
				ExampleState.BUILDING));
		assertTrue(model.isValidTransition(ExampleState.BUILDING,
				ExampleState.WORKING));
		assertTrue(model.isValidTransition(ExampleState.WORKING,
				ExampleState.DEFECTIVE));
		assertTrue(model.isValidTransition(ExampleState.DEFECTIVE,
				ExampleState.DECOMMISONING));
		assertTrue(model.isValidTransition(ExampleState.DEFECTIVE,
				ExampleState.WORKING));

		assertFalse(model.isValidTransition(ExampleState.DECOMMISONING,
				ExampleState.DEFECTIVE));
		assertFalse(model.isValidTransition(ExampleState.WORKING,
				ExampleState.BUILDING));
	}

}
