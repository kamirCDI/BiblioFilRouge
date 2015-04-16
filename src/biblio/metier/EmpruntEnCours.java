package biblio.metier;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*
 * classe pour emprunt en cours
 */

public class EmpruntEnCours {
	
	private Date dateEmprunt;
	private Utilisateur unemprunteur;
	private Exemplaire exemplaire;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	static {sdf.setLenient(false);}
	


	
	/*******************************************Constructeurs
	 * @throws BiblioException *******************************************************************/
	
	public EmpruntEnCours(Date dateEmprunt, Utilisateur emprunteur,	Exemplaire exemplaire) throws BiblioException{
		setDateEmprunt(dateEmprunt);
		setEmprunteur(emprunteur);
		setExemplaire(exemplaire);
	}
	
	public EmpruntEnCours( Utilisateur emprunteur,	Exemplaire exemplaire) throws BiblioException{
		this(new Date(), emprunteur, exemplaire);
	}

	
	public EmpruntEnCours() throws BiblioException{
		this(null, null);
	}

	/****************************************Getters et Setters************************************************************************/
	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
			this.dateEmprunt = dateEmprunt;
	}

	public Utilisateur getEmprunteur() {
		return unemprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) throws BiblioException{
		if (emprunteur != null){
			unemprunteur = emprunteur;
			unemprunteur.addEmpruntEnCours(this);
			setDateEmprunt(new Date());
			}		
		}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	
/*	public void setExemplaire(Exemplaire exemplaire) {
		if (exemplaire != null){
			 this.exemplaire=exemplaire;
			 exemplaire.setEmpruntEnCours(this);
		}
		else
			if (this.exemplaire!= null){
				this.exemplaire.setEmpruntEnCours(null);
				this.unemprunteur.removeEmpruntEnCours(this);
				System.out.println("Emprunt est archivé :" + new EmpruntArchive( new Date(), this.dateEmprunt, unemprunteur, this.getExemplaire()));
				
			}
	}*/
	
	public void setExemplaire(Exemplaire exemplaire) {
		if (exemplaire != null){
			 this.exemplaire=exemplaire;
			 exemplaire.setEmpruntEnCours(this);
		}
	}
/**********************************************toString()****************************************************************************************/	

	@Override
	public String toString() {
				return "EmpruntEnCours [dateEmprunt=" + sdf.format(dateEmprunt) + ", emprunteur=" 
					+ unemprunteur.getNom() + ", examplaire=" + exemplaire.getIdExemplaire() + "]";

	}
/**********************************classe métier******************************************************************/	
	public boolean isPretEnRetard() {

		// Instanciation � la date du jour et configuration Timezone et locale
		Calendar cl = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		// Soustraction de la dur�e max de pret
		cl.add(Calendar.DAY_OF_YEAR, -Adherent.getDureeMaxPrets());
		// Determine la date mini sans retard
		Date dateMinSansRetard = cl.getTime();
		return this.getDateEmprunt().before(dateMinSansRetard);
	}

	public void rendre(Exemplaire exemplaire, Utilisateur utilisateur) throws BiblioException
	{
		this.exemplaire.setEmpruntEnCours(null);
		this.unemprunteur.removeEmpruntEnCours(this);
		System.out.println("Emprunt est archivé :" + new EmpruntArchive( new Date(), this.dateEmprunt, unemprunteur, this.getExemplaire()));
	}
}
