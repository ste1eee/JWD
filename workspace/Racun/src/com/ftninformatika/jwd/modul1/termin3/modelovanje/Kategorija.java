package com.ftninformatika.jwd.modul1.termin3.modelovanje;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Kategorija {
	private long id;
	private String naziv;
	final Set<Proizvod> proizvodi = new HashSet<>();
	
	//konstruktori
	public Kategorija(long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public Kategorija(String naziv) {
		this(0, naziv);
	}
	public Kategorija() {
		this(0, "");
	}
	
	
	//hashcode
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorija other = (Kategorija) obj;
		return id == other.id;
	}
	//getter koji pretvara u kolekciju
	public Collection<Proizvod> getProizvodi() {
		return Collections.unmodifiableCollection(this.proizvodi);
	}
	//metode za povezivanje
	public void dodajProizvod(Proizvod proizvod) {
		this.proizvodi.add(proizvod);
		proizvod.kategorije.add(this);
	}
	
	public void dodajSveProizvode(Collection<Proizvod> proizvodi) {
		this.proizvodi.addAll(proizvodi);
		for(Proizvod p : proizvodi) {
			p.kategorije.add(this);
		}
	}
	
	public void ukloniProizvod(Proizvod proizvod) {
		proizvod.kategorije.remove(this);
		this.proizvodi.remove(proizvod);
	}
	
	public void ukloniSveProizvode() {
		for(Proizvod p : proizvodi) {
			p.kategorije.remove(this);
		}
		this.proizvodi.clear();
	}
	
	//getteri i setteri
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public long getId() {
		return id;
	}
	//tostring
	@Override
	public String toString() {
		return "Kategorija [id=" + id + ", naziv=" + naziv + "]";
	}
	

}
