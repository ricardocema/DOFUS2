package inventario_naves.main;

import inventario_naves.clases.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int seleccion_tipo_nave;
        ProcesosMain proceso = new ProcesosMain();

        Scanner entrada = new Scanner(System.in);

        while (true) {

            System.out.println("Bienvenido Usuario");
            System.out.println("¿Desea inicar sesion?\nElija 1 para Si\nElija 0 para No");
            String res = entrada.next();

            if (res.equals("1")) {
                System.out.println("Muy bien, por favor introduzca su cedula para validar:");
                Usuario sesionUsuario = proceso.iniciarSesionUsuario();
                proceso.moduloNaves(sesionUsuario);
//                break;

            } else if (res.equals("0")) {
                System.out.println("De acuerdo, procedere a registrarlo en el sistema, introduzca la informacion que se le solicta:");
                proceso.crearUsuario();
                break;

            } else {
                System.out.println("No selecciono ninguna de las opciones propuestas");
            }

            System.out.println("Si deseas salir del programa escriba 'exit', de lo contrario ingresa cualquier otro valor");
            if (entrada.hasNext("exit|Exit|EXIT")) {
                break;
            }
            entrada.next();
        }

    }
}
