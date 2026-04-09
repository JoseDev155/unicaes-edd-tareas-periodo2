package model;

public class Contacto {
    private final String nombre;
    private final String telefono;
    private final String correo;
    private final String grupo;

    public Contacto(String nombre, String telefono, String correo, String grupo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getGrupo() {
        return grupo;
    }

    // Determina si el contacto tiene correo válido (no vacío)
    public boolean tieneCorreo() {
        return correo != null && !correo.trim().isEmpty();
    }
}