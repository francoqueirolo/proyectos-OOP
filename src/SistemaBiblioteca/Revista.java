package SistemaBiblioteca;

public class Revista extends ItemBiblioteca {

    protected Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getDiasPrestamo() {
        return 5;
    }
}
