package com.oschrenk.fsm;

/**
 * This class hold a transition of one state to another.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 * @param <E>
 */
public class Transition<E extends Enum<?>> {
	private int from;
	private int to;

	/**
	 * Constructs a new {@link Transition} from one state to another
	 * 
	 * @param from
	 *            Starting state
	 * @param to
	 *            End state
	 */
	public Transition(E from, E to) {
		this.from = from.ordinal();
		this.to = to.ordinal();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + to;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Transition other = (Transition) obj;
		if (from != other.from)
			return false;
		if (to != other.to)
			return false;
		return true;
	}

}