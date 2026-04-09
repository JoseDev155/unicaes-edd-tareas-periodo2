import model.*;
import view.*;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::crearUI);
    }

    private static void crearUI() {
        JFrame f = new JFrame("Sistema de Reservas de Hotel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 500);

        // 1. Datos
        List<Habitacion> habitaciones = cargarDatos();

        // 2. Modelos
        HabitacionTableModel tableModel = new HabitacionTableModel(habitaciones);
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        DefaultListModel<Habitacion> listModel = new DefaultListModel<>();

        // 3. JTable con Sorter y Renderer
        JTable tabla = new JTable(tableModel);
        tabla.setDefaultRenderer(Object.class, new HabitacionTableRenderer());
        tabla.setDefaultRenderer(Integer.class, new HabitacionTableRenderer());
        tabla.setDefaultRenderer(Double.class, new HabitacionTableRenderer());

        TableRowSorter<HabitacionTableModel> sorter = new TableRowSorter<>(tableModel);
        tabla.setRowSorter(sorter);

        // 4. JComboBox (Filtro por Tipo)
        comboModel.addElement("Todos los tipos");
        habitaciones.stream().map(Habitacion::getTipo).distinct().forEach(comboModel::addElement);
        JComboBox<String> comboTipo = new JComboBox<>(comboModel);

        comboTipo.addActionListener(e -> {
            String seleccion = (String) comboTipo.getSelectedItem();
            if (seleccion == null || seleccion.equals("Todos los tipos")) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("^" + seleccion + "$", 1));
            }
        });

        // 5. JList (Solo disponibles)
        JList<Habitacion> jList = new JList<>(listModel);
        jList.setCellRenderer(new HabitacionListCellRenderer());
        habitaciones.stream()
                .filter(h -> h.getEstado().equals("Disponible"))
                .forEach(listModel::addElement);

        // --- Diseño ---
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(new JLabel("Filtrar Tipo: "));
        panelNorte.add(comboTipo);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Disponibles"));
        panelDerecho.setPreferredSize(new Dimension(250, 0));
        panelDerecho.add(new JScrollPane(jList));

        f.add(panelNorte, BorderLayout.NORTH);
        f.add(new JScrollPane(tabla), BorderLayout.CENTER);
        f.add(panelDerecho, BorderLayout.EAST);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static List<Habitacion> cargarDatos() {
        return new ArrayList<>(List.of(
                new Habitacion(101, "Individual", 45.0, "Disponible"),
                new Habitacion(102, "Doble", 75.0, "Ocupada"),
                new Habitacion(201, "Suite", 150.0, "Disponible"),
                new Habitacion(202, "Individual", 45.0, "Ocupada"),
                new Habitacion(301, "Doble", 80.0, "Disponible")
        ));
    }
}