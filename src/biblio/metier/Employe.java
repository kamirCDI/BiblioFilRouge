/**
 * 
 */
package biblio.metier;

import java.text.ParseException;
import java.util.Date;

/**
 * @author afpa
 * Classe Employé de la bibliothèque
 * responsable ou bibliothécaire ou gestionnaire de fonds
 *
 */
public class Employe extends Utilisateur{
	
	/***attributs : codeMatricule 
	 *            :  EnumCategorieEmploye bibliothécaire ou responsable
	 */

	private String codeMatricule;
	private EnumCategorieEmploye categorieEmploye;
	

/*********************************************Constructeurs**************************************************************************************/
	public Employe(String nom, String prenom, Date dateNaissance, String sexe, int id, String pwd, String pseudonyme, String codeMatricule, EnumCategorieEmploye categorieEmploye) throws ParseException{
		super(nom, prenom, dateNaissance, sexe, id, pwd, pseudonyme);
		setCodeMatricule(codeMatricule);
		setCategorieEmploye(categorieEmploye);
	}
	
	public Employe(String codeMatricule, EnumCategorieEmploye categorieEmploye) throws ParseException{
		this("Garigue ", "Georges", sdf.parse("12/02/1964"), "masculin", 100, "GarGe", "valro",codeMatricule ,categorieEmploye);
		
	}
	
	public Employe() throws BiblioException, ParseException{
		this("1nGarGe", EnumCategorieEmploye.BIBLIOTHECAIRE);
	}

	
/*******************************************************Getters et Setters*************************************************************/	
	public String getCodeMatricule() {
		return codeMatricule;
	}


	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}


	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}


	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
	}

	/*************************************************toString********************************************************************/
	@Override
	public String toString() {
		return super.toString()+"Employe [codeMatricule=" + codeMatricule
				+ ", categorieEmploye=" + categorieEmploye + "]";
	}

}
