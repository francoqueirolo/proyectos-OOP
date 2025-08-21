package SistemaPuntoVenta;

// Interface que define el contrato para operaciones de productos
public interface IProducto {
    String getNombre();
    double getPrecio();
    int getStock();
    void setStock(int stock);
    String getCategoria();
}
