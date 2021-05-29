package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

/**
 * A sorting algorithm known as Selection Sort. This class Implements ISorter as
 * part of the "strategy pattern".
 * 
 * @author David Levine
 */
public class SelectionSort implements ISorter {
	/**
	 * Sorts a list and places the various metrics it records into the Metrics
	 * object.
	 * 
	 * @param list
	 *            the numbers to sort
	 * @param metrics
	 *            the construct to hold the various metrics
	 */
	@Override
	public void sort(int[] list, Metrics metrics) {
		for (int j = list.length - 1; j > 0; j--) {
			int maxpos = 0;
			for (int k = 1; k <= j; k++) {
				if (list[k] > list[maxpos]) {
					maxpos = k;
				}
			}
			metrics.addComparison(j);
			if (j != maxpos) // Only move if we must
			{
				metrics.addMovement(3);
				int temp = list[j];
				list[j] = list[maxpos];
				list[maxpos] = temp;
			}
		}
	}
}