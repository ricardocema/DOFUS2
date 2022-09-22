package inventario_naves.utils.esquemasbd;

public enum NavesBd {
    ID_NAVE("_id"),
    TIPO_NAVE("TipoNave"),
    SUB_TIPO_NAVE("SubTipoNave"),
    PAIS("Pais"),
    NOMBRE_NAVE("NombreNave"),
    FECHA_CREACION("FechaCreacion"),
    ULTIMA_ACTIVIDAD("AnioUltimaActividad");

    private final String value;

    NavesBd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
