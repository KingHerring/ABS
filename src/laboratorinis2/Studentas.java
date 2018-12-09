package laboratorinis2;

import java.sql.*;

public class Studentas {
	
	private String vardas;
	private String pavarde;
	private int kodas;
	private Grupe grupe;
	
	public Studentas() {
		
	}
	
	public Studentas(String vardas, String pavarde){
		this.vardas = vardas;
		this.pavarde = pavarde;
	}
	
	
	
	public void PateiktiDarba(int kodas, Uzduotis uzduotis, String sprendimas) {
		AtliktasDarbas darbas = new AtliktasDarbas(kodas, uzduotis, sprendimas, this);
		uzduotis.getAtliktiDarbai().add(darbas);
	}		
	
	public String getVardas() {
		return vardas;
	}


	public void setVardas(String vardas) {
		this.vardas = vardas;
	}


	public String getPavarde() {
		return pavarde;
	}


	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}


	public int getKodas() {
		return kodas;
	}
	
	public void setKodas(int kodas) {
		this.kodas = kodas;
	}

	public Grupe getGrupe() {
		return grupe;
	}

	public void setGrupe(Grupe grupe) {
		this.grupe = grupe;
	}

	@Override
	public String toString() {
		return vardas + " " + pavarde + " [" + kodas + "]";
	}

	
}
