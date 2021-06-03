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
	
	public boolean getAufgabe () {
		return this.schauspieler;
	}
	
	public String getVName() {
		return this.vName;
	}
	
	public String getNName() {
		return this.nName;
	}
}
