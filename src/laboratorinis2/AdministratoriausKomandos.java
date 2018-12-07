/*package laboratorinis2;

import java.util.Scanner;

public class AdministratoriausKomandos {

	private AktyvumoBaluSistema abs;
	
	AdministratoriausKomandos(AktyvumoBaluSistema abs){
		this.abs = abs;
	}
	
	public void DirbtiSuAdminKomandomis() {
		
		Scanner sc = new Scanner(System.in);
		String komanda = new String();
		
		while(!komanda.equals("q")) {
		
			System.out.println("(Administratorius) Pasirinkite komanda:\n"
					+ "d - dirbti su destytojais\n"
					+ "s - dirbti su studentais\n"
					+ "q - atsijungti nuo administratoriaus paskyros");
			komanda = sc.nextLine();
			
			switch(komanda) {
				case "d":
					DirbtiSuDestytojais();
					break;
					
				case "s":
					DirbtiSuStudentais();
					break;
					
				case "q":
					
					break;
					
				default:
					System.out.println("Tokios komandos nera");
					
			}
		}
	}

	private void DirbtiSuStudentais() {
		Scanner sc = new Scanner(System.in);
		String komanda = new String();
		
		while(!komanda.equals("q")) {
			try {
				System.out.println("Pasirinkite komanda:\n"
						+ "viewGroupList - perziureti grupiu sarasa\n"
						+ "viewGroup,{grupes kodas} - perziureti sarasa studentu, esanciu grupeje\n"
						+ "addGroup,{grupes kodas} - sukurti nauja grupe\n"
						+ "addStudent,{vardas},{pavarde},{grupes kodas} - prideti studenta i grupe\n"
						+ "q - grizti i ankstesni meniu");
				komanda = sc.nextLine();
				String[] dalys = komanda.split(","); 
				
				switch(dalys[0]) {
					case "viewGroupList":
						System.out.println("Grupiu sarasas:");
						abs.RodytiVisasGrupes();
						break;
					
					case "viewGroup":
						abs.GautiGrupePagalID(dalys[1]).RodytiGrupesStudentus();
						break;
					
					case "addGroup":
						Grupe g = new Grupe(dalys[1]);
						abs.getGrupes().add(g);
						break;
						
					case "addStudent":
						Studentas s = new Studentas(dalys[1], dalys[2]);
						abs.GautiGrupePagalID(dalys[4]).PridetiStudenta(s);
						break;
						
					case "q":
						
						break;
						
					default:
						System.out.println("Tokios komandos nera");
							
				}
			}catch(Exception e) {
				System.out.println("Patikrinkite komandos argumentus");
			}	
		}

	}

	private void DirbtiSuDestytojais() {
	
		Scanner sc = new Scanner(System.in);
		String komanda = new String();
		
		while(!komanda.equals("q")) {
			try {
				System.out.println("Pasirinkite komanda:\n"
						+ "viewLectList - perziureti destytoju sarasa\n"
						+ "addLect,{vardas},{pavarde} - prideti nauja destytoja\n"
						+ "removeLect,{destytojo kodas} - pasalinti destytoja\n"
						+ "q - grizti i ankstesni meniu");
				komanda = sc.nextLine();
				String[] Dalys = komanda.split(","); 
				
				switch(Dalys[0]) {
					case "viewLectList":
						abs.RodytiVisusDestytojus();
						break;
					
					case "addLect":
						Destytojas d = new Destytojas(Dalys[1], Dalys[2]);
						abs.getDestytojai().add(d);
						break;
					
					case "removeLect":
						abs.SalintiDestytoja(Integer.parseInt(Dalys[1]));
						break;
						
					case "q":
						
						break;
						
					default:
						System.out.println("Tokios komandos nera");
							
				}
			}catch(Exception e) {
				System.out.println("Patikrinkite komandos argumentus");
			}
		}
		
	}
}*/
