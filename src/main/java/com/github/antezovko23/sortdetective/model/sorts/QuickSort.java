package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

import org.springframework.stereotype.Component;

/**
 * A sorting algorithm known as Quick Sort. The following code was code
 * basically taken from Cormen, Leiserson, and Rivest, "Introduction to
 * Algorithms". This class Implements ISorter as part of the "strategy pattern".
 * 
 * @author Cormen, Leiserson, and Rivest
 */

@Component
public class QuickSort implements ISorter {
	private Metrics metrics;

	/**
	 * Sorts a list and places the various metrics it records into the Metrics
	 * object.
	 * 
	 * @param list
	 *            the numbers to sort
	 * @param met
	 *            the construct to hold the various metrics
	 */
	@Override
	public void sort(int[] list, Metrics met) {
		metrics = met;
		quicksort(list, 0, list.length - 1);
	}

	protected void quicksort(int[] list, int p, int r) {
		if (p < r) {
			int q = partition(list, p, r);
			quicksort(list, p, q - 1);
			quicksort(list, q + 1, r);
		}
	}

	protected int partition(int[] list, int p, int r) {
		metrics.addMovement(1);
		int i = p - 1;
		for (int j = p; j < r; j++) {
			metrics.addComparison(1);
			if (list[j] < list[r]) {
				i++;
				exchange(list, i, j);
			}
		}
		exchange(list, i + 1, r);
		return i + 1;
	}

	protected void exchange(int[] list, int i, int j) {
		metrics.addMovement(3);
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
	}
}