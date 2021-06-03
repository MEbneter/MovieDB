package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Person;

public class TestPerson {

	@Test
	public void testGetVName() {
		Person ueli= new Person("ueli","jung", true);
		assertEquals("ueli", ueli.getVName());
	}
	
	@Test
	public void testGetNName() {
		Person ueli= new Person("ueli","jung", true);
		assertEquals("jung", ueli.getNName());
	}
	
	@Test
	public void testGetAufgabe() {
		Person ueli= new Person("ueli","jung", true);
		assertEquals(true , ueli.getAufgabe());
		}

}
