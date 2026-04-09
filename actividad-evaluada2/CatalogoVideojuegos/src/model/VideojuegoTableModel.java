package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class VideojuegoTableModel extends AbstractTableModel {
    private final String[] columnas = {"Título", "Consola", "Precio", "Calificación"};
    private List<Videojuego> datos;

    public VideojuegoTableModel(List<Videojuego> datos) { this.datos = datos; }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override public String getColumnName(int c) {
        return columnas[c];
    }

    @Override
    public Object getValueAt(int r, int c) {
        Videojuego v = datos.get(r);
        return switch (c) {
            case 0 -> v.getTitulo();
            case 1 -> v.getConsola();
            case 2 -> v.getPrecio();
            case 3 -> v.getCalificacion();
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return switch (col) {
            case 2 -> Double.class;
            case 3 -> Integer.class;
            default -> String.class;
        };
    }
}