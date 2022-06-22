package inventario_naves.utils;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoBaseDatos {

    private static final String URI_MONGO = "mongodb+srv://hansee:<password>@proyectos.zugzk.mongodb.net/?retryWrites=true&w=majority";

    private MongoBaseDatos() {
    }

    public static MongoDatabase conectarBD() {
        MongoDatabase bd = null;

        try (MongoClient mongoClient = MongoClients.create(URI_MONGO)) {
            bd = mongoClient.getDatabase("BD_Proyectos");
            MongoCollection<Document> bdCollection = bd.getCollection("usuarios");
        } catch (MongoException e) {
            System.out.println("Error conectando a la base de datos\n\n" + e);
        }

        return bd;
    }
}

