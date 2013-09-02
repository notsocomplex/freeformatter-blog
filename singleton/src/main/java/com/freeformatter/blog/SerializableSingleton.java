package com.freeformatter.blog;

import java.io.Serializable;

/**
 * Demonstrates a simple singleton that is serializable
 */
@SuppressWarnings("serial")
public class SerializableSingleton implements Serializable {

	private final static SerializableSingleton INSTANCE = new SerializableSingleton();

	private SerializableSingleton() {
	}

	public static SerializableSingleton getInstance() {
		return INSTANCE;
	}

	// Bypass the java serialization process so that we make
	// sure that we keep the same instance, keeping a singleton
	private Object readResolve() {
	   return INSTANCE;
	}
	
}