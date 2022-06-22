
package inventario_naves.clases;

public abstract class Naves {
    /**
     * Metodo que hace que funcione la nave o no se
     * @return Falso || Verdadero
     */
    abstract boolean funciona();

    /**
     * Metodo para descubrir si la nave no va a la basura
     * @return Falso || Verdadero
     */
    abstract boolean reutilizable();


    private String tipo_nave;
    private String subtipo_nave;
    private String pais;
    private String nombre_nave;
    private int fecha_creacion;
    private int anio_ultima_actividad;
    private final int anio_actual = 2022;

    public Naves(String tipo_nave, String subtipo_nave, String pais, String nombre_nave, int fecha_creacion, int anio_ultima_actividad) {
        this.tipo_nave = tipo_nave;
        this.subtipo_nave = subtipo_nave;
        this.pais = pais;
        this.nombre_nave = nombre_nave;
        this.fecha_creacion = fecha_creacion;
        this.anio_ultima_actividad = anio_ultima_actividad;
    }

    public int getAnio_actual() {
        return anio_actual;
    }

    public String getTipo_nave() {
        return tipo_nave;
    }

    public void setTipo_nave(String tipo_nave) {
        this.tipo_nave = tipo_nave;
    }

    public String getSubtipo_nave() {
        return subtipo_nave;
    }

    public void setSubtipo_nave(String subtipo_nave) {
        this.subtipo_nave = subtipo_nave;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre_nave() {
        return nombre_nave;
    }

    public void setNombre_nave(String nombre_nave) {
        this.nombre_nave = nombre_nave;
    }

    public int getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(int fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getAnio_ultima_actividad() {
        return anio_ultima_actividad;
    }

    public void setAnio_ultima_actividad(int anio_ultima_actividad) {
        this.anio_ultima_actividad = anio_ultima_actividad;
    }

}


