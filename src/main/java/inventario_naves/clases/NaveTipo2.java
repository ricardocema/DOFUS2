package inventario_naves.clases;

import inventario_naves.utils.Lanzar;

public class NaveTipo2 extends Naves implements Lanzar {

  private static final String TIPO = "Nave no tripulada";

  public NaveTipo2() {
    super.setTipo_nave(TIPO);
  }

  public NaveTipo2(String subtipo_nave, String pais, String nombre_nave, int fecha_creacion,
      int anio_ultima_actividad) {
    super(subtipo_nave, pais, nombre_nave, fecha_creacion, anio_ultima_actividad);
    super.setTipo_nave(TIPO);
  }


  public int tiempo_creacion() {
    return getAnio_actual() - getFecha_creacion();
  }

  @Override
  public boolean funciona() {
    return getFecha_creacion() >= 2010;
  }

  @Override
  public boolean reutilizable() {
    return getAnio_ultima_actividad() >= 2016;
  }

  @Override
  public void mensajeNaveCreada() {
    System.out.println("Se ha creado una nave no tripulada");
  }

  @Override
  public void tipo_carga() {
    System.out.println("Se ha lanzado un satelite");
  }
}
