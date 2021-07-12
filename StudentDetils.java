import java.util.*;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class StudentDetails{
	public static void main(String[] args) {
		
		// Creating a Mongo client 
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		System.out.println("Created Mongo Connection successfully");
		
		// Creating Database
		MongoDatabase db = mongoClient.getDatabase("StudentDetails");
		System.out.println("Get database is successful");
		
		// Creating collections
		MongoCollection<Document> collection= db.getCollection("StudentDetails");
		System.out.println("collection created ");
		
		//Inserting Student Details by creating documents.
		  Document doc =new Document("name","V.Y.T.Kishore");
		  doc.append("id",151127);
		  doc.append("Programming Language", "Python");
		  collection.insertOne(doc); 
		  
		  Document doc1= new Document("name","Teja Kishore");
		  doc1.append("id","N151127");
		  doc1.append("Programming Language","Java");
		  collection.insertOne(doc1);
		  System.out.println("Insert is completed");
		  
		  //Reading the documents
	      FindIterable<Document> iterDoc = collection.find();
	      Iterator it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	      }
	      
	      // Updating Document 
	      collection.updateOne(Filters.eq("name", "V.Y.T.Kishore"), Updates.set("Programming Language", "Java"));
	      System.out.println("Document update successfully...");
	      FindIterable<Document> iterDoc1 = collection.find();
	      Iterator it1 = iterDoc1.iterator();
	      while (it1.hasNext()) {
	         System.out.println(it1.next());
	      }
	      
	      // Deleting one document
	      collection.deleteOne(Filters.eq("name", "Teja Kishore"));
	      System.out.println("Document deleted successfully...");
	      
	      
	      //Retrieving the documents after the delete operation
	      FindIterable<Document> iterDoc11 = collection.find();
	      int i = 1;
	      System.out.println("Remaining documents:");
	      Iterator it11 = iterDoc11.iterator();
	      while (it11.hasNext()) {
	         System.out.println(it11.next());
	         i++;
	      }
		
	}

}
