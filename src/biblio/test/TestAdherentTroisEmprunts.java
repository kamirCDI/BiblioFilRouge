package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestAdherentTroisEmprunts {

	public static void main(String[] args) throws BiblioException, ParseException {
		
		
		System.out.println("*******************Si trois emprunts en retard, il est impossible d'emprunter pour un Adhérent**********************");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		Exemplaire exemplaire3 = exemplaireDao.findByKey(3);
		Exemplaire exemplaire4 = exemplaireDao.findByKey(4);
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
				
		EmpruntEnCours emprunt1 = new EmpruntEnCours(adherent, exemplaire1);
		EmpruntEnCours emprunt2 = new EmpruntEnCours(adherent, exemplaire2);
		EmpruntEnCours emprunt3 = new EmpruntEnCours(adherent, exemplaire3);
			
		System.out.println("L'adherent");
		System.out.println(adherent);
		System.out.println();
		System.out.println("Les emprunts en cours de l'adherent");
		
		for (EmpruntEnCours emprunt : adherent.getEmpruntEnCours())
			System.out.println(emprunt);
		System.out.println("Nombre d'emprunts en cours :"+adherent.getNbEmpruntsEnCours());
		System.out.println();
		System.out.println("********************Réaliser un quatrième prêt**********************");
		try {
		
			EmpruntEnCours emprunt4 = new EmpruntEnCours(adherent, exemplaire4);
			System.out.println(emprunt4);
		}
		catch (BiblioException ex){
			System.out.println(ex);
		}
	}

}
