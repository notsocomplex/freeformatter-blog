package com.freeformatter.blog;

/**
 * Eager creation of the instance in a static block 
 */
public class EagerStaticBlockSingleton {

	// Note that instance needs to be final and static
	private final static EagerStaticBlockSingleton INSTANCE;

	// Instance is created in a static block in which 
	// you could write extra code
	static {
		INSTANCE = new EagerStaticBlockSingleton();
	}

	// Constructor needs to be private
	private EagerStaticBlockSingleton() {
	}

	// Returns the single instance
	public static EagerStaticBlockSingleton getInstance() {
		return INSTANCE;
	}

}
