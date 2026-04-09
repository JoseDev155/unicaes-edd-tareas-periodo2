package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CursoTableModel extends AbstractTableModel {
    private final String[] columnas = {"Nombre", "Docente", "UV", "Ciclo"};
    private List<Curso> datos;

    public CursoTableModel(List<Curso> datos) { this.datos = datos; }

    public void setDatos(List<Curso> nuevaLista) {
        this.datos = nuevaLista;
        fireTableDataChanged(); // Notifica a la tabla para redibujar [cite: 246, 361]
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int c) {
        return columnas[c];
    }

    @Override
    public Object getValueAt(int r, int c) {
        Curso curso = datos.get(r);
        return switch (c) {
            case 0 -> curso.getNombre();
            case 1 -> curso.getDocente();
            case 2 -> curso.getUv();
            case 3 -> curso.getCiclo();
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        // Indica el tipo real para que el sorter funcione numéricamente [cite: 244, 245, 417]
        return switch (col) {
            case 0, 1 -> String.class;
            case 2, 3 -> Integer.class;
            default -> Object.class;
        };
    }
}
