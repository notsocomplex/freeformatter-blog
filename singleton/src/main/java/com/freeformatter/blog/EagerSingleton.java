package com.freeformatter.blog;

/**
 * Eager creation of the instance 
 */
public class EagerSingleton {

	// Note that the instance needs to be final and static
	private final static EagerSingleton INSTANCE = new EagerSingleton();

	// Constructor needs to be private
	private EagerSingleton() {
	}

	// Returns the single instance
	public static EagerSingleton getInstance() {
		return INSTANCE;
	}
	
}
