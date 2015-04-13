package biblio.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author afpa
 * Classe Utilisateur hérite de la classe Personne 
 * Utilisateur de la bibliothèque 
 */
public class Utilisateur extends Personne {
	
	/*attributs : idUtilisateur : identifiant utilisateur  
	 *            pwd : mot de passe 
	 *            pseudonyme 
	 *            empruntEnCours :liste des emprunts en cours      */
	
	
	
	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private List<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();
	
/***************************************Constructeur*****************************************************************/
	public Utilisateur(String nom, String prenom, Date dateNaissance,
			String sexe, int id, String pwd, String pseudonyme) throws ParseException {
		super(nom, prenom, dateNaissance, sexe);
		setIdUtilisateur(id);
		setPwd(pwd);
		setPseudonyme(pseudonyme);
	}
	
	public Utilisateur() throws ParseException{
		this("Devanne", "jean", sdf.parse("02/05/1971"), "masculin", 1, "DevJe", "DevLecture");
		
	}

	/************************ Getters et Setters *******************************************************/
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}
	
	public List<EmpruntEnCours> getEmpruntEnCours() {
		return empruntEnCours;
	}

	public void setEmpruntEnCours(List<EmpruntEnCours> empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}
	 
/***************************************************toString()********************************************************************/
	@Override
	public String toString() {
		return super.toString() + ", idUtilisateur=" + idUtilisateur
				+ ", pwd=" + pwd + ", pseudonyme=" + pseudonyme + "]";
	}
		
	/***************************** classes métiers ****************************************************/
	public int getNbEmpruntsEnCours() {
		
		return empruntEnCours.size();
	}

	
	public void addEmpruntEnCours(EmpruntEnCours unEmpruntEnCours) throws BiblioException
	{		
		empruntEnCours.add(unEmpruntEnCours);
		unEmpruntEnCours.setEmprunteur(this);
	}

}
