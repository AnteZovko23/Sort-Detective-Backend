package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

import org.springframework.stereotype.Component;

/**
 * A sorting algorithm known as Merge Sort. This class Implements ISorter as
 * part of the "strategy pattern".
 * 
 * @author Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and
 *         Clifford Stein
 * 
 *         Any errors are due to Coty Collins, David Levine and Steven
 *         Andrianoff
 */

@Component
public class MergeSort implements ISorter {
	private Metrics metrics;
	private final int MIN_VALUE = Integer.MIN_VALUE;

	/**
	 * Sorts a list and places the various metrics it records into the Metrics
	 * object.
	 * 
	 * @param list
	 *            the numbers to sort
	 * @param met
	 *            the construct to hold the various metrics
	 */
	public void sort(int[] list, Metrics met) {
		metrics = met;
		mergeSort(list, 0, list.length - 1);
	}

	/**
	 * Recursively called to sort a list of numbers.
	 * 
	 * @param array
	 *            the numbers to sort
	 * @param p
	 *            the first index
	 * @param r
	 *            the last index
	 */
	protected void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}

	/**
	 * Merges two sorted arrays.
	 * 
	 * @param array
	 *            the list of numbers
	 * @param p
	 *            the beginning index
	 * @param q
	 *            the middle index
	 * 
	 * @param r
	 *            the highest index
	 */
	protected void merge(int[] array, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			left[i] = array[p + i];
		}

		for (int j = 0; j < n2; j++) {
			right[j] = array[q + j + 1];
		}
		metrics.addMovement(n1 + n2);

		left[n1] = right[n2] = MIN_VALUE;

		for (int i = 0, j = 0, k = p; k <= r; k++) {
			metrics.addComparison(1);
			metrics.addMovement(1);
			if (compare(left[i], right[j]) <= 0)
				array[k] = left[i++];
			else
				array[k] = right[j++];
		}
	}

	/**
	 * Compares two numbers.
	 * 
	 * @param x
	 *            the first number
	 * @param y
	 *            the second number
	 * @return compares two values and returns an integer similar to a
	 *         comparable's compareTo() method
	 */
	protected int compare(int x, int y) {
		if (x == MIN_VALUE) {
			return y == MIN_VALUE ? 0 : 1;
			// first return is if both x and y are negative-infinity
			// second return is if x is negative-infinity, y is not
		} else if (y == MIN_VALUE)
			return -1; // y is negative-infinity, x is not
		else
			return x < y ? -1 : x == y ? 0 : 1; // neither x nor y is
												// negative-infinity
	}
}