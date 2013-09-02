package com.freeformatter.blog;

/**
 * Singleton that created lazily on first invocation of getInstance method
 */
public class LazySingleton {

	private static LazySingleton instance;

	private LazySingleton() {
	}

	// Don't forget the synchronized keyword to avoid potential creation
	// issues with multi-threads
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

}