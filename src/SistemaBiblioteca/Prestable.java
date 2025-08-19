package SistemaBiblioteca;

public interface Prestable {

    boolean prestar(Usuario usuario);
    boolean devolver();
    boolean puedeSerPrestado();
    double calcularMulta();
}
