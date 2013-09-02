package com.freeformatter.blog;

/**
 * Lazy created singleton using Bill Pugh's solution
 */
public class LazyUsingHolderSingleton {

	private LazyUsingHolderSingleton() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final LazyUsingHolderSingleton INSTANCE = new LazyUsingHolderSingleton();
	}

	// Return the single instance
	public static LazyUsingHolderSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
