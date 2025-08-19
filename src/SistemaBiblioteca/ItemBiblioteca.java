package SistemaBiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ItemBiblioteca {
    private String titulo;
    private String codigo;
    private EstadoItem estado; // PRESTADO, DISPONIBLE, NO DISPONIBLE
    private LocalDate fechaPrestamo;
    private Usuario usuarioPrestamo;

    // Constructor protegido: solo las clases hijas pueden llamarlo
    protected ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.estado = EstadoItem.DISPONIBLE;
        this.fechaPrestamo = null;
        this.usuarioPrestamo = null;
    }

    // Metodo abstracto
    public abstract int getDiasPrestamo();

    // Metodo template
    // Define el algoritmo general en la clase padre
    public long getDiasRetraso() {
        if (fechaPrestamo == null) {
            return 0;
        }

        LocalDate fechaLimite = fechaPrestamo.plusDays(getDiasPrestamo());
        LocalDate hoy = LocalDate.now();

        if (hoy.isAfter(fechaLimite)) {
            return ChronoUnit.DAYS.between(fechaLimite, hoy);
        }

        return 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public EstadoItem getEstado() {
        return estado;
    }

    public void setEstado(EstadoItem estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Usuario getUsuarioPrestamo() {
        return usuarioPrestamo;
    }

    public void setUsuarioPrestamo(Usuario usuarioPrestamo) {
        this.usuarioPrestamo = usuarioPrestamo;
    }

    @Override
    public String toString() {
        return String.format("%s: %s [%s]", codigo, titulo, estado.getDescripcion());
    }
}
