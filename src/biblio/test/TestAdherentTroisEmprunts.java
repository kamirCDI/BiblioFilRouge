package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestAdherentTroisEmprunts {

	public static void main(String[] args) throws BiblioException, ParseException {
		
		
		System.out.println("********************Si trois emprunts en retard, il est impossible d'emprunter pour un Adhérent**********************");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		Exemplaire exemplaire3 = exemplaireDao.findByKey(3);
		Exemplaire exemplaire4 = exemplaireDao.findByKey(4);
		
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		
		adherent.addEmpruntEnCours(exemplaire1.getEmprunt());
		exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		
		adherent.addEmpruntEnCours(exemplaire2.getEmprunt());
		exemplaire2.getEmprunt().setExemplaire(exemplaire2);
		
		adherent.addEmpruntEnCours(exemplaire3.getEmprunt());
		exemplaire3.getEmprunt().setExemplaire(exemplaire3);
		
		System.out.println("L'adherent");
		System.out.println(adherent);
		System.out.println();
		System.out.println("Les emprunts en cours de l'adherent");
		System.out.println(adherent.getEmpruntEnCours());
		System.out.println();
		System.out.println("********************Réaliser un quatrième prêt**********************");
		try {
		adherent.addEmpruntEnCours(exemplaire4.getEmprunt());
		exemplaire4.getEmprunt().setExemplaire(exemplaire4);
		System.out.println(exemplaire4.getEmprunt());
		}
		catch (BiblioException ex){
			System.out.println(ex);
		}
	}

}
