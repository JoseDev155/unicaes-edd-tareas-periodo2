package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductoTableModel extends AbstractTableModel {
    private final String[] columnas = {"Nombre", "Precio", "Valoración", "Categoría"};
    private List<Producto> datos;

    public ProductoTableModel(List<Producto> datos) { this.datos = datos; }

    public void setData(List<Producto> nuevaLista) {
        this.datos = nuevaLista;
        fireTableDataChanged(); // Avisa a la tabla que los datos cambiaron [cite: 246]
    }

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
        Producto p = datos.get(r);
        return switch (c) {
            case 0 -> p.getNombre();
            case 1 -> p.getPrecio();
            case 2 -> p.getValoracion();
            case 3 -> p.getCategoria();
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int col) {
        // Indica tipos numéricos para que el sorter funcione correctamente [cite: 244, 417]
        return switch (col) {
            case 0, 3 -> String.class;
            case 1 -> Double.class;
            case 2 -> Integer.class;
            default -> Object.class;
        };
    }
}