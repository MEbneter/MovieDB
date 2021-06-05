package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;



public class FilmList extends AbstractListModel<Film> {
	
	List<Film> filme = new ArrayList<>();


	public FilmList() {

	}
	
	public void addFilm(Film film) {
		filme.add(film);
	}
	
	public List<Film> getFilme() {
		return this.filme;
	}

	@Override
	public Film getElementAt(int stelle) {
		// TODO Auto-generated method stub
		return this.filme.get(stelle);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.filme.size();
	}

}
