package SistemaBiblioteca;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private String nombre;
    private Map<String, ItemBiblioteca> catalogo;
    private Map<String, Usuario> usuarios;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.catalogo = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void agregarItem(ItemBiblioteca item) {
        catalogo.put(item.getCodigo(), item);
        System.out.println("➕ Item agregado al catálogo: " + item.getTitulo());
    }

    public ItemBiblioteca buscarItem(String codigo) {
        return catalogo.get(codigo);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getDni(), usuario);
        System.out.println("👤 Usuario registrado: " + usuario.getNombreCompleto());
    }

    public Usuario buscarUsuario(String dni) {
        return usuarios.get(dni);
    }

    public boolean prestarItem(String codigoItem, String dni) {
        ItemBiblioteca item = buscarItem(codigoItem);
        Usuario usuario = buscarUsuario(dni);

        if (item == null) {
            System.out.println("❌ Item no encontrado: " + codigoItem);
            return false;
        }

        if (usuario == null) {
            System.out.println("❌ Usuario no encontrado: " + dni);
            return false;
        }

        // POLIMORFISMO: Verificamos si el item implementa Prestable
        if (item instanceof Prestable) {
            Prestable prestable = (Prestable) item; // CASTING
            return prestable.prestar(usuario);
        } else {
            System.out.println("❌ Este item no se puede prestar: " + item.getTitulo());
            return false;
        }
    }

    public boolean devolverItem(String codigoItem) {
        ItemBiblioteca item = buscarItem(codigoItem);

        if (item == null) {
            System.out.println("❌ Item no encontrado: " + codigoItem);
            return false;
        }

        if (item instanceof Prestable) {
            Prestable prestable = (Prestable) item;
            return prestable.devolver();
        } else {
            System.out.println("❌ Este item no es prestable: " + item.getTitulo());
            return false;
        }
    }

    public void mostrarCatalogo() {
        System.out.println("\n📚 CATÁLOGO DE LA BIBLIOTECA " + nombre.toUpperCase());
        System.out.println("=" + "=".repeat(nombre.length() + 25));

        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }

        // POLIMORFISMO: Cada item se muestra según su implementación específica de toString()
        catalogo.values().forEach(System.out::println);
    }

    public void mostrarUsuarios() {
        System.out.println("\n👥 USUARIOS REGISTRADOS");
        System.out.println("=====================");

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        // Streams
        usuarios.values().forEach(System.out::println);

        for (Usuario usuario : usuarios.values()) {
            System.out.println(usuario.getDni());
        }
    }

    // Miercoles
    public void mostrarEstadisticas() {
        System.out.println("\n📊 ESTADÍSTICAS DE LA BIBLIOTECA");
        System.out.println("================================");

        // Streams
        long itemsDisponibles = catalogo.values().stream()
                .filter(item -> item.getEstado() == EstadoItem.DISPONIBLE)
                .count();

        long itemsPrestados = catalogo.values().stream()
                .filter(item -> item.getEstado() == EstadoItem.PRESTADO)
                .count();

        System.out.println("Total de items: " + catalogo.size());
        System.out.println("Items disponibles: " + itemsDisponibles);
        System.out.println("Items prestados: " + itemsPrestados);
        System.out.println("Usuarios registrados: " + usuarios.size());
    }
}
