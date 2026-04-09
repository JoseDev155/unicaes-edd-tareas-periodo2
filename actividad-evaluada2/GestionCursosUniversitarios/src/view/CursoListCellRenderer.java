package view;

import model.Curso;
import javax.swing.*;
import java.awt.*;

// Al ser un archivo propio, eliminamos el "static"
public class CursoListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {

        // Mantiene el comportamiento básico (colores de selección) [cite: 431, 442]
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Curso curso) {
            // Deciden cómo se dibuja cada elemento [cite: 249]
            setText(curso.getNombre() + " (Ciclo " + curso.getCiclo() + ")");

            // Renderer para mostrar en rojo cursos con más de 4 UV (Requerimiento Proyecto 1)
            if (curso.getUv() > 4) {
                setForeground(Color.RED);
            } else {
                // Restablecer color si no cumple la condición para evitar errores de pintado [cite: 254]
                setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            }
        }
        return this;
    }
}
