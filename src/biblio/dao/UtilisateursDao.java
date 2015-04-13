/**
 * 
 */
package biblio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import biblio.metier.Adherent;
import biblio.metier.Exemplaire;

/**
 * @author Kamir_2
 *
 */
public class AdherentDao {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	private Adherent [] AdherentDB ={
	new Adherent("Devanne", "Marinne", sdf.parse("19/05/1980"), "féminin", 100, "DevM", "DevLecture", "0660636446"),
	};
	
	public AdherentDao() throws ParseException{
		
	}
	
	public Adherent findByKey(int id)
	{
		for (Adherent adherent : AdherentDB)
			if (adherent.getIdUtilisateur() == id) return adherent;
		return null;
	}
		
	}

