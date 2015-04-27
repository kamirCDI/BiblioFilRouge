package biblio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
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
		Exemplaire exemplaire3 = exemplaireDao.findByKey(3);
		

		EmpruntEnCours emprunt1 = new EmpruntEnCours(employe, exemplaire1);
		EmpruntEnCours emprunt2 = new EmpruntEnCours(employe, exemplaire2);
		System.out.println("L'employe :");
		System.out.println(employe);
		System.out.println();
		System.out.println("Les exemplaires en cours :");
		System.out.println(employe.getNbEmpruntsEnCours());
		for (EmpruntEnCours emprunt : employe.getEmpruntEnCours())
			System.out.println(emprunt);
		System.out.println();
		System.out.println();
		System.out.println("************** Réaliser un autre prêt******************");
		
		try {
			EmpruntEnCours emprunt3 = new EmpruntEnCours(employe, exemplaire3);
			System.out.println(employe.getNbEmpruntsEnCours());
			for (EmpruntEnCours emprunt : employe.getEmpruntEnCours())
				System.out.println(emprunt);
		}
		catch (BiblioException e){
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println();


	}

}
