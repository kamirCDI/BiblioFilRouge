package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestEmployeTroisEmprunts {

	public static void main(String[] args) throws ParseException, BiblioException {
		System.out.println("********************Si trois emprunts en retard, il est possible d'emprunter pour un Employe**********************");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		Exemplaire exemplaire3 = exemplaireDao.findByKey(3);
		Exemplaire exemplaire4 = exemplaireDao.findByKey(4);
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur employe = utilisateurDao.findByKey(200);
		
		
		EmpruntEnCours emprunt1 = new EmpruntEnCours(employe, exemplaire1);
		EmpruntEnCours emprunt2 = new EmpruntEnCours(employe, exemplaire2);
		EmpruntEnCours emprunt3 = new EmpruntEnCours(employe, exemplaire3);
		
		System.out.println("L'employe");
		System.out.println(employe);
		System.out.println();
		System.out.println("Les emprunts en cours de l'employe");
		for (EmpruntEnCours emprunt : employe.getEmpruntEnCours())
			System.out.println(employe.getEmpruntEnCours());
		System.out.println("Nombre d'emprunts en cours :"+employe.getNbEmpruntsEnCours());
		System.out.println();
		System.out.println();
		System.out.println("********************Réaliser un quatrième prêt**********************");
		try {
		
			EmpruntEnCours emprunt4 = new EmpruntEnCours(employe, exemplaire4);
			System.out.println("Les emprunts en cours de l'employe");
			for (EmpruntEnCours emprunt : employe.getEmpruntEnCours())
				System.out.println(employe.getEmpruntEnCours());
			System.out.println("Nombre d'emprunts en cours :"+employe.getNbEmpruntsEnCours());
		}
		catch (BiblioException ex){
			System.out.println(ex);
		}

	}

}
