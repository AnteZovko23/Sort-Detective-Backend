package com.github.antezovko23.sortdetective.model.listTypes.listImplementations;

import com.github.antezovko23.sortdetective.model.listTypes.IList;

/**
 * This class implements the IList interface and possess code for creating a
 * Random Ordered List.
 * 
 * @author Coty Collins
 * @version Fall, 2011
 */
public class RandomOrder implements IList {
	/**
	 * Creates and returns a list that is in random order.
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
		for (int j = n - 1; j > 0; j--) {
			int randomIndex = (int) (Math.random() * j);
			int temp = list[j];
			list[j] = list[randomIndex];
			list[randomIndex] = temp;
		}
		return list;
	}
}