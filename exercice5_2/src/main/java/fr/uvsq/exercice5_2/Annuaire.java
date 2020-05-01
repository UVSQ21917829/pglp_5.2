package fr.uvsq.exercice5_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Annuaire {
	
ENVIRONNEMENT;
	
	private CompositePersonnels init() {
		
		Personnel personne1;
		Personnel personne2;
		Personnel personne3;
		Personnel personne4;
		CompositePersonnels groupe1;
		CompositePersonnels groupe2;
		CompositePersonnels groupe3;
		personne2= new Personnel.Builder(7, "c", "d",LocalDate.parse("1997-08-01",DateTimeFormatter.ISO_DATE)).build();
		personne1= new Personnel.Builder(2, "a", "b",LocalDate.parse("1997-08-01",DateTimeFormatter.ISO_DATE)).build();
		personne3= new Personnel.Builder(5, "e", "f",LocalDate.parse("1997-08-01",DateTimeFormatter.ISO_DATE)).build();
		personne4=new Personnel.Builder(6, "g", "h",LocalDate.parse("1997-08-01",DateTimeFormatter.ISO_DATE)).build();
		groupe1 = new CompositePersonnels(1);
		groupe2 = new CompositePersonnels(3);
		groupe3 = new CompositePersonnels(4);
		groupe1.addPersonnel(personne1);
		groupe1.addPersonnel(groupe2);
		groupe2.addPersonnel(groupe3);
		groupe2.addPersonnel(personne3);
		groupe3.addPersonnel(personne4);
		groupe3.addPersonnel(personne2);

		return groupe1;
	}
	
	private void afficher(CompositePersonnels cp) {
		
		AffichageParGroup affichage = new AffichageParGroup(cp);
		Iterator grouptIterator = affichage.getIterator();
		while (grouptIterator.hasNext()) {
			InterfacePersonnel nextValue=grouptIterator.next();
			
            System.out.println("la valeut suivant est: " + nextValue.toString());
        
		}
	}
	private void run(String[] args) {
		CompositePersonnels cp = init();
		System.out.println("####### affichage #####");
		afficher(cp);		
	}
	
	public static void main(String[] args) {
		ENVIRONNEMENT.run(args);
	}

}
