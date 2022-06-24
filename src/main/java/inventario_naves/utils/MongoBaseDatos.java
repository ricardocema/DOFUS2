package inventario_naves.utils;

import com.mongodb.Function;
import com.mongodb.MongoException;
import com.mongodb.MongoQueryException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static inventario_naves.utils.ColeccionesMongo.USUARIOS;


public class MongoBaseDatos {

    private static final String URI_MONGO = "mongodb+srv://hansee:proyectos@proyectos.zugzk.mongodb.net/?retryWrites=true&w=majority";

    static {
//        loggerOff();
    }

    private MongoBaseDatos() {
    }

    private static void loggerOff() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
    }

    public static void accionInsertUnoBD(ColeccionesMongo coleccion, Consumer<MongoCollection<Document>> accion) {

        try (MongoClient mongoClient = MongoClients.create(URI_MONGO)) {
            MongoDatabase bd = mongoClient.getDatabase("SofkaNaves");
            MongoCollection<Document> bdCollection = bd.getCollection(coleccion.toString());
//            bdCollection.createIndex(new BasicDBObject("Cedula",1), new IndexOptions().unique(true));

            accion.accept(bdCollection);
        } catch (MongoWriteException writeException) {
            if (coleccion.equals(USUARIOS)) {
                System.out.println("Error usuario existente\n\n" + writeException);
            } else {
                System.out.println("Error insertando documento en la \n\n" + writeException);
            }
        } catch (MongoQueryException queryException) {
            System.out.println("Error realizando la query a la bd\n\n" + queryException);
        } catch (MongoException e) {
            System.out.println("Error con la base de datos\n\n" + e);
        }
    }

    public static Document accionBuscarUnoBD(ColeccionesMongo coleccion, Function<MongoCollection<Document>, Document> accion) {
        Document respuesta = new Document();
        try (MongoClient mongoClient = MongoClients.create(URI_MONGO)) {
            MongoDatabase bd = mongoClient.getDatabase("SofkaNaves");
            MongoCollection<Document> bdCollection = bd.getCollection(coleccion.toString());
//            bdCollection.createIndex(new BasicDBObject("Cedula",1), new IndexOptions().unique(true));

            respuesta = accion.apply(bdCollection);
        } catch (MongoQueryException queryException) {
            System.out.println("Error realizando la query a la bd\n\n" + queryException);
        } catch (MongoException e) {
            System.out.println("Error con la base de datos\n\n" + e);
        }
        return respuesta;
    }

    public static MongoCursor<Document> accionBuscarVariosBD(ColeccionesMongo coleccion, Function<MongoCollection<Document>, MongoCursor<Document>> accion) {
        MongoCursor<Document> respuesta = null;
        try (MongoClient mongoClient = MongoClients.create(URI_MONGO)) {
            MongoDatabase bd = mongoClient.getDatabase("SofkaNaves");
            MongoCollection<Document> bdCollection = bd.getCollection(coleccion.toString());

            respuesta = accion.apply(bdCollection);
        } catch (MongoQueryException queryException) {
            System.out.println("Error realizando la query a la bd\n\n" + queryException);
        } catch (MongoException e) {
            System.out.println("Error con la base de datos\n\n" + e);
        }
        return respuesta;
    }
}

