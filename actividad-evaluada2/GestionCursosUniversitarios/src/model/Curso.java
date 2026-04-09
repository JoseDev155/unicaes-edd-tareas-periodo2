package model;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Curso {
    private final String nombre;
    private final String docente;
    private final int uv;
    private final int ciclo;

    public Curso(String nombre, String docente, int uv, int ciclo) {
        this.nombre = nombre;
        this.docente = docente;
        this.uv = uv;
        this.ciclo = ciclo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDocente() {
        return docente;
    }

    public int getUv() {
        return uv;
    }

    public int getCiclo() {
        return ciclo;
    }

    // Utilidades de ordenamiento profesionales [cite: 255, 257, 261]
    public static Collator getCollatorES() {
        Collator collator = Collator.getInstance(new Locale("es", "ES"));
        collator.setStrength(Collator.PRIMARY); // Ignora tildes y mayúsculas [cite: 261, 453]
        return collator;
    }

    public static Comparator<Curso> porNombre() {
        return (a, b) -> getCollatorES().compare(a.getNombre(), b.getNombre());
    }
}