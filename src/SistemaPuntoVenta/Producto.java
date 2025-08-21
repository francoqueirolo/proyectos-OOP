package SistemaPuntoVenta;

public class Producto implements IProducto{

    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private String codigo;

    public Producto() {}

    public Producto(String nombre, double precio, int stock, String categoria, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.codigo = codigo;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void mostrarInfo() {
        System.out.printf("%-15s %-10s $%-8.2f Stock: %-5d Categoría: %s%n",
                nombre, codigo, precio, stock, categoria);
    }
}
