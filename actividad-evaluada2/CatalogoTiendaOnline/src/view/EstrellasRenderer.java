package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class EstrellasRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Integer val) {
            // Genera la cadena de estrellas [cite: 250]
            String estrellas = "★".repeat(val) + "☆".repeat(5 - val);
            setText(estrellas);
            setForeground(Color.ORANGE); // Color característico para valoraciones
        }
        return this;
    }
}