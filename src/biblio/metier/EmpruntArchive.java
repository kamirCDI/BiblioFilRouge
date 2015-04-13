package biblio.metier;

import java.util.Date;

public class EmpruntArchive {

	private Date dateRestitutionEff;
	

	private Date dateEmprunt;
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;

	
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
		return "EmpruntArchive [dateRestitutionEff=" + dateRestitutionEff
				+ ", dateEmprunt=" + dateEmprunt + ", emprunteur=" + emprunteur
				+ ", exemplaire=" + exemplaire + "]";
	}
}
