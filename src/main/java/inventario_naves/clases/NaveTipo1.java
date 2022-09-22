package inventario_naves.clases;

import inventario_naves.utils.Lanzar;

public class NaveTipo1 extends Naves implements Lanzar {

  private static final String TIPO = "Vehiculo lanzadera";

  public NaveTipo1() {
    super.setTipo_nave(TIPO);
  }

  public NaveTipo1(String subtipo_nave, String pais, String nombre_nave, int fecha_creacion,
      int anio_ultima_actividad) {
    super(subtipo_nave, pais, nombre_nave, fecha_creacion, anio_ultima_actividad);
    super.setTipo_nave(TIPO);
  }

  public int tiempo_creacion() {
    return getAnio_actual() - getFecha_creacion();
  }

  @Override
  boolean funciona() {
    return getFecha_creacion() >= 2000;
  }

  @Override
  boolean reutilizable() {
    return getAnio_ultima_actividad() >= 2005;
  }

  @Override
  public void mensajeNaveCreada() {
    System.out.println("Se ha creado un vehiculo de lanzadera");
  }

  @Override
  public void tipo_carga() {
    System.out.println("se ha lanzado una sonda");
  }
}
