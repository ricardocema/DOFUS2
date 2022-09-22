package inventario_naves.utils;

public enum ColeccionesMongo {
    NAVES("NAVES"),
    USUARIOS("USUARIOS");

    private final String value;

    ColeccionesMongo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
