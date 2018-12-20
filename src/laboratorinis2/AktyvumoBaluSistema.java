package laboratorinis2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AktyvumoBaluSistema {

	SessionFactory sf = null;
	private ArrayList<Destytojas> destytojai = new ArrayList<>();
	private ArrayList<Grupe> grupes = new ArrayList<>();
	
	
	public AktyvumoBaluSistema(){
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public void PridetiDestytoja(String vardas, String pavarde) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		try{
			Destytojas naujasDestytojas = new Destytojas(vardas, pavarde);
			s.save(naujasDestytojas);	
			t.commit();
			
		}catch(Exception ex) {		
			t.rollback();
			ex.printStackTrace();
		}
		
		s.close();
	}
	
	public void PridetiGrupe(String kodas) {
		Grupe naujaGrupe = new Grupe(kodas);
		grupes.add(naujaGrupe);
	}
	
	public void AtnaujintiKursa(Kursas k) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		try {
			s.update(k);
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}
		s.close();
	}
	
	public void AtnaujintiAtliktaDarba(AtliktasDarbas a) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		try {
			s.update(a);
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}
		s.close();
	}
	
	public void PridetiStudenta(Studentas studentas) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		try {
			s.save(studentas);
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}
		s.close();
	}
	
	public void DestytojuiPridetiKursa(Destytojas d, String pav) {
		Kursas naujasKursas = new Kursas(pav, d);
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		try {
			s.save(naujasKursas);
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}
		s.close();
	}
	
	public void PasalintiKursa(Kursas k) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		try {
			s.remove(k);
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}
		s.close();
	}
	
	public void PasalintiUzduoti(Uzduotis u) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		try {
			s.remove(u);
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}
		s.close();
	}
		
	public Destytojas GautiDestytojaPagalID(int id) throws Exception{
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Destytojas d = null;
		try {	
			d = (Destytojas) s.get(Destytojas.class, id);
			t.commit();
			s.close();
			return d;			
		}catch(Exception ex) {			
			System.out.println(ex);
			t.rollback();	
			s.close();
		}

		
		Exception ex = new Exception();
		throw(ex);
	}
	
	public Grupe GautiGrupePagalID(String id) throws Exception{
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Grupe g = null;
		try {
			g = s.get(Grupe.class,id);
			t.commit();
			s.close();
			return g;
		}catch(Exception ex){
			ex.printStackTrace();
			t.rollback();
			s.close();
		}

		Exception ex = new Exception();
		throw(ex);
	}
	
	public Studentas GautiStudentaPagalID(int id) throws Exception{
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Studentas studentas = null;
		try {
			studentas = s.get(Studentas.class, id);
			t.commit();
			s.close();
			return studentas;
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
			s.close();
		}
			
		Exception ex = new Exception();
		throw(ex);
	}
	
	public AtliktasDarbas GautiAtliktaDarbaPagalID(int id) throws Exception {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		AtliktasDarbas atliktasDarbas = null;
		try {
			atliktasDarbas = s.get(AtliktasDarbas.class, id);
			t.commit();
			s.close();
			return atliktasDarbas;
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
			s.close();
		}
			
		Exception ex = new Exception();
		throw(ex);
	}
		
	public void SalintiDestytoja(int kodas) {
		try {
			destytojai.remove(GautiDestytojaPagalID(kodas));
		}catch(Exception ex){
			System.out.println("Tokio destytojo nera");
		}
	}

	public ArrayList<Destytojas> getDestytojai() {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		try {
			ArrayList<Destytojas> d = (ArrayList<Destytojas>) s.createQuery("FROM Destytojas").list();
			t.commit();
			s.close();
			return d;
		}catch(Exception ex) {
			System.out.println(ex);
			t.rollback();
			s.close();
		}
		return null;
	}
	
	
	public ArrayList<Studentas> getStudentai() {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		try {
			ArrayList<Studentas> st = (ArrayList<Studentas>) s.createQuery("FROM Studentas").list();
			t.commit();
			s.close();
			return st;
		}catch(Exception ex) {
			System.out.println(ex);
			t.rollback();
			s.close();
		}
		return null;
	}

	public ArrayList<Grupe> getGrupes() {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		ArrayList<Grupe> gr = null;	
		try {
			gr = (ArrayList<Grupe>) s.createQuery("FROM Grupe").list();
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}		
		s.close();				
		return gr;
	}	
	
	public List<Grupe> getNeitrauktosGrupes(Kursas k){
		
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		List<Grupe> gr = null;	
		try {
			gr = s.createQuery("FROM Grupe").list();
			
			for(Grupe grupe: k.getGrupes()) {
				for(Grupe grupe2: gr) {
					if(grupe.getKodas().equals(grupe2.getKodas())) {
						gr.remove(grupe2);
						break;
					}
				}
			}
			
			t.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			t.rollback();
		}		
		s.close();		
		return gr;
		
	}
	
}
