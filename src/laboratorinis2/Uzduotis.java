package laboratorinis2;

import java.util.ArrayList;

public class Uzduotis {
	
	private int kodas;
	private String pavadinimas;
	private String salyga;
	private float maxBalai;
	private String pabaigosData;
	private Kursas kursas;
	//private boolean galimaIkeltiDarbus;
	private ArrayList<AtliktasDarbas> atliktiDarbai = new ArrayList<>();
	
	public Uzduotis() {
		
	}
	
	public Uzduotis(String pavadinimas, String salyga, float maxBalai, String pabaigosData, Kursas kursas){
		this.pavadinimas = pavadinimas;
		this.salyga = salyga;
		this.maxBalai = maxBalai;
		this.pabaigosData = pabaigosData;
		this.kursas = kursas;
	}
		
	
	
	public int getKodas() {
		return kodas;
	}
	
	public void setKodas(int kodas) {
		this.kodas = kodas;
	}


	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getSalyga() {
		return salyga;
	}
	public void setSalyga(String salyga) {
		this.salyga = salyga;
	}
	public float getMaxBalai() {
		return maxBalai;
	}
	public void setMaxBalai(float maxBalai) {
		this.maxBalai = maxBalai;
	}
	public String getPabaigosData() {
		return pabaigosData;
	}
	public void setPabaigosData(String pabaigosData) {
		this.pabaigosData = pabaigosData;
	}
	public Kursas getKursas() {
		return kursas;
	}
	public void setKursas(Kursas kursas) {
		this.kursas = kursas;
	}	
	public ArrayList<AtliktasDarbas> getAtliktiDarbai() {
		return atliktiDarbai;
	}
	
	@Override
	public String toString() {
		return pavadinimas + " [Pasibaigia: " + pabaigosData + "]";
	}
		
	
}
