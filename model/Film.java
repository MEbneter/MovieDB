package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Film implements Serializable {
	
	private String titel;
	private String genre; // evtl. auch enum
	private ArrayList<Person> leute;
	int erscheinungsjahr;
	
	public Film(String titel, String genre, int erscheinungsjahr) {
		this.titel=titel;
		this.genre=genre;
		this.erscheinungsjahr=erscheinungsjahr;
		this.leute = new ArrayList<Person>();
	}
	
	public String getTitel() {
		return this.titel;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public ArrayList<Person> getLeute() {
		return this.leute;
	}
	
	public void addLeute(ArrayList<Person> leute) {
		this.leute = leute;
	}
	
	public int getErscheinungsjahr () {
		return this.erscheinungsjahr;
	}
	
	public void addPerson (Person person) {
		leute.add(person);
	}
	public Person getPerson (int pos) {
		return leute.get(pos);
	}
	public int getSizeLeute() {
		// TODO Auto-generated method stub
		return this.leute.size();
	}
}
