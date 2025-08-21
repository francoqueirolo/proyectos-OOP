package SistemaPuntoVenta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venta implements IVenta{
    private List<DetalleVenta> detalles;
    private LocalDateTime fecha;
    private int numeroVenta;
    private static int contadorVentas = 1;

    public Venta() {
        this.detalles = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.numeroVenta = contadorVentas++;
    }

    @Override
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            DetalleVenta detalle = new DetalleVenta(producto, cantidad);
            detalles.add(detalle);
            // Actualizar el stock del producto
            producto.setStock(producto.getStock() - cantidad);
        } else {
            System.out.println("❌ Stock insuficiente. Stock disponible: " + producto.getStock());
        }
    }

    @Override
    public double calcularTotal() {
        return detalles
                .stream()
                .mapToDouble(DetalleVenta::getSubtotal)
                .sum();
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              TICKET DE VENTA #" + numeroVenta);
        System.out.println("=".repeat(60));
        System.out.println("Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("-".repeat(60));

        for (DetalleVenta detalle : detalles) {
            detalle.mostrarDetalle();
        }

        System.out.println("-".repeat(60));
        System.out.printf("TOTAL: $%.2f%n", calcularTotal());
        System.out.println("=".repeat(60));
    }

    public boolean tieneProductos() {
        return !detalles.isEmpty();
    }
}
