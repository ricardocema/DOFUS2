package inventario_naves.clases;

import inventario_naves.utils.Lanzar;

public class NaveTipo1 extends Naves implements Lanzar {

    public NaveTipo1(String tipo_nave, String subtipo_nave, String pais, String nombre_nave, int fecha_creacion, int anio_ultima_actividad) {
        super(tipo_nave, subtipo_nave, pais, nombre_nave, fecha_creacion, anio_ultima_actividad);
    }

    public int tiempo_creacion() {
        return getAnio_actual() - getFecha_creacion();
    }

    public boolean funciona() {
        return getFecha_creacion() >= 2000;
    }

    public boolean reutilizable() {
        return getAnio_ultima_actividad() >= 2005;
    }
    @Override
    public void tipo_carga() {
        System.out.println("se ha lanzado una sonda");
    }
}
