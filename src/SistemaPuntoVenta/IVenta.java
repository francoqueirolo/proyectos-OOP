package SistemaPuntoVenta;

public interface IVenta {
    void agregarProducto(Producto producto, int cantidad);
    double calcularTotal();
    void mostrarDetalles();
}
