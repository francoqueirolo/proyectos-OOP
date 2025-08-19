package SistemaBiblioteca;

import java.time.LocalDate;

public class Libro extends ItemBiblioteca implements Prestable {
    private String autor;
    private int numeroPaginas;
    private String isbn;

    protected Libro(String codigo, String titulo, String autor) {
        super(codigo, titulo);
        this.autor = autor;
        this.numeroPaginas = 0;
        this.isbn = "";
    }

    public Libro(String codigo, String titulo, String autor, int numeroPaginas, String isbn) {
        super(codigo, titulo);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    @Override
    public int getDiasPrestamo() {
        return 15;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean prestar(Usuario usuario) {
        if (!puedeSerPrestado()) {
            return false;
        }

        setEstado(EstadoItem.PRESTADO);
        setFechaPrestamo(LocalDate.now());
        setUsuarioPrestamo(usuario);
        usuario.agregarItemPrestado(this);

        System.out.println("📚 Libro prestado: " + getTitulo() + " a " + usuario.getNombreCompleto());
        return true;
    }

    @Override
    public boolean devolver() {
        if (getEstado() != EstadoItem.PRESTADO) {
            return false;
        }

        double multa = calcularMulta();
        if (multa > 0) {
            System.out.println("Multa por retraso: $" + String.format("%.2f", multa));
        }

        getUsuarioPrestamo().removerItemPrestado(this);
        setEstado(EstadoItem.DISPONIBLE);
        setFechaPrestamo(null);
        setUsuarioPrestamo(null);

        System.out.println("📚 Libro devuelto: " + getTitulo());
        return true;
    }

    @Override
    public boolean puedeSerPrestado() {
        return getEstado() == EstadoItem.DISPONIBLE;
    }

    @Override
    public double calcularMulta() {
        long diasRetraso = getDiasRetraso();
        return diasRetraso > 0 ? diasRetraso * 0.50 : 0.0;
    }

}
