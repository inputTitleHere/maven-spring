package com.kh.app.strategy.pattern;

public abstract class Pet {
	protected String name;

	public Pet(String name) {
		super();
		this.name = name;
	}

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String className = this.getClass().getName();
		return className.substring(className.lastIndexOf(".")+1) +" [name=" + name + "]";
	}
	
	

}
