package view;

import model.Producto;
import javax.swing.*;
import java.awt.*;

public class ProductoListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {

        // Mantiene colores de selección y foco automáticos
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Producto p) {
            // Personalizamos el texto: Nombre seguido del precio
            setText(p.getNombre() + " - $" + String.format("%.2f", p.getPrecio()));

            // Opcional: Si el producto es muy caro, podemos cambiar el color del texto
            if (p.getPrecio() > 500) {
                setForeground(isSelected ? Color.WHITE : new Color(0, 100, 0)); // Verde oscuro
            }
        }
        return this;
    }
}