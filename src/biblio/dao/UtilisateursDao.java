/**
 * 
 */
package biblio.dao;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import biblio.metier.Adherent;
import biblio.metier.Employe;
import biblio.metier.EnumCategorieEmploye;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;
import biblio.metier.BiblioException;

/**
 * @author Kamir_2
 *
 */
public class UtilisateursDao {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	private Utilisateur [] UtilisateurDB ={
	new Adherent("Devanne", "Marinne", sdf.parse("19/05/1980"), "féminin", 100, "DevM", "DevLecture", "0660636446"),
	new Employe("Guarigue", "Adel", sdf.parse("12/12/1971"), "masculin", 200, "GuaAd", "GuaBib", "1m42536", EnumCategorieEmploye.BIBLIOTHECAIRE),
	};
	
	public UtilisateursDao() throws ParseException{
		
	}
	
	public Utilisateur findByKey(int id)
	{
		for (Utilisateur utilisateur : UtilisateurDB)
			if (utilisateur.getIdUtilisateur() == id) return utilisateur;
		return null;
	}
		
	}

