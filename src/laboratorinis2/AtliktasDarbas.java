package laboratorinis2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AtliktasDarbas {
	private int kodas;
	private Uzduotis uzduotis;
	private String sprendimas;
	private String pateikimoLaikas;	
	private Studentas studentas;
	private float ivertinimas;
	
	AtliktasDarbas(int kodas, Uzduotis uzduotis, String sprendimas, Studentas studentas){
		this.kodas = kodas;
		this.uzduotis = uzduotis;
		this.sprendimas = sprendimas;
		pateikimoLaikas = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
		this.studentas = studentas;
		
	}

	
	
	public int getKodas() {
		return kodas;
	}

	public float getIvertinimas() {
		return ivertinimas;
	}

	public void setIvertinimas(float ivertinimas) {
		this.ivertinimas = ivertinimas;
	}

	public Uzduotis getUzduotis() {
		return uzduotis;
	}

	public String getSprendimas() {
		return sprendimas;
	}

	public String getPateikimoLaikas() {
		return pateikimoLaikas;
	}

	public Studentas getStudentas() {
		return studentas;
	}
	
}
