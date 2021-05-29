package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

import org.springframework.stereotype.Component;

/**
 * A sorting algorithm known as Merge Sort.This class Implements ISorter as part
 * of the "strategy pattern".
 * 
 * @author Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and
 *         Clifford Stein
 * 
 *         Any errors are due to Coty Collins, David Levine and Steven
 *         Andrianoff
 */

@Component
public class InsertionSort implements ISorter {
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
		int n = list.length;
		for (int j = 1; j < n; j++) {
			met.addMovement(1);
			int k = list[j];
			int i = j - 1;
			while (i >= 0 && list[i] > k) {
				met.addComparison(1);
				met.addMovement(1);
				list[i + 1] = list[i];
				i--;
			}
			if (i >= 0) {
				met.addComparison(1);
			}
			met.addMovement(1);
			list[i + 1] = k;
		}
	}
}