package biblio.test;
import java.text.ParseException;

import biblio.dao.ExemplaireDao;
import biblio.dao.AdherentDao;
import biblio.metier.BiblioException;
import biblio.metier.Exemplaire;
import biblio.metier.Adherent;

public class TestDeBase {

	public static void main(String[] args) throws BiblioException, ParseException {
	
		
		
		System.out.println("*******************Demande de deux exemplaires par leur id aux Dao*******************************");
		ExemplaireDao exemplaireDao = new ExemplaireDao();
		
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
		AdherentDao adherentDao = new AdherentDao();
		Adherent adherent = adherentDao.findByKey(100);
		System.out.println(adherent);
		System.out.println();
		System.out.println();
		System.out.println("**********************Demande d'un Employé par son id*******************************");
		System.out.println();
		
		System.out.println();
		System.out.println();
		System.out.println("**********************Création en cours pour un adhérent*******************************");
		System.out.println();

		System.out.println();
		System.out.println();
		System.out.println("**********************Création en cours pour un Employé*******************************");
		
		
		
		
	}

}
