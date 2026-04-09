package view;

import model.Contacto;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ContactoTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Contacto con) {
            if (con.tieneCorreo()) {
                setText("✉"); // Icono de sobre
                setForeground(new Color(0, 102, 204)); // Azul
                setToolTipText("Contacto con Correo");
            } else {
                setText("📞"); // Icono de teléfono
                setForeground(new Color(34, 139, 34)); // Verde bosque
                setToolTipText("Solo Teléfono");
            }
            setHorizontalAlignment(CENTER);
        }
        return this;
    }
}