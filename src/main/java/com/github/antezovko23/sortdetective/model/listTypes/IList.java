package com.github.antezovko23.sortdetective.model.listTypes;

import org.springframework.stereotype.Component;

/**
 * Interface for a class that can create various lists to implement.
 * 
 * @author Coty Collins
 * @version Fall 2011
 */
@Component
public interface IList {
	/**
	 * This method should provide code to generate a list of various sizes.
	 * 
	 * @param size
	 *            the size of a list to create
	 * @return the list of numbers created
	 */
	abstract public int[] createList(int size);
}