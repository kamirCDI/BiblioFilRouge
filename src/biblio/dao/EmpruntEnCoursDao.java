package biblio.dao;

import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;
import biblio.metier.EmpruntEnCours;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class EmpruntEnCoursDao {
	 
		 	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			DB db = new DB(mongoClient, "bibliothequeBD");
			DBCollection colEmprunts = db.getCollection("EmpruntEnCoursDao");
			private static int id=0;
			
		public void insertEmpruntEnCours(EmpruntEnCours e){
			id=id+1;
			BasicDBObject docEmprunt = new BasicDBObject("id",id).append("date", e.getDateEmprunt()).append("utilisateur", e.getEmprunteur().getIdUtilisateur()).append("exemplaire", e.getExemplaire().getIsbn());
			colEmprunts.insert(docEmprunt);
		}
		
		public  DBObject findByKey(int key)
		{
			
			DBObject dbo1 = colEmprunts.findOne(new BasicDBObject("id", key));
			return dbo1;
		}
		
		public void deleteEmpruntEnCours(int key){
			
			DBObject dbo1 = colEmprunts.findOne(new BasicDBObject("id", key));
			colEmprunts.remove(dbo1);
			
		}
		
		/*public void updateEmpruntEnCours(int key){
			DBObject myDoc2 =  colEmprunts.find(new BasicDBObject("id", key));
			colExemplaire.remove(myDoc2);
			
		}*/

}
