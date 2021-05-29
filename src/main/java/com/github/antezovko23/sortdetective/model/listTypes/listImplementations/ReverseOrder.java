package com.github.antezovko23.sortdetective.model.listTypes.listImplementations;

import com.github.antezovko23.sortdetective.model.listTypes.IList;

/**
 * This class implements the IList interface and possess code for creating an
 * Reverse Ordered List.
 * 
 * @author Coty Collins
 * @version Fall, 2011
 */
public class ReverseOrder implements IList {

	/**
	 * Creates and returns a list that is in reverse order.
	 * 
	 * @param n
	 *            the size of a list to create
	 * @return the list of numbers created
	 */
	@Override
	public int[] createList(int n) {
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = n - 1 - i;
		}
		return list;
	}
}