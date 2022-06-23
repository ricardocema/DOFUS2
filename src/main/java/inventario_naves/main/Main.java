package inventario_naves.main;

import com.mongodb.client.MongoDatabase;
import inventario_naves.clases.NaveTipo1;
import inventario_naves.clases.NaveTipo2;
import inventario_naves.clases.NaveTipo3;
import inventario_naves.clases.Naves;
import inventario_naves.utils.Lanzar;

import java.util.Objects;
import java.util.Scanner;

import static inventario_naves.utils.MongoBaseDatos.conectarBD;

public class Main {

    private int seleccion_tipo_nave;
    private final MongoDatabase baseDatos = conectarBD();

    public static void main(String[] args) {
        Naves naves = null;
        Scanner entrada = new Scanner(System.in);

        while (true) {

            System.out.println("Introduce el tipo de nave que deseas crear: 1) Vehiculo lanzadera, 2) Nave no tripulada, 3) Nave tripulada");
            while (!entrada.hasNext("1|2|3")) {
                System.out.println("Por favor elija entre 1,2 y 3");
                entrada.next();
            }
            int numero_seleccion = entrada.nextInt();

            System.out.println("Introduce el subtipo de nave: ");
            String subtipo = entrada.next();

            System.out.println("Introduce el pais de la nave: ");
            String pais = entrada.next();

            System.out.println("Introduce el nombre de la nave: ");
            String nombre_nave = entrada.next();

            System.out.println("Introduce el año de creacion de la nave: ");
            int fecha_creacion = entrada.nextInt();

            System.out.println("Introduce el año de la ultima actividad de la nave: ");
            int ultima_actividad = entrada.nextInt();

            switch (numero_seleccion) {
                case 1:
                    naves = new NaveTipo1("vehiculo_lanzadera", subtipo, pais, nombre_nave, fecha_creacion, ultima_actividad);
                    break;

                case 2:
                    naves = new NaveTipo2("nave no tripulada", subtipo, pais, nombre_nave, fecha_creacion, ultima_actividad);
                    break;

                case 3:
                    naves = new NaveTipo3("vehiculo_lanzadera", subtipo, pais, nombre_nave, fecha_creacion, ultima_actividad);
                    break;
                    
                default:
                    System.out.println("Hubo un error reconociendo el tipo de nave");
            }

            ((Lanzar) Objects.requireNonNull(naves)).tipo_carga();

            System.out.println("Si deseas salir del programa escriba 'exit', de lo contrario ingresa cualquier otro numero");

            if (entrada.hasNext("exit|Exit|EXIT")) {
                return;
            }
        }
    }
}
