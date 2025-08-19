package SistemaBiblioteca;

public class BibliotecaMain {

    public static void main(String[] args) {
        System.out.println("🏛️  SISTEMA DE GESTIÓN DE BIBLIOTECA");
        System.out.println("====================================");
        System.out.println("Demostrando todos los conceptos de POO\n");

        // CREACIÓN DE OBJETOS (INSTANCIACIÓN)
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // POLIMORFISMO: Diferentes tipos de items, todos tratados como ItemBiblioteca
        System.out.println("📚 Creando items del catálogo...");
        ItemBiblioteca libro1 = new Libro("L001", "El Quijote", "Miguel de Cervantes", 863, "978-84-376-0494-7");
        ItemBiblioteca libro2 = new Libro("L002", "Cien años de soledad", "Gabriel García Márquez");
//        ItemBiblioteca revista1 = new Revista("R001", "National Geographic", 245, "Mensual");
//        ItemBiblioteca dvd1 = new DVD("D001", "El Padrino", "Francis Ford Coppola", 175, "Drama");

        // AGREGACIÓN: Biblioteca contiene items
        biblioteca.agregarItem(libro1);
        biblioteca.agregarItem(libro2);
//        biblioteca.agregarItem(revista1);
//        biblioteca.agregarItem(dvd1);

        System.out.println("\n👥 Registrando usuarios...");
        Usuario usuario1 = new Usuario("12345678", "Ana García", "ana@email.com", "Arequipa","555-0123");
        Usuario usuario2 = new Usuario("87654321", "Carlos López", "carlos@email.com", "Arequipa","555-0456");

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // MOSTRAR ESTADO INICIAL
        biblioteca.mostrarCatalogo();
        biblioteca.mostrarUsuarios();
        biblioteca.mostrarEstadisticas();

        // DEMOSTRACIÓN DE PRÉSTAMOS (POLIMORFISMO EN ACCIÓN)
        System.out.println("\n🔄 REALIZANDO PRÉSTAMOS");
        System.out.println("=======================");

        // POLIMORFISMO: Cada tipo de item maneja el préstamo de forma diferente
        biblioteca.prestarItem("L001", "12345678"); // Libro
        biblioteca.prestarItem("L002", "87654321"); // Revista
//        biblioteca.prestarItem("D001", "12345678"); // DVD

        // MOSTRAR ESTADO DESPUÉS DE PRÉSTAMOS
        System.out.println("\n📊 Estado después de los préstamos:");
        biblioteca.mostrarCatalogo();
        biblioteca.mostrarEstadisticas();

        // DEMOSTRACIÓN DE DEVOLUCIONES
        System.out.println("\n↩️  REALIZANDO DEVOLUCIONES");
        System.out.println("==========================");

        biblioteca.devolverItem("L001");
        biblioteca.devolverItem("L002");

        // ESTADO FINAL
        System.out.println("\n📊 Estado final:");
        biblioteca.mostrarCatalogo();
        biblioteca.mostrarEstadisticas();
    }
}
