package SistemaBiblioteca;

public enum EstadoItem {
    DISPONIBLE("Disponible para prestamo", "1"),
    PRESTADO("Actualmente prestado","2"),
    RESERVADO("Reservado para otro usuario", "3"),
    REPARACION("En reparacion", "4");

    private final String descripcion;
    private final String codigo;

    EstadoItem(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigo() {
        return codigo;
    }
}
