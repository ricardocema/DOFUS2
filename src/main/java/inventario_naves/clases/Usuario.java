package inventario_naves.clases;

import com.mongodb.Function;
import com.mongodb.client.MongoCollection;
import inventario_naves.utils.MetodosMongo;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;
import static inventario_naves.utils.ColeccionesMongo.USUARIOS;
import static inventario_naves.utils.MongoBaseDatos.accionBuscarUnoBD;
import static inventario_naves.utils.MongoBaseDatos.accionInsertUnoBD;
import static inventario_naves.utils.esquemasbd.UsuariosBd.Cedula;
import static inventario_naves.utils.esquemasbd.UsuariosBd.Nombre;

public class Usuario implements MetodosMongo {
    private String nombre;
    private String cedula;

    public Usuario() {
    }

    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public void buscarEnBD(String bCedula) {
        Function<MongoCollection<Document>, Document> buscar = documentMongoCollection ->
                Objects.requireNonNull(documentMongoCollection
                        .find(eq(Cedula.toString(), bCedula)).first());

        Document resultado = accionBuscarUnoBD(USUARIOS, buscar);

        setNombre(resultado.getString(Nombre.toString()));
        setCedula(resultado.getString(Cedula.toString()));
    }

    @Override
    public void crearEnBD() {
        Consumer<MongoCollection<Document>> crear = documentMongoCollection ->
                documentMongoCollection
                        .insertOne(new Document()
                                .append("_id", new ObjectId())
                                .append(Cedula.toString(), cedula)
                                .append(Nombre.toString(), nombre)
                        );

        accionInsertUnoBD(USUARIOS, crear);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
