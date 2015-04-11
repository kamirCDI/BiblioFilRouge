package biblio.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpruntEnCours {
	
	private Date dateEmprunt;
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	static {sdf.setLenient(false);}


	
	/*******************************************Constructeurs*******************************************************************/
	
	public EmpruntEnCours(Date dateEmprunt, Utilisateur emprunteur,	Exemplaire exemplaire) throws BiblioException {
		setDateEmprunt(dateEmprunt);
		setEmprunteur(emprunteur);
		setExemplaire(exemplaire);
	}
	
	public EmpruntEnCours(Date dateEmprunt, Utilisateur emprunteur) throws BiblioException {
		setDateEmprunt(dateEmprunt);
		setEmprunteur(emprunteur);
	}

	
	public EmpruntEnCours() throws BiblioException{
		this(null,null);
	}

	/****************************************Getters et Setters************************************************************************/
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
		if (emprunteur != null){
			this.emprunteur = emprunteur;
			setDateEmprunt(new Date());
		}
		 else
			 this.emprunteur = null;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	

	
	public void setExemplaire(Exemplaire exemplaire) throws BiblioException {
			if (exemplaire != null){
				this.exemplaire=exemplaire;
				exemplaire.setEmpruntEnCours(this);
			}
			else 
				exemplaire.setEmpruntEnCours(null);
	}
/**********************************************toString()****************************************************************************************/	

	@Override
	public String toString() {
				return "EmpruntEnCours [dateEmprunt=" + sdf.format(dateEmprunt) + ", emprunteur=" 
					+ emprunteur.getNom() + ", examplaire=" + exemplaire.getIdExemplaire() + "]";

	}

}
