package model;

public class Person {
	
	private String vName;
	private String nName;
	private boolean schauspieler;
	
	
	public Person(String vName, String nName, boolean schauspieler) {
		this.vName=vName;
		this.nName=nName;
		this.schauspieler=schauspieler;
	}
	
	public String getAufgabe () {
		String aufgabe;
		if (this.schauspieler) {
			return "Schauspieler";
		} else {
			return "Regisseur";
		}
	}
	
	public String getVName() {
		return this.vName;
	}
	
	public String getNName() {
		return this.nName;
	}
}
