package com.ftninformatika.jwd.modul1.termin6.bioskop.ui;

import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.jwd.modul1.termin6.bioskop.model.Bioskop;
import com.ftninformatika.jwd.modul1.termin6.bioskop.model.Film;

public class StreamAPIPrimer3UI {

	private static void prolazak(List<Film> filmovi) {
		System.out.println();
		for (Film itFilm: filmovi) {
			System.out.println(itFilm);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Bioskop.ucitaj();
		
		List<Film> filmovi = new ArrayList<>(Bioskop.getFilmovi().values());
		prolazak(filmovi);

		int trajanje = 160;

		long rezultat = filmovi.stream().filter(film -> film.getTrajanje() < trajanje).count();

		System.out.println();
		System.out.println(rezultat);
	}

}
