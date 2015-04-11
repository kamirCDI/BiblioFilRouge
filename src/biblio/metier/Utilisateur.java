package biblio.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author afpa
 *
 */
public class Utilisateur extends Personne {
	private int idUtilisateur;
	private String pwd;
	private String pseudonyme;
	private List<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();

	public Utilisateur(String nom, String prenom, Date dateNaissance,
			String sexe, int id, String pwd, String pseudonyme) throws ParseException {
		super(nom, prenom, dateNaissance, sexe);
		setIdUtilisateur(id);
		setPwd(pwd);
		setPseudonyme(pseudonyme);
	}
	
	public Utilisateur() throws ParseException{
		this("Devanne", "jean", sdf.parse("02/05/1971"), "masculin", 2, "koukou", "coucou");
		
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
	 
/***************************************************toString()********************************************************************/
	@Override
	public String toString() {
		return super.toString() + "Utilisateur [idUtilisateur=" + idUtilisateur
				+ ", pwd=" + pwd + ", pseudonyme=" + pseudonyme + "]";
	}
		
	/***************************** classes métiers ****************************************************/
	public int getNbEmpruntsEnCours() {
		int nb=0;
		for(EmpruntEnCours s:empruntEnCours)
			nb++;
		return nb;
	}

	public List<EmpruntEnCours> getEmpruntEnCours() {
		return empruntEnCours;
	}

	public void setEmpruntEnCours(List<EmpruntEnCours> empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}
	
	public void addEmpruntEnCours(EmpruntEnCours unEmpruntEnCours) throws BiblioException
	{
		if(empruntEnCours.contains(unEmpruntEnCours)==false)
		{
			empruntEnCours.add(unEmpruntEnCours);
			unEmpruntEnCours.setEmprunteur(this);
		}
	}

}
