package com.github.antezovko23.sortdetective.model.listTypes.listImplementations;

import com.github.antezovko23.sortdetective.model.listTypes.IList;

/**
 * This class implements the IList interface and possesses code for creating an
 * Almost In Ordered List.
 * 
 * @author Coty Collins
 * @version Fall, 2011
 */
public class AlmostInOrder implements IList {
	private static final double DISORDER = 0.05;

	/**
	 * Creates and returns a list that is almost in order.
	 * 
	 * @param n
	 *            the size of a list to create
	 * @return the list of numbers created
	 */
	@Override
	public int[] createList(int n) {
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = i;
		}
		int swaps = decideSwaps(n);
		for (int j = 0; j < swaps; j++) {
			int randomIndex1 = (int) (Math.random() * list.length);
			int randomIndex2 = (int) (Math.random() * list.length);
			int temp = list[randomIndex1];
			list[randomIndex1] = list[randomIndex2];
			list[randomIndex2] = temp;
		}
		return list;
	}

	/**
	 * Decides the number of swaps to make for the almost in order list.
	 * 
	 * @param n
	 *            the size of list that needs to be disordered
	 * @return the number of swaps to make a list almost in order
	 */
	private int decideSwaps(int n) {
		int log = (int) (Math.log(n) / Math.log(2));
		int disorder = (int) (n * DISORDER);
		return disorder == 0 ? 1 : log > disorder ? disorder : log;
	}
}