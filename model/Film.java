package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author manue
 *
 */
public class Film implements Serializable {
	
	private String titel;
	private String genre;
	private ArrayList<Person> leute;
	private int erscheinungsjahr;
	/**
	 * 
	 * @param titel
	 * @param genre
	 * @param erscheinungsjahr
	 */
	public Film(String titel, String genre, int erscheinungsjahr) {
		this.titel=titel;
		this.genre=genre;
		this.erscheinungsjahr=erscheinungsjahr;
		this.leute = new ArrayList<Person>();
	}
	/**
	 * 
	 * @return titel : String
	 */
	public String getTitel() {
		return this.titel;
	}
	/**
	 * 
	 * @return genre : String
	 */
	public String getGenre() {
		return this.genre;
	}
	/**
	 * 
	 * @return leute : ArrayList<Person>
	 */
	public ArrayList<Person> getLeute() {
		return this.leute;
	}
	/**
	 * 
	 * @param leute : ArrayList<Person>
	 */
	public void addLeute(ArrayList<Person> leute) {
		this.leute = leute;
	}
	/**
	 * 
	 * @return jahr : int
	 */
	public int getErscheinungsjahr () {
		return this.erscheinungsjahr;
	}
	/**
	 * 
	 * @param person : Person
	 */
	public void addPerson (Person person) {
		leute.add(person);
	}
	/**
	 * 
	 * @param pos : int
	 * @return person : Person
	 */
	public Person getPerson (int pos) {
		return leute.get(pos);
	}
}
