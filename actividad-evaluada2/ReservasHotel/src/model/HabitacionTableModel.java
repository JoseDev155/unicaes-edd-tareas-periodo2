package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HabitacionTableModel extends AbstractTableModel {
    private final String[] columnas = {"Número", "Tipo", "Precio/Noche", "Estado"};
    private List<Habitacion> datos;

    public HabitacionTableModel(List<Habitacion> datos) { this.datos = datos; }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int c) {
        return columnas[c];
    }

    @Override
    public Object getValueAt(int r, int c) {
        Habitacion h = datos.get(r);
        return switch (c) {
            case 0 -> h.getNumero();
            case 1 -> h.getTipo();
            case 2 -> h.getPrecio();
            case 3 -> h.getEstado();
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return switch (col) {
            case 0 -> Integer.class;
            case 2 -> Double.class;
            default -> String.class;
        };
    }
}