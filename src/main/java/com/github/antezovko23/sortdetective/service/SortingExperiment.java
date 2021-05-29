package com.github.antezovko23.sortdetective.service;

import java.math.BigInteger;
import java.util.Date;

import com.github.antezovko23.sortdetective.model.sorts.ISorter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


/**
 * SortingExperiment
 * 
 * Copyright 2011 Department of Computer Science Saint Bonaventure University
 * Saint Bonaventure, NY 14778
 * 
 * This software may be used for educational purposes as long as this copyright
 * notice is retained intact at the top of all files.
 * 
 * Should this software be modified, the words "Modified from Original" must be
 * included as a comment below this notice.
 * 
 * All publication rights are retained. This software or its documentation may
 * not be published in any media either in whole or in part without explicit
 * permission.
 * 
 * Contact information: David Levine dlevine@sbu.edu
 * 
 * Telephone: 716-375-2598
 * 
 * @author Coty Collins & David Levine & Ante Zovko
 * @version Fall, 2011
 */
 
@Service
public class SortingExperiment {
	private ISorter algorithm;
	private Metrics metrics;

	/**
	 * Create a SortingExperiment.
	 */
    @Autowired
	public SortingExperiment(Metrics metrics) {
		this.metrics = metrics;
	}

	/**
	 * The method that must sort a list.
	 * 
	 * @param list
	 *            the list to sort
	 */
	protected void sort(int list[]) {
		algorithm.sort(list, metrics);
	}

	/**
	 * Performs the sort created and records the time from start to finish. If
	 * the sort cannot complete, an error will be thrown and this method will
	 * return false; otherwise true will be returned.
	 * 
	 * @param list
	 *            the list to sort
	 * @return true if the sort completed as should; false otherwise
	 */
    // TODO: Change to protected
    // TODO: Revert to boolean
	public boolean getExperimentData(int list[]) {
		metrics.clearStats();
		Date start = new Date();
		try {
			sort(list);
		} catch (Throwable t) {
			metrics.error();
			t.printStackTrace();
			return false;
		}
        metrics.establishTime(start);
        
        // String[] results = new String[] { "" + getComparisons(),
        // "" + getMovements(), "" + getTime() };
        return true;

		// return true;
	}

	/**
	 * Sets the algorithm that will be sorting.
	 * 
	 * @param alg
	 *            the sorting algorithm to use
	 */
	public void setAlgorithm(ISorter alg) {
		if (alg == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
		}
		algorithm = alg;
	}

	/**
	 * Returns the comparisons the particular sort made.
	 * 
	 * @return the number of comparisons
	 */
	public BigInteger getComparisons() {
		return metrics.getComparisons();
	}

	/**
	 * Returns the movements the particular sort made.
	 * 
	 * @return the number of movements
	 */
	public BigInteger getMovements() {
		return metrics.getMovements();
	}

	/**
	 * Returns the time it took to sort.
	 * 
	 * @return the sorting time
	 */
	public BigInteger getTime() {
		return metrics.getTime();
	}
}