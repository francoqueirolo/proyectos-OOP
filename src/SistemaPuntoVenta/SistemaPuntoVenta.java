package SistemaPuntoVenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPuntoVenta {

    private Inventario inventario;
    private Scanner scanner;
    private List<Venta> ventasRealizadas; // COMPOSICIÓN: Sistema contiene lista de ventas

    // CONSTRUCTOR
    public SistemaPuntoVenta() {
        this.inventario = new Inventario();
        this.scanner = new Scanner(System.in);
        this.ventasRealizadas = new ArrayList<>();
    }

    // ENCAPSULACIÓN: Metodo público que inicia el sistema
    public void iniciar() {
        mostrarBienvenida();

        // CONTROL DE FLUJO: Menú interactivo con while
        int opcion = 0;
        while (opcion != 6) {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Me asegura que yo ingrese un entero

                switch (opcion) {
                    case 1 -> procesarVenta();
                    case 2 -> inventario.mostrarInventario();
                    case 3 -> buscarProducto();
                    case 4 -> agregarProducto();
                    case 5 -> mostrarReporteVentas();
                    case 6 -> {
                        System.out.println("\n🙏 ¡Gracias por usar el Sistema de Punto de Venta!");
                        System.out.println("¡Hasta pronto!");
                    }
                    default -> System.out.println("❌ Opción inválida. Por favor seleccione del 1 al 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor ingrese un número válido.");
            }

            if (opcion != 6) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    // ENCAPSULACIÓN: Métodos privados para organizar la funcionalidad
    private void mostrarBienvenida() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    🛒 BIENVENIDO AL SISTEMA DE PUNTO DE VENTA 🛒");
        System.out.println("=".repeat(60));
    }

    private void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  MENÚ PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. 💳 Procesar Venta");
        System.out.println("2. 📦 Ver Inventario");
        System.out.println("3. 🔍 Buscar Producto");
        System.out.println("4. ➕ Agregar Producto");
        System.out.println("5. 📊 Reporte de Ventas");
        System.out.println("6. 🚪 Salir");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione una opción (1-6): ");
    }

    // POLIMORFISMO: Metodo que utiliza las interfaces IVenta e IInventario
    private void procesarVenta() {
        Venta venta = new Venta(); // INSTANCIACIÓN: Crear objeto de la clase Venta
        boolean continuarVenta = true;

        System.out.println("\n🛍️  PROCESANDO NUEVA VENTA");
        System.out.println("(Escriba 'fin' para terminar la venta)");

        while (continuarVenta) {
            System.out.print("\nIngrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim();

            if (nombreProducto.equalsIgnoreCase("fin")) {
                continuarVenta = false;
                continue;
            }

            // POLIMORFISMO: Usando métodos de la interface IInventario
            if (inventario.buscarProducto(nombreProducto)) {
                Producto producto = inventario.obtenerProducto(nombreProducto);

                System.out.println("✓ Producto encontrado: " + producto.toString());
                System.out.print("Ingrese la cantidad: ");

                try {
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    if (cantidad > 0) {
                        // POLIMORFISMO: Usando método de la interface IVenta
                        venta.agregarProducto(producto, cantidad);
                    } else {
                        System.out.println("❌ La cantidad debe ser mayor a 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Cantidad inválida");
                }
            } else {
                System.out.println("❌ Producto no encontrado");
            }
        }

        // Finalizar venta
        if (venta.tieneProductos()) {
            venta.mostrarDetalles();
            ventasRealizadas.add(venta); // COMPOSICIÓN: Agregar venta al sistema
            System.out.println("\n✅ Venta procesada exitosamente!");
        } else {
            System.out.println("\n❌ No se agregaron productos a la venta");
        }
    }

    private void buscarProducto() {
        System.out.print("\n🔍 Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine().trim();

        if (inventario.buscarProducto(nombre)) {
            Producto producto = inventario.obtenerProducto(nombre);
            System.out.println("\n✓ Producto encontrado:");
            System.out.println("-".repeat(40));
            producto.mostrarInfo();
        } else {
            System.out.println("❌ Producto no encontrado");
        }
    }

    // ENCAPSULACIÓN: Método para agregar nuevos productos
    private void agregarProducto() {
        System.out.println("\n➕ AGREGAR NUEVO PRODUCTO");
        System.out.println("-".repeat(30));

        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Precio: $");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Stock inicial: ");
            int stock = Integer.parseInt(scanner.nextLine());

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Código: ");
            String codigo = scanner.nextLine().trim();

            // INSTANCIACIÓN: Crear nuevo producto
            Producto nuevoProducto = new Producto(nombre, precio, stock, categoria, codigo);
            inventario.agregarProducto(nuevoProducto);

            System.out.println("✅ Producto agregado exitosamente!");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Verifique que precio y stock sean números válidos");
        }
    }

    private void mostrarReporteVentas() {
        System.out.println("\n📊 REPORTE DE VENTAS");
        System.out.println("=".repeat(50));

        if (ventasRealizadas.isEmpty()) {
            System.out.println("No se han realizado ventas aún.");
            return;
        }

        double totalVentas = 0;
        System.out.println("Total de ventas realizadas: " + ventasRealizadas.size());
        System.out.println("-".repeat(30));

        for (int i = 0; i < ventasRealizadas.size(); i++) {
            Venta venta = ventasRealizadas.get(i);
            double totalVenta = venta.calcularTotal();
            totalVentas += totalVenta;
            System.out.printf("Venta #%d: $%.2f%n", (i + 1), totalVenta);
        }

        System.out.println("-".repeat(30));
        System.out.printf("TOTAL GENERAL: $%.2f%n", totalVentas);
        System.out.printf("PROMEDIO POR VENTA: $%.2f%n",
                ventasRealizadas.isEmpty() ? 0 : totalVentas / ventasRealizadas.size());
    }

    public static void main(String[] args) {
        SistemaPuntoVenta sistema = new SistemaPuntoVenta();
        // ABSTRACCIÓN: Llamar al metodo que maneja toda la lógica
        sistema.iniciar();
    }
}
