package com.github.antezovko23.sortdetective.service;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Metrics {
    
    private final BigInteger negativeOne = new BigInteger("-1");
	private final BigInteger zero = new BigInteger("0");
	private BigInteger comparisons = new BigInteger("0");
	private BigInteger movements = new BigInteger("0");
	private BigInteger time = new BigInteger("0");

	/**
	 * Clears the various metrics.
	 */
	public void clearStats() {
		comparisons = zero;
		movements = zero;
		time = zero;
	}

	/**
	 * Sets the metric values to "-1".
	 */
	public void error() {
		comparisons = negativeOne;
		movements = negativeOne;
	}

	/**
	 * Returns the comparisons metric.
	 * 
	 * @return the comparisons
	 */
	public BigInteger getComparisons() {
		return comparisons;
	}

	/**
	 * Adds to the comparison metric.
	 * 
	 * @param n
	 *            the number of comparisons to add
	 */
	public void addComparison(int n) {
		comparisons = comparisons.add(new BigInteger("" + n));
	}

	/**
	 * Returns the movements metric.
	 * 
	 * @return the movements
	 */
	public BigInteger getMovements() {
		return movements;
	}

	/**
	 * Adds to the movement metric.
	 * 
	 * @param n
	 *            the number of movements to add
	 */
	public void addMovement(int n) {
		movements = movements.add(new BigInteger("" + n));
	}

	/**
	 * Returns the time metric.
	 * 
	 * @return the time metric
	 */
	public BigInteger getTime() {
		return time;
	}

	/**
	 * Establishes the time difference from the given value to the current time
	 * (Basically the time it took for the sort to complete) and stores the
	 * value into the time metric.
	 * 
	 * @param start
	 *            the start time
	 */
	public void establishTime(Date start) {
		Date end = new Date();
		time = new BigInteger(end.getTime() + "").subtract(new BigInteger(start
				.getTime() + ""));
	}
}
