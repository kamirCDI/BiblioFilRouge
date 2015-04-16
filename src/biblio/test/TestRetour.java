package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestRetour {

	public static void main(String[] args) throws ParseException, BiblioException {
		
		ExemplairesDao exemplaireDao = new ExemplairesDao();		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		
		//adherent.addEmpruntEnCours(exemplaire1.getEmprunt());
		//exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		exemplaire1.getEmprunt().emprunter(exemplaire1, adherent);
		System.out.println("adherent :" +adherent );
		System.out.println();
		System.out.println("les emprunts en cours :" +adherent.getEmpruntEnCours());
		System.out.println("Nombre d'emprunts en cours :" +adherent.getNbEmpruntsEnCours());
		System.out.println();
		System.out.println("exemplaire1 :" + exemplaire1);
		System.out.println();
		System.out.println();
		
		System.out.println("**********************************Rendre un exemplaire*******************************************");
		System.out.println();
		//exemplaire1.getEmprunt().setExemplaire(null);	
		exemplaire1.getEmprunt().rendre(exemplaire1, adherent);
		System.out.println();
		System.out.println("exemplaire1 maintenant:" + exemplaire1);
		System.out.println();
		System.out.println("les emprunts en cours :" +adherent.getEmpruntEnCours());
		System.out.println("Nombre d'emprunts en cours :" + adherent.getNbEmpruntsEnCours());
		System.out.println();
		System.out.println("l'EmpruntEnCours :" + exemplaire1.getEmprunt());
		
		
		

	}

}
