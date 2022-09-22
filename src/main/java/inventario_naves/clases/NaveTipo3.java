package inventario_naves.clases;

import inventario_naves.utils.Lanzar;

public class NaveTipo3 extends Naves implements Lanzar {

  private static final String TIPO = "Nave tripulada";

  public NaveTipo3() {
    super.setTipo_nave(TIPO);
  }

  public NaveTipo3(String subtipo_nave, String pais, String nombre_nave, int fecha_creacion,
      int anio_ultima_actividad) {
    super(subtipo_nave, pais, nombre_nave, fecha_creacion, anio_ultima_actividad);
    super.setTipo_nave(TIPO);
  }

  public int tiempo_creacion() {
    return getAnio_actual() - getFecha_creacion();
  }

  @Override
  public boolean funciona() {
    return getFecha_creacion() >= 1995;
  }

  @Override
  public boolean reutilizable() {
    return getAnio_ultima_actividad() >= 1999;
  }

  @Override
  public void mensajeNaveCreada() {
    System.out.println("Se ha creado una nave tripulada");
  }

  /**
   * Aqui sobre una de override
   */
  @Override
  public void tipo_carga() {
    System.out.println("Se ha lanzado una persona al espacio");
  }
}
