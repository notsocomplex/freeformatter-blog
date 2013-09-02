package com.freeformatter.blog;

/**
 * An enum with a single instance!
 */
public enum EnumSingleton {

	INSTANCE("Tony Stark");

	private String name;
	
	private EnumSingleton(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}