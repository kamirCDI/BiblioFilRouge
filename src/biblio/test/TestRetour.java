package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestRetour {

	public static void main(String[] args) throws Throwable {
		
		ExemplairesDao exemplaireDao = new ExemplairesDao();		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		
/*******************************créer deux emprunts pour un adherent***************************************************/			
		EmpruntEnCours emprunt1 = new EmpruntEnCours(adherent, exemplaire1);
		EmpruntEnCours emprunt2 = new EmpruntEnCours(adherent, exemplaire2);
	
		System.out.println("adherent :" +adherent );
		System.out.println();
		System.out.println("exemplaire1 :" + exemplaire1);
		System.out.println("exemplaire2 :" + exemplaire2);
		System.out.println();
		System.out.println("Les emprunts en cours de l'adhérent:");
		for (EmpruntEnCours emprunt : adherent.getEmpruntEnCours())
			System.out.println(emprunt);
		System.out.println("Nombre d'emprunts en cours :" +adherent.getNbEmpruntsEnCours());
		
		System.out.println();
		System.out.println();
		
		System.out.println("**********************************Rendre un exemplaire*******************************************");
		System.out.println();
		
		emprunt1 = null;
		exemplaire1.setEmpruntEnCours(null);
		
		System.out.println();
		System.out.println("exemplaire1 :" + exemplaire1);
		System.out.println("exemplaire2 :" + exemplaire2);
		System.out.println();
		System.out.println("les emprunts en cours de l'adhérent:");
		for (EmpruntEnCours emprunt : adherent.getEmpruntEnCours())
			System.out.println(emprunt);
		System.out.println("Nombre d'emprunts en cours :" + adherent.getNbEmpruntsEnCours());
		System.out.println();
		System.out.println("l'EmpruntEnCours sur exemplaire1 :" + emprunt1);
		System.out.println("exemplaire1 :" + exemplaire1);
		
		
		

	}

}
