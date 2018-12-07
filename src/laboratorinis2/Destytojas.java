package laboratorinis2;

import java.util.ArrayList;

public class Destytojas {
	
	//private static int kodasCounter = 1000;
	private int kodas;
	private String vardas;
	private String pavarde;
	private ArrayList<Kursas> kursai = new ArrayList<>();
	
	Destytojas(){
		
	}
	
	Destytojas(String vardas, String pavarde){
		//this.kodas = kodasCounter;
		this.vardas = vardas;
		this.pavarde = pavarde;
		//kodasCounter++;
	}
	
	public void PridetiKursa(String pavadinimas) {
		Kursas naujasKursas = new Kursas(pavadinimas, this);
		kursai.add(naujasKursas);
	}
	
	public void PridetiUzduoti(String pavadinimas, String salyga, float maxBalai, String pabaigosData, Kursas kursas) {
		Uzduotis uzduotis = new Uzduotis(pavadinimas, salyga, maxBalai, pabaigosData, kursas);
		kursas.getUzduotys().add(uzduotis);
	}
	
	public Kursas GautiKursaPagalID(int kodas) throws Exception{
		for(Kursas k: kursai) {
			if(k.getKodas()==kodas) return k;
		}
		Exception ex = new Exception();
		throw(ex);
	}
		
	
	public int getKodas() {
		return kodas;
	}


	public String getVardas() {
		return vardas;
	}


	public String getPavarde() {
		return pavarde;
	}
	
	
	public void setKodas(int kodas) {
		this.kodas = kodas;
	}


	public void setVardas(String vardas) {
		this.vardas = vardas;
	}


	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}


	public ArrayList<Kursas> getKursai() {
		return kursai;
	}
	

	public void setKursai(ArrayList<Kursas> kursai) {
		this.kursai = kursai;
	}

	@Override
	public String toString() {
		return vardas + " " + pavarde + " " + "["+ kodas + "]";
	}
	
	
}
