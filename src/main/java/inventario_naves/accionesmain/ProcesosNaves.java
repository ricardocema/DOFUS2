package inventario_naves.accionesmain;

import inventario_naves.clases.NaveTipo1;
import inventario_naves.clases.NaveTipo2;
import inventario_naves.clases.NaveTipo3;
import inventario_naves.clases.Naves;
import inventario_naves.clases.Usuario;
import inventario_naves.utils.Lanzar;
import java.util.Objects;
import java.util.Scanner;

public class ProcesosNaves {

  public void moduloNaves(Usuario usuario) {
    Scanner entrada = new Scanner(System.in);

    System.out.println(
        "¿Desea buscar naves o crear una nueva nave?\nElija 1 para Crear\nElija 0 para Buscar");

    while (!entrada.hasNext("[01]")) {
      System.out.println("Por favor elija entre 0 y 1");
      entrada.next();
    }

    if (entrada.hasNext("1")) {
      System.out.println(
          "Muy bien, a continuacion se le solicitara la informacion para crear su nave");
      creacionDeNave();
    } else {
      System.out.println("Falta seguir esta");
    }

  }

  public void creacionDeNave() {
    Scanner entrada = new Scanner(System.in);

    System.out.println(
        "Introduce el tipo de nave que deseas crear: 1) Vehiculo lanzadera, 2) Nave no tripulada, 3) Nave tripulada");
    while (!entrada.hasNext("[123]")) {
      System.out.println("Por favor elija entre 1,2 y 3");
      entrada.next();
    }
    int tipoNave = entrada.nextInt();
    Naves nave = crearInstanciaNave(tipoNave);

    System.out.println("Introduce el subtipo de nave: ");
    nave.setSubtipo_nave(entrada.next());

    System.out.println("Introduce el pais de la nave: ");
    nave.setPais(entrada.next());

    System.out.println("Introduce el nombre de la nave: ");
    nave.setNombre_nave(entrada.next());

    System.out.println("Introduce el año de creacion de la nave: ");
    nave.setFecha_creacion(entrada.nextInt());

    System.out.println("Introduce el año de la ultima actividad de la nave: ");
    nave.setAnio_ultima_actividad(entrada.nextInt());

    nave.mensajeNaveCreada();

    ((Lanzar) Objects.requireNonNull(nave)).tipo_carga();
  }

  private Naves crearInstanciaNave(int numeroSeleccionado) {
    Naves nave;
    switch (numeroSeleccionado) {
      case 1:
        nave = new NaveTipo1();
        break;

      case 2:
        nave = new NaveTipo2();
        break;

      case 3:
        nave = new NaveTipo3();
        break;

      default:
        System.out.println("Hubo un error reconociendo el tipo de nave");
        return null;
    }

    return nave;
  }

}
