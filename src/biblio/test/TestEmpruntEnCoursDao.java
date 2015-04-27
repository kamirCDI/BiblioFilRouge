package biblio.test;

import java.text.ParseException;

import biblio.dao.EmpruntEnCoursDao;
import biblio.dao.ExemplairesDao;
import biblio.dao.UtilisateursDao;
import biblio.metier.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class TestEmpruntEnCoursDao {

	public static void main(String[] args) throws ParseException, BiblioException {
		
		ExemplairesDao exemplaireDao = new ExemplairesDao();
		Exemplaire exemplaire1 = exemplaireDao.findByKey(1);
		UtilisateursDao utilisateurDao = new UtilisateursDao();
		Utilisateur adherent = utilisateurDao.findByKey(100);
		EmpruntEnCoursDao empruntdao = new EmpruntEnCoursDao();
		EmpruntEnCours emprunt1 = new EmpruntEnCours(adherent, exemplaire1);
		//empruntdao.insertEmpruntEnCours(emprunt1);
		//empruntdao.deleteEmpruntEnCours(1);
		System.out.println(empruntdao.findByKey(1));
		
		

	}

}
