package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

/**
 * A sorting algorithm known as Shell Sort. The following code was basically
 * taken from Sedgewick, "Algorithms". This class Implements ISorter as part of
 * the "strategy pattern".
 * 
 * @author Sedgewick
 */
public class ShellSort implements ISorter {
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
		int h = 1;
		int temp;
		int k;
		do {
			h = 3 * h + 1;
		} while (h <= list.length);
		do {
			h /= 3;
			for (int j = h; j < list.length; j++) {
				metrics.addMovement(1);
				temp = list[j];
				k = j;
				metrics.addComparison(1);
				while (list[k - h] > temp) {
					metrics.addMovement(1);
					list[k] = list[k - h];
					k -= h;
					if (k < h)
						break;
					metrics.addComparison(1);
				}
				metrics.addMovement(1);
				list[k] = temp;
			}
		} while (h != 1);
	}
}