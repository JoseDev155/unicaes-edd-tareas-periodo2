package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CalificacionStarsRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Integer cal) {
            // Dividimos entre 2 para mostrar hasta 5 estrellas si la escala es 10
            int numEstrellas = (int) Math.ceil(cal / 2.0);
            String estrellas = "★".repeat(numEstrellas) + "☆".repeat(5 - numEstrellas);
            setText(estrellas + " (" + cal + ")");
            setForeground(new Color(218, 165, 32)); // Color Dorado/Oro
        }
        return this;
    }
}