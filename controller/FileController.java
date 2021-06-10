package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Film;

public class FileController {

	/**
	 * schreibt eine ArrayList<Film> in ein File
	 * @param filmListe
	 */
	public static void saveMovieList (ArrayList<Film> filmListe) {
		String filename = "movieList.ser";
		// Serialization des Objekts filmList
		try
		{
			//objekte für fileoutput und object output
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// Hier sollts ins file schreiben
			for (Film f : filmListe){
				out.writeObject(f);
			}
			out.close();
			file.close();		
			System.out.println("Object wurde serialisiert");
		}
		
		catch(IOException ex)
		{
			ex.printStackTrace();
			System.out.println("IOException ist aufgetretten");
		}
	}
	/**
	 * liest die ArrayList<Film> aus dem File
	 * @return tMovieList : ArrayList<Film>
	 */
	public static ArrayList<Film> readMovieList () {
		ArrayList<Film> tMovieList = new ArrayList<Film>();
		try {
			String filename = "movieList.ser";
			// objekte für fileinput und objektinput
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			// inhalt der file der FilmList hinzufügen
			Film film = null;	
			while ((film = (Film) in.readObject()) != null) {
				tMovieList.add(film);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException ist aufgetretten");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ClassNotFoundException ist aufgetretten");
			e.printStackTrace();
		}
		return tMovieList;
	}
	
	
}
