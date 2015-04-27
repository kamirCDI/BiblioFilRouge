package biblio.mongodb;


import java.util.ArrayList;
import java.util.List;

import biblio.metier.Adherent;
import biblio.metier.Exemplaire;

import com.mongodb.*;


public class EmpruntEnCoursBD {
	

	  public static void main( String args[] ){
	
	
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	DB db = new DB(mongoClient, "bibliothequeBD");
	DBCollection colUtilisateur = db.getCollection("Utilisateur");
	DBCollection colExemplaire = db.getCollection("Exemplaire");
/*******************Insertion d'utilisateurs***************************************************************************/	
	
	BasicDBObject docUtil = new BasicDBObject("nom", "Devanne").append("prenom","Marianne").append("date", "19/05/1980").append("sexe","féminin");
	docUtil.append("id", 100).append("mot de passe", "DevM").append("pseudo", "DevLecture").append("Tel","0660636446");
	colUtilisateur.insert(docUtil);
	  //DBObject myDoc = colUtilisateur.findOne();
	 //colUtilisateur.remove(myDoc);
	// colUtilisateur.remove(null);
	
	
/**********************************************Insertion d'Exemplaires*************************************************/
	ArrayList<BasicDBObject> mydoc = new ArrayList<BasicDBObject>();
	mydoc.add(new BasicDBObject("id", "1").append("date","13/02/1989").append("ISBN","isbn1"));
	mydoc.add(new BasicDBObject("id", "2").append("date","10/05/1988").append("ISBN","isbn2"));
	mydoc.add(new BasicDBObject("id", "3").append("date","11/03/1984").append("ISBN","isbn3"));
	mydoc.add(new BasicDBObject("id", "4").append("date","22/06/2011").append("ISBN","isbn4"));
	colExemplaire.insert(mydoc);
	//DBObject myDoc2 = colExemplaire.findOne();
	// colExemplaire.remove(myDoc2);
	  }
	

}
