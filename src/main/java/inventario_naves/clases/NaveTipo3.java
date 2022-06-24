package inventario_naves.clases;

import inventario_naves.utils.Lanzar;

public class NaveTipo3 extends Naves implements Lanzar {

    public NaveTipo3(String tipo_nave, String subtipo_nave, String pais, String nombre_nave, int fecha_creacion, int anio_ultima_actividad) {
        super(tipo_nave, subtipo_nave, pais, nombre_nave, fecha_creacion, anio_ultima_actividad);
        mensajeNaveCreada();
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
    void mensajeNaveCreada() {
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
