 /**

 * 
 */
package biblio.dao;
import biblio.metier.Exemplaire;

import biblio.metier.BiblioException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Kamir_2
 *
 */
public class ExemplairesDao {
	
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	private Exemplaire [] ExemplaireDB=
		{
			new Exemplaire (1, sdf.parse("13/02/1989"), "isbn1"),
			new Exemplaire (2, sdf.parse("10/05/1988"), "isbn2"),
			new Exemplaire (3, sdf.parse("11/03/1984"), "isbn3"),
			new Exemplaire (4, sdf.parse("22/06/2011"), "isbn4"),
			
		};
	
	public ExemplairesDao() throws ParseException {
		
	}
	
	public Exemplaire findByKey(int id)
	{
		for (Exemplaire exemplaire : ExemplaireDB)
			if (exemplaire.getIdExemplaire() == id) return exemplaire;
		return null;
	}

}
