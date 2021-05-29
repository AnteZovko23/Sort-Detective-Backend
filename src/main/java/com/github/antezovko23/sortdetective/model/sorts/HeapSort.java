package com.github.antezovko23.sortdetective.model.sorts;

import com.github.antezovko23.sortdetective.service.Metrics;

import org.springframework.stereotype.Component;

/**
 * A sorting algorithm known as Heap Sort. The following code was basically
 * taken from Sedgewick, "Algorithms". This class Implements ISorter as part of
 * the "strategy pattern".
 * 
 * @author Sedgewick
 */

@Component
public class HeapSort implements ISorter {
	Metrics metrics;

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
		int n = list.length;
		for (int k = n / 2; k >= 0; k--) {
			downheap(list, k, n);
		}
		for (int j = n - 1; j > 0; j--) {
			metrics.addMovement(3);
			int temp = list[0];
			list[0] = list[j];
			list[j] = temp;
			downheap(list, 0, j);
		}
	}

	/**
	 * 
	 * @param list
	 *            the numbers to sort
	 * @param k
	 * @param maxPos
	 *            the maximum position
	 */
	private void downheap(int list[], int k, int maxPos) {
		metrics.addMovement(1);
		int temp = list[k];
		while (k < maxPos / 2) {
			int maxChildIndex = 2 * k + 1;
			if (maxChildIndex < maxPos - 1) {
				metrics.addComparison(1);
				if (list[maxChildIndex] < list[maxChildIndex + 1]) {
					maxChildIndex++;
				}
			}
			metrics.addComparison(1);
			if (temp >= list[maxChildIndex])
				break;
			metrics.addMovement(1);
			list[k] = list[maxChildIndex];
			k = maxChildIndex;
		}
		metrics.addMovement(1);
		list[k] = temp;
	}
}