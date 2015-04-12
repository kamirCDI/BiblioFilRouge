package biblio.test;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import biblio.metier.*;


public class TestEmpruntEnCours {
	
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws ParseException, BiblioException { 
		
			
/**********************************Instanciation de la classe Personne, Utilisateur, Adherent, Employe****************************************************************/
		
                         /***************************Test classe Personne****************************************************************************/
		System.out.println("******************************Test de la classe Personne******************************");
		System.out.println();
		Personne personne1 = new Personne();
		System.out.println(personne1);
		System.out.println();
		System.out.println();
		
		
		System.out.println("******************Test de la classe utilisateur**************************");
		System.out.println();
		Utilisateur utilisateur1 = new Utilisateur();
		System.out.println(utilisateur1);
		System.out.println();
		System.out.println();
		
/***********************************************creation d'un adherent*******************************************************************/
		System.out.println("***************************creation d'un adhérent****************************");
		System.out.println();		
		Adherent adherent1 = new Adherent();
		System.out.println(adherent1);
		System.out.println();
		System.out.println();

	
	
/****************************************Instanciation d'exemplaires*************************************************************/
	
	System.out.println("***************************creation de 4 exemplaires****************************");
	System.out.println();		
	Exemplaire exemplaire1 = new Exemplaire();
	
	Exemplaire exemplaire2 = new Exemplaire(2, sdf.parse("14/03/1998"), "2NM36");
	Exemplaire exemplaire3 = new Exemplaire(3, sdf.parse("01/05/1989"), "3KL65");
	Exemplaire exemplaire4 = new Exemplaire(4, sdf.parse("25/08/2001"), "4JH58");
	System.out.println(exemplaire1);
	System.out.println(exemplaire2);
	System.out.println(exemplaire3);
	System.out.println(exemplaire4);
	System.out.println();
	System.out.println();
	

	
/********************************************realiser des prêt en cours*****************************************************/
	System.out.println("***************************Réaliser des prêts**************************************");
    
	
		adherent1.addEmpruntEnCours(exemplaire1.getEmprunt());
		exemplaire1.getEmprunt().setExemplaire(exemplaire1);
	
	
	
	exemplaire2.getEmprunt().setEmprunteur(adherent1);
	exemplaire2.getEmprunt().setExemplaire(exemplaire2);
	
	exemplaire3.getEmprunt().setEmprunteur(adherent1);
	exemplaire3.getEmprunt().setExemplaire(exemplaire3);
	
	System.out.println(exemplaire1);
	System.out.println(exemplaire2);
	System.out.println(exemplaire3);
	System.out.println();
	System.out.println();


/********************************************connaître le nombre d'emprunts*****************************************************/
	
	System.out.println("***************************connaître le nombre d'emprunts****************************");
	System.out.println();
	System.out.printf("Nombre d'emprunts en cours pour l'adherent ("+adherent1.getNom()+" "+adherent1.getPrenom()+"):");
	System.out.println(adherent1.getNbEmpruntsEnCours());
	System.out.println("Liste des emprunts en cours pour l'adherent ("+adherent1.getNom()+" "+adherent1.getPrenom()+"):");
	System.out.println(adherent1.getEmpruntEnCours());
	System.out.println();
	
/*****************************************réaliser un quatrième prêt**********************************************************/
	System.out.println("*********************************réaliser un quatrième prêt*************************************");
	System.out.println();
	try {
		exemplaire4.getEmprunt().setEmprunteur(adherent1);
		exemplaire4.getEmprunt().setExemplaire(exemplaire4);
	}
	catch (BiblioException ex){
		System.out.println("Exception :" +ex);
	}
	System.out.println();
	System.out.println();
	
/************************************Instanciation de Employe et emprunt pour cette employe*****************************************************/
	System.out.println(" ****************************Un employe va faire un emprunt********************************************");
	System.out.println();
	Employe employe1 = new Employe();
	exemplaire1.getEmprunt().setEmprunteur(employe1);
	exemplaire2.getEmprunt().setEmprunteur(employe1);
	exemplaire3.getEmprunt().setEmprunteur(employe1);
	exemplaire4.getEmprunt().setEmprunteur(employe1);	
	System.out.println(exemplaire1);
	System.out.println();
	System.out.println("Les nombres d'emprunt en cours :" + employe1.getNbEmpruntsEnCours()); 	
}
}
