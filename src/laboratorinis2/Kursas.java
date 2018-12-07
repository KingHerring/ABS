package laboratorinis2;

import java.util.ArrayList;

public class Kursas {

	//private static int kodasCounter = 0;
	private int kodas;
	private String pavadinimas;
	private Destytojas destytojas;
	private ArrayList<Grupe> grupes = new ArrayList<>();
	private ArrayList<Uzduotis> uzduotys = new ArrayList<>();
	
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

	public ArrayList<Grupe> getGrupes() {
		return grupes;
	}

	public Destytojas getDestytojas() {
		return destytojas;
	}
	
	public void setDestytojas(Destytojas destytojas) {
		this.destytojas = destytojas;
	}

	public ArrayList<Uzduotis> getUzduotys() {
		return uzduotys;
	}

	@Override
	public String toString() {
		String s = new String("");
		s += "["+ kodas + "]" + " " + pavadinimas;
		return s;
	}

	
	
}
