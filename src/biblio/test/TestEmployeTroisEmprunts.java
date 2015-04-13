package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestEmployeTroisEmprunts {

	public static void main(String[] args) throws ParseException, BiblioException {
		System.out.println("********************Si trois emprunts en retard, il est impossible d'emprunter pour un Employe**********************");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		Exemplaire exemplaire3 = exemplaireDao.findByKey(3);
		Exemplaire exemplaire4 = exemplaireDao.findByKey(4);
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur employe = utilisateurDao.findByKey(200);
		
		employe.addEmpruntEnCours(exemplaire1.getEmprunt());
		exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		
		employe.addEmpruntEnCours(exemplaire2.getEmprunt());
		exemplaire2.getEmprunt().setExemplaire(exemplaire2);
		
		employe.addEmpruntEnCours(exemplaire3.getEmprunt());
		exemplaire3.getEmprunt().setExemplaire(exemplaire3);
		
		System.out.println("L'adherent");
		System.out.println(employe);
		System.out.println();
		System.out.println("Les emprunts en cours de l'adherent");
		System.out.println(employe.getEmpruntEnCours());
		System.out.println();
		System.out.println("********************Réaliser un quatrième prêt**********************");
		try {
		employe.addEmpruntEnCours(exemplaire4.getEmprunt());
		exemplaire4.getEmprunt().setExemplaire(exemplaire4);
		System.out.println(exemplaire4.getEmprunt());
		}
		catch (BiblioException ex){
			System.out.println(ex);
		}

	}

}
