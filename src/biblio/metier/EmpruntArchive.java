package biblio.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Classe pour emprunt à archiver
 */

public class EmpruntArchive {

	private Date dateRestitutionEff;
	

	private Date dateEmprunt;
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	
/*************************************************Constructeur****************************************************************/	
	public EmpruntArchive (Date dateRestitutionEff, Date dateEmprunt, Utilisateur emprunteur, Exemplaire exemplaire){
		setDateRestitutionEff(dateRestitutionEff);
		setDateEmprunt(dateEmprunt);
		setEmprunteur(emprunteur);
		setExemplaire(exemplaire);
	}

/**************************************Getters et Setters************************************************************************/	
	
	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
/******************************************************toString()***************************************************************************/
	@Override
	public String toString() {
		return "EmpruntArchive [dateRestitutionEff=" + sdf.format(dateRestitutionEff)
				+ ", dateEmprunt=" + sdf.format(dateEmprunt) + ", emprunteur=" + emprunteur.getIdUtilisateur()
				+ ", exemplaire=" + exemplaire.getIdExemplaire() + "]";
	}
}
