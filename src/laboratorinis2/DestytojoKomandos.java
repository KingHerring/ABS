/*package laboratorinis2;

import java.util.Scanner;

public class DestytojoKomandos {

	private AktyvumoBaluSistema abs;
	private Destytojas destytojas;
	
	DestytojoKomandos(AktyvumoBaluSistema abs){
		this.abs = abs;
	}
	
	public void DirbtiSuDestytojoKomandomis() {
		PrisijungtiPriePaskyros();
		if(destytojas==null) return;
		
		Scanner sc = new Scanner(System.in);
		String komanda = new String();
		
		while(!komanda.equals("q")) {
			try {
				System.out.println("("+destytojas+") Pasirinkite komanda:\n"
						+ "viewCourseList - perziureti savo kursu sarasa\n"
						+ "createCourse,{pavadinimas} - sukurti nauja kursa\n"
						+ "deleteCourse,{kurso kodas} - pasalinti kursa\n"
						+ "openCourseCommands,{kurso kodas} - dirbti su konkreciu kursu\n"
						+ "q - atsijungti nuo paskyros");
				komanda = sc.nextLine();
				String[] dalys = komanda.split(",");
				
				switch(dalys[0]) {
					case "viewCourseList":
						System.out.println("Jusu kursai:");
						for(Kursas k: destytojas.getKursai()) 
							System.out.println(k+"\n");
						System.out.println("--------------------------------");
						break;
						
					case "createCourse":
						Kursas k = new Kursas(dalys[1], destytojas);
						destytojas.getKursai().add(k);
						System.out.println("Sukurete kursa: " + k.getPavadinimas());
						System.out.println("--------------------------------");
						break;
						
					case "deleteCourse":
						System.out.println("Pasalinote kursa: " + destytojas.GautiKursaPagalID(Integer.parseInt(dalys[1])).getPavadinimas());
						destytojas.getKursai().remove(destytojas.GautiKursaPagalID(Integer.parseInt(dalys[1])));
						System.out.println("--------------------------------");
						break;
					
					case "openCourseCommands":
						DirbtiSuKursu(destytojas.GautiKursaPagalID(Integer.parseInt(dalys[1])));
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
	
	public void DirbtiSuKursu(Kursas k) {
		
		Kursas darbinisKursas = k;		
		Scanner sc = new Scanner(System.in);
		String komanda = new String();
		
		while(!komanda.equals("q")) {
			try {
				System.out.println("Dirbate su kursu: " + darbinisKursas + "\nPasirinkite komanda:\n"
						+ "viewAllGroups - perziureti grupiu sarasa\n"
						+ "viewAddedGroups - perziureti grupes, pridetas i kursa\n"
						+ "addGroup,{grupes kodas}- prideti grupe i kursa\n"
						+ "removeGroup,{grupes kodas} - pasalinti grupe is kurso\n"
						+ "viewTasks - perziureti kurso uzduotis\n"
						+ "addTask,{pavadinimas},{salyga},{max balai},{pabaigos data} - prideti uzduoti\n"
						+ "openTaskCommands,{uzduoties kodas} - dirbti su nurodyta uzduotimi\n"
						+ "q - grizti atgal");
				komanda = sc.nextLine();
				String[] dalys = komanda.split(",");
				
				switch(dalys[0]) {
					case "viewAllGroups":
						System.out.println("Visu grupiu sarasas:");
						abs.RodytiVisasGrupes();
						System.out.println("--------------------------------");
						break;
						
					case "viewAddedGroups":
						System.out.println("I kursa pridetos grupes:");
						for(Grupe g: k.getGrupes()) System.out.println(g.getKodas());
						System.out.println("--------------------------------");
						break;
						
					case "addGroup":
						Grupe g = abs.GautiGrupePagalID(dalys[1]);
						k.getGrupes().add(g);
						g.getKursai().add(k);
						System.out.println("I "+ k.getPavadinimas() + " pridejote " + g.getKodas());
						System.out.println("--------------------------------");
						break;
					
					case "removeGroup":
						k.getGrupes().remove(abs.GautiGrupePagalID(dalys[1]));
						System.out.println("Is "+ k.getPavadinimas() + " isemete " + abs.GautiGrupePagalID(dalys[1]).getKodas());
						System.out.println("--------------------------------");
						break;
						
					case "viewTasks":
						System.out.println("Kurse patalpintos uzduotys:");
						for(Uzduotis u: k.getUzduotys()) System.out.println(u);
						System.out.println("--------------------------------");
						break;
						
					case "addTask":
						destytojas.PridetiUzduoti(dalys[1], dalys[2], Float.parseFloat(dalys[3]), dalys[4], k);
						System.out.println("--------------------------------");
						break;
						
					case "openTaskCommands":
						System.out.println("Si komanda siuo metu negalima");
						System.out.println("--------------------------------");
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

	private void PrisijungtiPriePaskyros() {
		System.out.println("Paskyru sarasas:");
		abs.RodytiVisusDestytojus();
		System.out.println("Norint prisijungti iveskite savo destytojo koda");
		
		try {
			Scanner sc = new Scanner(System.in);
			String kodas = sc.nextLine();
			if(abs.GautiDestytojaPagalID(Integer.parseInt(kodas))!=null) {
				destytojas = abs.GautiDestytojaPagalID(Integer.parseInt(kodas));
			}
			else System.out.println("Tokios paskyros nera");
		}
		catch(Exception e) {
			System.out.println("Patikrinkite ar gerai ivedete savo koda");
		}
	}
	
}*/
