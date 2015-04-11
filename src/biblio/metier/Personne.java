
package biblio.metier;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author afpa
 * 
 *Classe qui regroupe les attributs communs des personnes fréquentant la bibliothèque
 */

public class Personne {
	
/*attributs: nom , prenom, date de naissance, et sexe de la personne
 */
/* attribut sdf est utilisé pour tenir un objet Date */
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	static {sdf.setLenient(false);}
	
/*****************Constructeur*******************************************************/
	public Personne(String nom, String prenom, Date dateNaissance, String sexe) throws ParseException{
		setNom(nom);
		setPrenom(prenom);
		setDateNaissance(dateNaissance);
		setSexe(sexe);
	}
	
	public Personne() throws ParseException{
		this("Dupont", "Robert", sdf.parse("19/05/1970"), "masculin");
	}
	/******************Getters et Setters************************************************/
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + sdf.format(dateNaissance) + ", sexe=" + sexe + "]";
	}
	
	
	
}
