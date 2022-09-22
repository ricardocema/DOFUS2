package inventario_naves;

import inventario_naves.accionesmain.ProcesosNaves;
import inventario_naves.accionesmain.ProcesosUsuario;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int seleccion_tipo_nave;

        ProcesosUsuario procesosUsuario = new ProcesosUsuario();

        Scanner entrada = new Scanner(System.in);

        while (true) {

            System.out.println("Bienvenido Usuario");
            System.out.println("¿Desea inicar sesion?\nElija 1 para Si\nElija 0 para No");
            String res = entrada.next();

            if (res.equals("1")) {
                procesosUsuario.iniciarSesion();

            } else if (res.equals("0")) {
                System.out.println("De acuerdo, procedere a registrarlo en el sistema, introduzca la informacion que se le solicta:");
                procesosUsuario.crearUsuario();
//                break;

            } else {
                System.out.println("No selecciono ninguna de las opciones propuestas");
            }

            System.out.println("Si deseas salir del programa escriba 'exit', de lo contrario ingresa cualquier otro valor");
            if (entrada.next().toLowerCase(Locale.ROOT).equals("exit")) {
                break;
            }
        }

    }
}
