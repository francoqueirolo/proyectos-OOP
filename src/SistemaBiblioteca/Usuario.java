package SistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String dni;
    private String nombreCompleto;
    private String email;
    private String direccion;
    private String telefono;
    private List<ItemBiblioteca> itemsPrestados; // COMPOSICIÓN: Usuario tiene items

    public Usuario(String dni, String nombreCompleto, String email, String direccion, String telefono) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.itemsPrestados = new ArrayList<>();
    }

    public void agregarItemPrestado(ItemBiblioteca itemPrestado) {
        itemsPrestados.add(itemPrestado);
    }

    public void removerItemPrestado(ItemBiblioteca itemPrestado) {
        itemsPrestados.remove(itemPrestado);
    }

    /**
     * ENCAPSULAMIENTO: Copia defensiva
     * - Devolvemos una copia de la lista, no la original
     * - Evita que el código externo modifique directamente nuestra lista
     */
    public List<ItemBiblioteca> getItemPrestados() {
        return new ArrayList<>(itemsPrestados);
    }

    public int getNumeroItemPrestados() {
        return itemsPrestados.size();
    }

    // Metodo para crear una multa

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<ItemBiblioteca> getItemsPrestados() {
        return itemsPrestados;
    }

    public void setItemsPrestados(List<ItemBiblioteca> itemsPrestados) {
        this.itemsPrestados = itemsPrestados;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", itemsPrestados=" + itemsPrestados.size() +
                '}';
    }
}
