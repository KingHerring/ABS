/*package laboratorinis2;

import java.util.Scanner;

public class StudentoKomandos {

	private AktyvumoBaluSistema abs;
	private Studentas studentas;
	
	StudentoKomandos(AktyvumoBaluSistema abs) {
		this.abs = abs;
	}
	
	public void DirbtiSuStudentoKomandomis() {
		PrisijungtiPriePaskyros();
		if(studentas==null) return;
		
		Scanner sc = new Scanner(System.in);
		String komanda = new String();
		
		while(!komanda.equals("q")) {
			try {
				System.out.println("("+studentas+") Pasirinkite komanda:\n"
						+ "viewCourseList - perziureti savo kursu sarasa\n"
						+ "viewCourseTasks,{kurso kodas} - perziureti kurso uzduotis\n"
						+ "q - atsijungti nuo paskyros");
				komanda = sc.nextLine();
				String[] dalys = komanda.split(",");
				
				switch(dalys[0]) {
					case "viewCourseList":
						System.out.println("Jusu kursai:");
						for(Kursas k: studentas.getGrupe().getKursai())
							System.out.println(k+"\n");
						System.out.println("--------------------------------");
						break;
					
					case "viewCourseTasks":
						Kursas k = studentas.getGrupe().GautiKursaPagalID(Integer.parseInt(dalys[1]));
						System.out.println("Kurse [" + k.getPavadinimas() + "] patalpintos uzduotys:");
						for(Uzduotis u: k.getUzduotys()) System.out.println(u);
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
		abs.RodytiVisusStudentus();
		System.out.println("Norint prisijungti iveskite savo studento koda");
		
		try {
			Scanner sc = new Scanner(System.in);
			String kodas = sc.nextLine();
			if(abs.GautiStudentaPagalID(Integer.parseInt(kodas))!=null) {
				studentas = abs.GautiStudentaPagalID(Integer.parseInt(kodas));
			}
			else System.out.println("Tokios paskyros nera");
		}
		catch(Exception e) {
			System.out.println("Patikrinkite ar gerai ivedete savo koda");
		}
		
	}
}
*/