import model.*;
import view.CursoListCellRenderer;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Asegura que la UI se cree en el hilo correcto (EDT) [cite: 266, 267, 465]
        SwingUtilities.invokeLater(Main::iniciarApp);
    }

    private static void iniciarApp() {
        JFrame frame = new JFrame("Gestión de Cursos Universitarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout(10, 10));

        // 1. Datos y Modelos
        List<Curso> cursos = cargarDatosEjemplo();
        CursoTableModel tableModel = new CursoTableModel(cursos);
        DefaultListModel<Curso> listModel = new DefaultListModel<>();
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();

        // 2. Componentes Visuales
        JTable tabla = new JTable(tableModel);
        TableRowSorter<CursoTableModel> sorter = new TableRowSorter<>(tableModel);
        tabla.setRowSorter(sorter); // Habilitar filtrado y orden [cite: 298, 506]

        JList<Curso> jList = new JList<>(listModel);
// Se asigna el renderer para que la UI sea más clara y no muestre el @hashcode
        jList.setCellRenderer(new CursoListCellRenderer());
        JComboBox<String> jCombo = new JComboBox<>(comboModel);

        // 3. Filtro de Texto dinámico [cite: 306, 308, 508]
        JTextField txtFiltro = new JTextField();
        txtFiltro.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { filtrar(); }
            public void insertUpdate(DocumentEvent e) { filtrar(); }
            public void removeUpdate(DocumentEvent e) { filtrar(); }

            private void filtrar() {
                String texto = txtFiltro.getText().trim();
                if (texto.isEmpty()) sorter.setRowFilter(null);
                else sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 0)); // Filtra por Nombre
            }
        });

        // 4. Sincronización Inicial [cite: 351, 573]
        cursos.forEach(listModel::addElement);
        cursos.stream().map(Curso::getDocente).distinct().forEach(comboModel::addElement);

        // Layout y Paneles
        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.add(new JLabel(" Buscar por Nombre: "), BorderLayout.WEST);
        panelNorte.add(txtFiltro, BorderLayout.CENTER);
        panelNorte.add(jCombo, BorderLayout.EAST);

        frame.add(panelNorte, BorderLayout.NORTH);
        frame.add(new JScrollPane(tabla), BorderLayout.CENTER);
        frame.add(new JScrollPane(jList), BorderLayout.EAST);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static List<Curso> cargarDatosEjemplo() {
        List<Curso> lista = new ArrayList<>();
        lista.add(new Curso("Programación III", "Ing. Ramos", 5, 1));
        lista.add(new Curso("Álgebra", "Lic. Pérez", 4, 1));
        lista.add(new Curso("Ética", "Dr. Castro", 2, 2));
        return lista;
    }
}