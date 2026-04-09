import model.*;
import view.*;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::crearUI);
    }

    private static void crearUI() {
        JFrame f = new JFrame("Agenda de Contactos");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 500);

        // 1. Datos base
        List<Contacto> agenda = cargarDatos();

        // 2. Modelos
        ContactoTableModel tableModel = new ContactoTableModel(agenda);
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // 3. Tabla (Iconos y Orden)
        JTable tabla = new JTable(tableModel);
        tabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tabla.getColumnModel().getColumn(0).setCellRenderer(new ContactoTableRenderer());

        TableRowSorter<ContactoTableModel> sorter = new TableRowSorter<>(tableModel);
        tabla.setRowSorter(sorter);

        // 4. JComboBox (Filtro por Grupo)
        comboModel.addElement("Todos");
        agenda.stream().map(Contacto::getGrupo).distinct().forEach(comboModel::addElement);
        JComboBox<String> comboGrupo = new JComboBox<>(comboModel);

        comboGrupo.addActionListener(e -> {
            String grupo = (String) comboGrupo.getSelectedItem();

            // Filtrar Tabla
            if (grupo.equals("Todos")) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("^" + grupo + "$", 4));
            }

            // Actualizar JList con los correos del grupo seleccionado
            listModel.clear();
            agenda.stream()
                    .filter(c -> grupo.equals("Todos") || c.getGrupo().equals(grupo))
                    .map(Contacto::getCorreo)
                    .forEach(listModel::addElement);
        });

        // 5. JList inicial
        JList<String> jList = new JList<>(listModel);
        jList.setCellRenderer(new EmailListCellRenderer());
        agenda.forEach(c -> listModel.addElement(c.getCorreo()));

        // --- Layout ---
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelNorte.add(new JLabel("Seleccionar Grupo:"));
        panelNorte.add(comboGrupo);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Directorio de Correos"));
        panelDerecho.setPreferredSize(new Dimension(250, 0));
        panelDerecho.add(new JScrollPane(jList));

        f.add(panelNorte, BorderLayout.NORTH);
        f.add(new JScrollPane(tabla), BorderLayout.CENTER);
        f.add(panelDerecho, BorderLayout.EAST);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static List<Contacto> cargarDatos() {
        return new ArrayList<>(List.of(
                new Contacto("Ana García", "7788-9900", "ana@mail.com", "Trabajo"),
                new Contacto("Juan Pérez", "2233-4455", "", "Familia"),
                new Contacto("Carlos Ruiz", "6677-8822", "cruiz@social.me", "Amigos"),
                new Contacto("Elena Sosa", "7122-3344", "elena.sosa@job.com", "Trabajo"),
                new Contacto("Mamá", "2211-0099", "", "Familia"),
                new Contacto("Roberto Gómez", "6055-4433", "robert@mail.com", "Amigos")
        ));
    }
}