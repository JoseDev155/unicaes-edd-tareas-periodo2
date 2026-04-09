package view;

import model.Videojuego;
import javax.swing.*;
import java.awt.*;

public class VideojuegoListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Videojuego v) {
            setText(v.getTitulo() + " [" + v.getConsola() + "]");
            setFont(getFont().deriveFont(Font.BOLD));
        }
        return this;
    }
}