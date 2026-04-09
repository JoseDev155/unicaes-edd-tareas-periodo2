package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class HabitacionTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtenemos el estado de la fila actual (columna 3)
        String estado = table.getValueAt(row, 3).toString();

        if (estado.equalsIgnoreCase("Ocupada")) {
            setForeground(Color.RED);
            setFont(getFont().deriveFont(Font.BOLD));
        } else {
            setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
            setFont(getFont().deriveFont(Font.PLAIN));
        }

        return this;
    }
}