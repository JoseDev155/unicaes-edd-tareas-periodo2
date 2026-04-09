package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ContactoTableModel extends AbstractTableModel {
    private final String[] columnas = {"Info", "Nombre", "Teléfono", "Correo", "Grupo"};
    private List<Contacto> datos;

    public ContactoTableModel(List<Contacto> datos) { this.datos = datos; }

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
        Contacto con = datos.get(r);
        return switch (c) {
            case 0 -> con; // Pasamos el objeto completo a la col 0 para el renderer de iconos
            case 1 -> con.getNombre();
            case 2 -> con.getTelefono();
            case 3 -> con.getCorreo();
            case 4 -> con.getGrupo();
            default -> null;
        };
    }
}