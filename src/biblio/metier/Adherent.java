package biblio.metier;

import java.text.ParseException;
import java.util.Date;

/**
 * @author afpa
 * Classe de l'adhérent inscrit à la bibliothèque
 *
 */
public class Adherent extends Utilisateur{

	/****attributs : telephone
	 *               nbMaxPrets : Nombre maximum de prêts autorisé 
	 *               dureeMaxPrest : durée maximum de prêts
	 */
	private String telephone;
	private static int nbMaxPrets=3;
	private static int dureeMaxPrets=15;
	
	
	

	public Adherent(String nom, String prenom, Date dateNaissance, String sexe, int id, String pwd, String pseudonyme, String telephone) throws ParseException{
		super(nom, prenom, dateNaissance, sexe, id, pwd, pseudonyme);
		setTelephone(telephone);
	}
	
	public Adherent() throws ParseException{
		this("Devanne", "camille", sdf.parse("02/05/1970"), "feminin", 2, "DevCa", "Calecture", "0102253563");
	}

	/***************************Getters et Setters*******************************************/
	
	public String getTelephone() {
		return telephone;
	}

	

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public static int getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	/********************************toString()*********************************************************/
	@Override
	public String toString() {
		return super.toString() + "Adherent [telephone=" + telephone + "]";
	}
	
	
	/********************************classes métiers*********************************************/
	public Boolean isConditionsPretAcceptees(){
		return (getNbEmpruntsEnCours() < 3 && getNbRetards() == 0);
	}
 
	
	@Override
	public void addEmpruntEnCours(EmpruntEnCours unEmpruntEnCours) throws BiblioException {
		if (isConditionsPretAcceptees()){
			super.addEmpruntEnCours(unEmpruntEnCours);
			unEmpruntEnCours.setEmprunteur(this);
		}
		else 
			throw new BiblioException("Les conditions pour un nouveau prêt ne sont pas satisfaites");
	}
	
	public int getNbRetards(){
		int nb=0;
		for(EmpruntEnCours s:getEmpruntEnCours())
		{
			if(s.isPretEnRetard())
				nb++;
		}
		return nb;
	}
}
