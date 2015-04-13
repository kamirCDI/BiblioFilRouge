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

public class TestAdherentEnRetard {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException, BiblioException {
		
		
	
		
		System.out.println("********************Si un emprunt en retard, il est impossible d'emprunter pour un Adherent**********************");
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		ExemplairesDao exemplaireDao = new ExemplairesDao();		
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		Exemplaire exemplaire2 = exemplaireDao.findByKey(2);
		
		//adherent.addEmpruntEnCours(exemplaire1.getEmprunt());
		//exemplaire1.getEmprunt().setExemplaire(exemplaire1);
		exemplaire1.getEmprunt().emprunter(exemplaire1, adherent);
		exemplaire1.getEmprunt().setDateEmprunt(sdf.parse("13/03/2015"));
		System.out.println("L'adherent :");
		System.out.println(adherent);
		System.out.println();
		System.out.println("Les exemplaires en cours :");
		System.out.println(exemplaire1.getEmprunt());
		System.out.println("************** Réaliser un deuxième prêt******************");
		
		try {
		//adherent.addEmpruntEnCours(exemplaire2.getEmprunt());
		//exemplaire2.getEmprunt().setExemplaire(exemplaire2);
		exemplaire2.getEmprunt().emprunter(exemplaire2, adherent);
		System.out.println(exemplaire2.getEmprunt());
		}
		catch (BiblioException e){
			System.out.println(e);
		}

	}

}
