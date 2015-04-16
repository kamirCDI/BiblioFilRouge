package biblio.test;

import java.text.DateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Adherent;
import biblio.metier.Employe;
import biblio.metier.Utilisateur;
import biblio.metier.EmpruntEnCours;

public class TestAdherentEnRetard {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException, BiblioException {
		
		
	
		
		System.out.println("********************Si un emprunt en retard, il est impossible d'emprunter pour un Adherent**********************");
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		ExemplairesDao exemplaireDao = new ExemplairesDao();		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		Exemplaire exemplaire3 = exemplaireDao.findByKey(3);
		
	
		EmpruntEnCours emprunt1 = new EmpruntEnCours(adherent, exemplaire1);
		EmpruntEnCours emprunt2 = new EmpruntEnCours(adherent, exemplaire2);
		System.out.println("L'adherent :");
		System.out.println(adherent);
		System.out.println();
		System.out.println("Les exemplaires en cours :");
		System.out.println(adherent.getNbEmpruntsEnCours());
		System.out.println();
		System.out.println("************** Réaliser un autre prêt******************");
		emprunt2.setDateEmprunt(sdf.parse("13/03/2015"));
		try {
			EmpruntEnCours emprunt3 = new EmpruntEnCours(adherent, exemplaire3);
			System.out.println(adherent.getNbEmpruntsEnCours());
		}
		catch (BiblioException e){
			System.out.println(e);
		}

	}

}
