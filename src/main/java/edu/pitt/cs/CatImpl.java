package edu.pitt.cs;

public class CatImpl implements Cat {

	private boolean rented = false;
	private int id = -1;
	private String name;

	public CatImpl(int id, String name) {
		this.rented = false;
		this.id = id;
		this.name = name;
	}

	public void rentCat() {
		this.rented = true;
	}

	public void returnCat() {
		this.rented = false;
	}

	public void renameCat(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public boolean getRented() {
		return this.rented;
	}

	public String toString() {
		return "ID " + this.id + ". " + this.name;
	}

}