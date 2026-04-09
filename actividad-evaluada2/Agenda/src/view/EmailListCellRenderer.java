package view;

import javax.swing.*;
import java.awt.*;

public class EmailListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof String email) {
            setText(email.isEmpty() ? "(Sin correo)" : email.toLowerCase());
            if (email.isEmpty()) setForeground(Color.GRAY);
        }
        return this;
    }
}