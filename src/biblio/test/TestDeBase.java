package biblio.test;
import java.text.ParseException;



import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Adherent;
import biblio.metier.Employe;
import biblio.metier.Utilisateur;

public class TestDeBase {

	public static void main(String[] args) throws BiblioException, ParseException {
	
		
		
		System.out.println("*******************Demande de deux exemplaires par leur id aux Dao*******************************");
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		
		System.out.println();
		System.out.println(exemplaire1);
		System.out.println();
		System.out.println(exemplaire2);
		System.out.println();
		System.out.println();
		
		System.out.println("*********************Demande d'un adhérent par son id*******************************");
		System.out.println();
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		System.out.println(adherent);
		System.out.println();
		System.out.println();
		System.out.println("**********************Demande d'un Employé par son id*******************************");
		System.out.println();
		Utilisateur employe = utilisateurDao.findByKey(200);
		System.out.println(employe);		
		System.out.println();
		System.out.println();
		System.out.println("**********************Création d'un emprunt en cours pour un adhérent*******************************");
		System.out.println();
		//adherent.addEmpruntEnCours(exemplaire1.getEmprunt());
		//exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		exemplaire1.getEmprunt().emprunter(exemplaire1, adherent);
		System.out.println(exemplaire1.getEmprunt());
		System.out.println();
		System.out.println();
		System.out.println("**********************Création d'un emprunt en cours pour un Employé*******************************");
		System.out.println();
		//employe.addEmpruntEnCours(exemplaire2.getEmprunt());
		//exemplaire2.getEmprunt().setExemplaire(exemplaire2);
		exemplaire1.getEmprunt().emprunter(exemplaire2, employe);
		System.out.println(exemplaire2.getEmprunt());
		System.out.println();
		System.out.println();
		
		
	}

}
