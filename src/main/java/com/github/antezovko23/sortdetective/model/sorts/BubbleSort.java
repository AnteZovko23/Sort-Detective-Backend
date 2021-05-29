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
public class BubbleSort implements ISorter {
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
		for (int i = 0; i < list.length; i++) {
			int j = list.length - 1;
			do {
				metrics.addComparison(1);
				if (list[j] < list[j - 1]) {
					metrics.addMovement(3);
					int temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
				}
				j--;
			} while (j > i);
		}
	}
}