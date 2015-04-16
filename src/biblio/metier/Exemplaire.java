package biblio.metier;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*classe des exemplaire d'un livre
 * */

public class Exemplaire {
	
	private int idExemplaire;
	private Date dateAchat;
	private EnumStatusExemplaire status =  EnumStatusExemplaire.DISPONIBLE;
	private String isbn;
	private EmpruntEnCours emprunt;
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");


/*******************************constructeur***********************************************/

	public Exemplaire(int id, Date dateAchat, String isbn) throws ParseException{
		setIdExemplaire(id);
		setDateAchat(dateAchat);
		setIsbn(isbn);
	}
	
	public Exemplaire() throws ParseException
	{
		this(1, sdf.parse("15/02/2000"), "1MJ23");
	}
	

/**********************************Getters et Setters****************************************/	
	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public EnumStatusExemplaire getStatus() {
		return status;
	}

	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	public EmpruntEnCours getEmprunt() {
		return emprunt;
	}
	
	
	public void setEmpruntEnCours(EmpruntEnCours empruntEnCours){
		if (empruntEnCours != null){
				this.emprunt= empruntEnCours;
				setStatus(EnumStatusExemplaire.PRETE);
		}
		else {
			setStatus(EnumStatusExemplaire.DISPONIBLE);
			this.emprunt = null;			 
		}
	}

	

/**************************toString***********************************************************/
	@Override
	public String toString() {
		if (getStatus() == EnumStatusExemplaire.DISPONIBLE) 
			return "Exemplaire [idExemplaire=" + idExemplaire + ", dateAchat="
				+ sdf.format(dateAchat) + ", status=" + status + ", isbn=" + isbn + "]";
		else
			return "Exemplaire [idExemplaire=" + idExemplaire + ", dateAchat="
			+ sdf.format(dateAchat) + ", status=" + status + ", isbn=" + isbn + ", emprunté par=" + emprunt.getEmprunteur().getNom() + "]";
	}
		}
		

	

	
	
	


