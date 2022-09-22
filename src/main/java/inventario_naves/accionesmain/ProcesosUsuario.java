package inventario_naves.accionesmain;

import static inventario_naves.utils.ColeccionesMongo.USUARIOS;
import static inventario_naves.utils.esquemasbd.UsuariosBd.CEDULA;
import static inventario_naves.utils.esquemasbd.UsuariosBd.ID_USUARIO;
import static inventario_naves.utils.esquemasbd.UsuariosBd.NOMBRE_USUARIO;

import com.mongodb.MongoException;
import inventario_naves.clases.Usuario;
import inventario_naves.interfaces.IAccionesMongo;
import inventario_naves.utils.ColeccionesMongo;
import java.util.Scanner;
import org.bson.Document;
import org.bson.types.ObjectId;

public class ProcesosUsuario implements IAccionesMongo {

    private static final ColeccionesMongo coleccionUsuario = USUARIOS;
    public void crearUsuario() {
        Usuario usuario = new Usuario();

        guardarDatosUsuarios(usuario);

        try {
            accionRegistarUsuario(usuario.getCedula(), usuario.getNombre());
            System.out.printf("Felicidades %s, ahora ya pueda crear naves !!!%nPor favor inicie sesion para poder hacerlo%n", usuario.getNombre());
        } catch (MongoException writeException) {
            System.out.println("Error usuario existente\n");
        }

    }

    public void iniciarSesion() {
        ProcesosUsuario procesosUsuario = new ProcesosUsuario();
        ProcesosNaves proceso = new ProcesosNaves();

        System.out.println("Muy bien, por favor introduzca su cedula para validar:");
        Usuario sesionUsuario = procesosUsuario.encontrarUsuario();

        if (sesionUsuario == null) {
            return;
        }
        System.out.println("Bienvenido señor(a) " + sesionUsuario.getNombre());

        proceso.moduloNaves(sesionUsuario);
    }

    public Usuario encontrarUsuario() {

        Document resultado = verificarCuentaUsuario();

        return resultado.isEmpty() ? null
                :
                new Usuario(resultado.get(ID_USUARIO.getValue()),
                        resultado.getString(NOMBRE_USUARIO.getValue()),
                        resultado.getString(CEDULA.getValue())
                );
    }

    private void guardarDatosUsuarios(Usuario usuario) {
        Scanner entrada = new Scanner(System.in);
        String cedula;

        System.out.println("Por favor escriba su nombre:");
        usuario.setNombre(entrada.next());

        System.out.println("Por favor digite su cedula sin puntos ni comas:");
        cedula = entrada.next();

        while (cedula.length() < 6 || !cedula.matches("[0-9]+")) {
            System.out.println("Por favor digite una cedula valida");
            cedula = entrada.next();
        }
        usuario.setCedula(cedula);
    }

    private Document verificarCuentaUsuario() {
        Scanner entrada = new Scanner(System.in);
        String ingresado = entrada.next();

        if (ingresado.equals("0")) {
            return new Document();
        }

        Document resultadoBusqueda = accionBusquedaUsuario(ingresado);

        if (resultadoBusqueda == null) {
            System.out.println("No existe usuario asociado a la cedula.\nPor favor digite nuevamente su cedula o digite '0' para salir del proceso.");
            return verificarCuentaUsuario();
        }

        return resultadoBusqueda;
    }

    private Document accionBusquedaUsuario(String cedula) {
        Document usuario = new Document();

        usuario.append(CEDULA.getValue(), cedula);

        return buscarUnoEnBD(coleccionUsuario,usuario);
    }

    private void accionRegistarUsuario(String cedula, String nombre) {
        Document usuario = new Document();

        usuario.append(ID_USUARIO.getValue(), new ObjectId())
            .append(CEDULA.getValue(), cedula)
            .append(NOMBRE_USUARIO.getValue(), nombre);

        insertarUnoEnBD(coleccionUsuario,usuario);
    }
}
