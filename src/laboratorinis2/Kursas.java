package laboratorinis2;

import java.util.ArrayList;
import java.util.Set;

public class Kursas {

	//private static int kodasCounter = 0;
	private int kodas;
	private String pavadinimas;
	private Destytojas destytojas;
	private Set<Grupe> grupes;
	private Set<Uzduotis> uzduotys;
	
	Kursas(){
		
	}
	
	Kursas(String pavadinimas, Destytojas destytojas){
		//this.kodas = kodasCounter;
		this.pavadinimas = pavadinimas;		
		this.destytojas = destytojas;
		//kodasCounter++;
	}
	
	public void PridetiGrupe(Grupe grupe) {
		grupes.add(grupe);
		grupe.getKursai().add(this);
	}

	
	public void setKodas(int kodas) {
		this.kodas = kodas;
	}

	public int getKodas() {
		return kodas;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public Set<Grupe> getGrupes() {
		return grupes;
	}

	public Destytojas getDestytojas() {
		return destytojas;
	}
	
	public void setDestytojas(Destytojas destytojas) {
		this.destytojas = destytojas;
	}

	public Set<Uzduotis> getUzduotys() {
		return uzduotys;
	}
	
	

	public void setGrupes(Set<Grupe> grupes) {
		this.grupes = grupes;
	}

	public void setUzduotys(Set<Uzduotis> uzduotys) {
		this.uzduotys = uzduotys;
	}

	@Override
	public String toString() {
		String s = new String("");
		s += "["+ kodas + "]" + " " + pavadinimas;
		return s;
	}

	
	
}
