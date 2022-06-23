package inventario_naves;
import static com.mongodb.client.model.Filters.eq;

import java.sql.DatabaseMetaData;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class QuickStart {
    // Replace the uri string with your MongoDB deployment's connection string
	public void obtenerdatos() {
		
		
		String nombre="jhon";
		
		String uri= "mongodb+srv://ricardo_cema:7dejulio@sofkanaves.6idatke.mongodb.net/?retryWrites=true&w=majority";
	
	    try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase db = mongoClient.getDatabase("NavesSofka");
	        MongoCollection<Document> dbCollection = db.getCollection("NavesSofka");   
	        Document document = new Document();
	        document.append("nombre", nombre);
	        document.append("edad", 520);
	        db.getCollection("NavesSofka").insertOne(document);
	    }
	}
}
