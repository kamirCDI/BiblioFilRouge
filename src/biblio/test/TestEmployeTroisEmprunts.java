package biblio.test;

import java.text.ParseException;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
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
		
		//employe.addEmpruntEnCours(exemplaire1.getEmprunt());
		//exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		exemplaire1.getEmprunt().emprunter(exemplaire1, employe);
		
		//employe.addEmpruntEnCours(exemplaire2.getEmprunt());
		//exemplaire2.getEmprunt().setExemplaire(exemplaire2);
		exemplaire2.getEmprunt().emprunter(exemplaire2, employe);
		
		//employe.addEmpruntEnCours(exemplaire3.getEmprunt());
		//exemplaire3.getEmprunt().setExemplaire(exemplaire3);
		exemplaire3.getEmprunt().emprunter(exemplaire3, employe);
		
		System.out.println("L'employe");
		System.out.println(employe);
		System.out.println();
		System.out.println("Les emprunts en cours de l'employe");
		System.out.println(employe.getEmpruntEnCours());
		System.out.println("Nombre d'emprunts en cours :"+employe.getNbEmpruntsEnCours() );
		System.out.println();
		System.out.println("********************Réaliser un quatrième prêt**********************");
		try {
		//employe.addEmpruntEnCours(exemplaire4.getEmprunt());
		//exemplaire4.getEmprunt().setExemplaire(exemplaire4);
			exemplaire4.getEmprunt().emprunter(exemplaire4, employe);
		System.out.println(exemplaire4.getEmprunt());
		}
		catch (BiblioException ex){
			System.out.println(ex);
		}

	}

}
