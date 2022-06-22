

package inventario_naves.main;


import com.mongodb.client.MongoDatabase;
import inventario_naves.clases.NaveTipo1;
import inventario_naves.clases.NaveTipo2;
import inventario_naves.clases.NaveTipo3;

import java.util.Scanner;

import static inventario_naves.utils.MongoBaseDatos.conectarBD;

public class Main {

    private int seleccion_tipo_nave;
    private final MongoDatabase baseDatos = conectarBD();

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        while (true) {

            System.out.println("Introduce el tipo de nave que deseas crear: 1) Vehiculo lanzadera, 2) Nave no tripulada, 3) Nave tripulada");
            int numero_seleccion = entrada.nextInt();

            System.out.println("introduce el subtipo de nave: ");
            String subtipo = entrada.next();

            System.out.println("introduce el pais de la nave: ");
            String pais = entrada.next();

            System.out.println("introduce el nombre de la nave: ");
            String nombre_nave = entrada.next();

            System.out.println("introduce el año de creacion de la nave: ");
            int fecha_creacion = entrada.nextInt();

            System.out.println("introduce el año de la ultima actividad de la nave: ");
            int ultima_actividad = entrada.nextInt();

            switch (numero_seleccion) {
                case 1:
                    NaveTipo1 naveTipo1 = new NaveTipo1("vehiculo_lanzadera", subtipo, pais, nombre_nave, fecha_creacion, ultima_actividad);
                    naveTipo1.tipo_carga();
                    System.out.println("Se ha creado un vehiculo de lanzadera");
                    naveTipo1.tipo_carga();
                    break;

                case 2:
                    NaveTipo2 naveTipo2 = new NaveTipo2("nave no tripulada", subtipo, pais, nombre_nave, fecha_creacion, ultima_actividad);
                    System.out.println("Se ha creado una nave no tripulada");
                    naveTipo2.tipo_carga();
                    break;

                case 3:
                    NaveTipo3 naveTipo3 = new NaveTipo3("vehiculo_lanzadera", subtipo, pais, nombre_nave, fecha_creacion, ultima_actividad);
                    System.out.println("Se ha creado una nave tripulada");
                    naveTipo3.tipo_carga();
                    break;
            }

            System.out.println("Si deseas salir del programa ingresa un 0, de lo contrario ingresa cualquier otro numero");

            int respuesta = entrada.nextInt();
            if (respuesta == 0) {
                break;
            }
        }


    }
}
