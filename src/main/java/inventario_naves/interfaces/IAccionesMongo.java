package inventario_naves.interfaces;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import inventario_naves.utils.ColeccionesMongo;
import org.bson.Document;

public interface IAccionesMongo {

  String URI_MONGO = "mongodb+srv://hansee:proyectos@propio.gy4t22f.mongodb.net/?retryWrites=true&w=majority";
  String DATABASE_NAME = "SofkaNaves";

  /*
  * Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
  * */

  default void insertarUnoEnBD(ColeccionesMongo coleccion, Document document) {
    try (MongoClient mongoClient = MongoClients.create(URI_MONGO)) {
      MongoDatabase bd = mongoClient.getDatabase(DATABASE_NAME);
      MongoCollection<Document> bdCollection = bd.getCollection(coleccion.toString());

      bdCollection.insertOne(document);
    }
  }

  default Document buscarUnoEnBD(ColeccionesMongo coleccion, Document document) {
    try (MongoClient mongoClient = MongoClients.create(URI_MONGO)) {
      MongoDatabase bd = mongoClient.getDatabase(DATABASE_NAME);
      MongoCollection<Document> bdCollection = bd.getCollection(coleccion.toString());

      return bdCollection.find(document).first();
    }
  }

}
