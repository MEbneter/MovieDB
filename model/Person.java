package model;

import java.io.Serializable;

/**
 * 
 * @author manue
 * Speichert Personen mit Name und Aufgabe
 */
public class Person implements Serializable {
	
	private String vName;
	private String nName;
	private boolean schauspieler;
	
	
	public Person(String vName, String nName, boolean schauspieler) {
		this.vName=vName;
		this.nName=nName;
		this.schauspieler=schauspieler;
	}
	/**
	 * 
	 * @return Aufgabe als String
	 */
	public String getAufgabe () {
		String aufgabe;
		if (this.schauspieler) {
			return "Schauspieler";
		} else {
			return "Regisseur";
		}
	}
	/**
	 * 
	 * @return vor und nachname als String
	 */
	public String getVName() {
		return this.vName;
	}
	
	public String getNName() {
		return this.nName;
	}
}
