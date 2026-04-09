package view;

import model.Habitacion;
import javax.swing.*;
import java.awt.*;

public class HabitacionListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Habitacion h) {
            setText("Hab. #" + h.getNumero() + " [" + h.getTipo() + "]");
        }
        return this;
    }
}