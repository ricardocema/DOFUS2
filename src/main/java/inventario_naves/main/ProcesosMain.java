package inventario_naves.main;

import inventario_naves.clases.*;
import inventario_naves.utils.Lanzar;

import java.util.Objects;
import java.util.Scanner;

public class ProcesosMain {

    public void moduloNaves(Usuario usuario) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Desea buscar naves o crear una nueva nave?\nElija 1 para Crear\nElija 0 para Buscar");

        while (!entrada.hasNext("[01]")) {
            System.out.println("Por favor elija entre 0 y 1");
            entrada.next();
        }

        if (entrada.hasNext("1")) {
            System.out.println("Muy bien, a continuacion se le solicitara la informacion para crear su nave");
            creacionDeNave();
        } else {
            System.out.println("Falta seguir esta");
        }

    }

    public void creacionDeNave() {
        Naves naves = null;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el tipo de nave que deseas crear: 1) Vehiculo lanzadera, 2) Nave no tripulada, 3) Nave tripulada");
        while (!entrada.hasNext("[123]")) {
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
    }

    public void crearUsuario() {
        Usuario usuario = new Usuario();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Por favor escriba su nombre:");
        usuario.setNombre(entrada.next());

        System.out.println("Por favor digite su cedula sin puntos ni comas:");
        usuario.setCedula(entrada.next());

        usuario.crearEnBD();
    }

    public Usuario iniciarSesionUsuario() {
        Usuario usuario = new Usuario();
        Scanner entrada = new Scanner(System.in);

        usuario.buscarEnBD(entrada.next());
        System.out.println("Bienvenido señor(a) " + usuario.getNombre());

        return usuario;
    }
}
