package biblio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestEmployeEnRetard {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws BiblioException, ParseException {
		System.out.println("********************Si un emprunt en retard, il est possible d'emprunter pour un Employe**********************");
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur employe = utilisateurDao.findByKey(200);
		
		ExemplairesDao exemplaireDao = new ExemplairesDao();		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		
		//employe.addEmpruntEnCours(exemplaire1.getEmprunt());
		//exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		exemplaire1.getEmprunt().emprunter(exemplaire1, employe);
		exemplaire1.getEmprunt().setDateEmprunt(sdf.parse("13/03/2015"));
		System.out.println("L'employe :");
		System.out.println(employe);
		System.out.println();
		System.out.println("Les emprunts en cours :");
		System.out.println(exemplaire1.getEmprunt());
		System.out.println("************** Réaliser un deuxième prêt******************");
		
		try {
		//employe.addEmpruntEnCours(exemplaire2.getEmprunt());
		//exemplaire2.getEmprunt().setExemplaire(exemplaire2);
			exemplaire2.getEmprunt().emprunter(exemplaire2, employe);
		System.out.println(exemplaire2.getEmprunt());
		}
		catch (BiblioException e){
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println();


	}

}
