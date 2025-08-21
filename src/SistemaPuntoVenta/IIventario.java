package SistemaPuntoVenta;

public interface IIventario {
    void agregarProducto(Producto producto);
    boolean buscarProducto(String nombre);
    Producto obtenerProducto(String nombre);
    void mostrarInventario();
}
