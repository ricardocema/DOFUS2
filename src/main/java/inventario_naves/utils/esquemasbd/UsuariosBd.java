package inventario_naves.utils.esquemasbd;

public enum UsuariosBd {
    ID_USUARIO("_id"),
    NOMBRE_USUARIO("Nombre"),
    CEDULA("Cedula");

    private final String value;

    UsuariosBd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
