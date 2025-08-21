package SistemaPuntoVenta;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario implements IIventario{
    private Map<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        Producto producto1 = new Producto("Coca Cola", 2.50, 50, "Bebidas", "CC001");
        agregarProducto(producto1);
        agregarProducto(new Producto("Pan Integral", 1.75, 30, "Panadería", "PI002"));
        agregarProducto(new Producto("Leche Entera", 3.20, 25, "Lácteos", "LE003"));
        agregarProducto(new Producto("Manzanas", 4.50, 40, "Frutas", "MZ004"));
        agregarProducto(new Producto("Arroz 1kg", 2.80, 60, "Granos", "AR005"));
        agregarProducto(new Producto("Pollo Entero", 8.90, 15, "Carnes", "PE006"));
        agregarProducto(new Producto("Detergente", 5.25, 20, "Limpieza", "DT007"));
    }

    @Override
    public void agregarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    @Override
    public boolean buscarProducto(String nombre) {
        return productos.containsKey(nombre);
    }

    @Override
    public Producto obtenerProducto(String nombre) {
        return productos.get(nombre);
    }

    @Override
    public void mostrarInventario() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                    INVENTARIO DE PRODUCTOS");
        System.out.println("=".repeat(70));
        System.out.printf("%-15s %-10s %-10s %-8s %-12s%n",
                "PRODUCTO", "CÓDIGO", "PRECIO", "STOCK", "CATEGORÍA");
        System.out.println("-".repeat(70));

        productos.values().stream()
                .sorted((p1, p2) -> p1.getCategoria().compareTo(p2.getCategoria()))
                .forEach(Producto::mostrarInfo);

        System.out.println("=".repeat(70));
    }

    public Collection<Producto> productos(){
        return productos.values();
    }
}
