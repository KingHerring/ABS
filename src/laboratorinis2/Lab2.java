package laboratorinis2;

import java.util.Scanner;
import java.sql.*;
public class Lab2 {
	
	/*public static void main(String[] args) {
		AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
		Init(abs); // i sistema irasoma truputi duomenu
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Pasirinkite vartotojo tipa:\n"
					+ "1 - Administratorius\n"
					+ "2 - Destytojas\n"
					+ "3 - Studentas\n"
					+ "q - Baigti darba su sistema");
			
			String komanda = sc.nextLine();
			switch(komanda) {
				case "1":
					AdministratoriausKomandos ak = new AdministratoriausKomandos(abs);
					ak.DirbtiSuAdminKomandomis();
					break;
				
				case "2":
					DestytojoKomandos dk = new DestytojoKomandos(abs);
					dk.DirbtiSuDestytojoKomandomis();
					break;
					
				case "3":
					StudentoKomandos sk = new StudentoKomandos(abs);
					sk.DirbtiSuStudentoKomandomis();
					break;
				
				case "q":
					System.out.println("Darbas su sistema baigtas");
					sc.close();
					System.exit(0);
					break;
				
				default:
					System.out.println("Tokios komandos nera");
					break;
			}
			
		}
		
	}*/
	
	
	public static void Init(AktyvumoBaluSistema abs) {
		
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DB_URL = "jdbc:mysql://localhost/aktyvumobalusistema";
			String User = "root";
			String Password = "hitormiss";
			Connection conn = DriverManager.getConnection(DB_URL, User, Password);
			
			Statement statement = conn.createStatement();
			String query = "SELECT vardas, pavarde, grupe FROM studentai";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				
				String vardas = rs.getString(2);
				System.out.println(vardas);
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
		
	/*	try {
		abs.PridetiDestytoja("Jonas", "Petraitis");
		abs.PridetiDestytoja("Ivan", "Ivanovich");
		abs.PridetiDestytoja("Petras", "Jonaitis");
		
		//
		abs.GautiDestytojaPagalID(1000).PridetiKursa("Logika");
		abs.GautiDestytojaPagalID(1001).PridetiKursa("Istorija 101");
		abs.GautiDestytojaPagalID(1001).PridetiKursa("Matematika 101");
		abs.GautiDestytojaPagalID(1001).PridetiKursa("Šieno ravėjimas pradedantiesiems");
		abs.GautiDestytojaPagalID(1002).PridetiKursa("Ekonomika 101");
		
		//------------------------------------------
		Destytojas d = abs.GautiDestytojaPagalID(1001);
		Kursas k = d.GautiKursaPagalID(2);
		
		d.PridetiUzduoti("ND1", "2+2=x,  rasti x",2.0f , "2018.11.01", k);
		d.PridetiUzduoti("ND2", "2+3=x,  rasti x",2.0f , "2018.11.08", k);
		
		//------------------------------------------
		abs.PridetiGrupe("PRIf-16/1");
		abs.PridetiGrupe("PRIf-16/2");
		abs.PridetiGrupe("PRIf-16/3");
		
		Grupe g1 = abs.GautiGrupePagalID("PRIf-16/1");
		Grupe g2 = abs.GautiGrupePagalID("PRIf-16/2");
		Studentas s1 = new Studentas("Lukas", "Lukinskas");
		Studentas s2 = new Studentas("Petras", "Petrinskas");
		Studentas s3 = new Studentas("Ching", "Chong");
		Studentas s4 = new Studentas("Ping", "Pong");
		g1.PridetiStudenta(s1);
		g1.PridetiStudenta(s2);
		g2.PridetiStudenta(s3);
		g2.PridetiStudenta(s4);
		
		//---------------------------------------------
		k.PridetiGrupe(g1);
		k.PridetiGrupe(g2);
		k = d.GautiKursaPagalID(3);
		//k.PridetiGrupe(g1);
		k.PridetiGrupe(g2);
		
		
		}catch(Exception ex) {
			System.out.println(ex.getStackTrace()[1].getLineNumber());
			System.out.println(ex);
		}*/
		
	}
	
}
