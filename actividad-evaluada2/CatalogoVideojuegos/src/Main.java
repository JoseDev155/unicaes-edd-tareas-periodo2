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
        JFrame f = new JFrame("Catálogo de Videojuegos");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(950, 550);

        // 1. Datos base
        List<Videojuego> juegos = cargarDatos();

        // 2. Modelos
        VideojuegoTableModel tableModel = new VideojuegoTableModel(juegos);
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        DefaultListModel<Videojuego> listModel = new DefaultListModel<>();

        // 3. Tabla (Ordenamiento y Estrellas)
        JTable tabla = new JTable(tableModel);
        tabla.getColumnModel().getColumn(3).setCellRenderer(new CalificacionStarsRenderer());

        TableRowSorter<VideojuegoTableModel> sorter = new TableRowSorter<>(tableModel);
        tabla.setRowSorter(sorter);

        // 4. JComboBox (Filtro por Consola)
        comboModel.addElement("Todas las plataformas");
        juegos.stream().map(Videojuego::getConsola).distinct().forEach(comboModel::addElement);
        JComboBox<String> comboConsola = new JComboBox<>(comboModel);

        comboConsola.addActionListener(e -> {
            String seleccion = (String) comboConsola.getSelectedItem();
            if (seleccion == null || seleccion.equals("Todas las plataformas")) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("^" + seleccion + "$", 1));
            }
        });

        // 5. JList (Solo destacados >= 9)
        JList<Videojuego> jList = new JList<>(listModel);
        jList.setCellRenderer(new VideojuegoListCellRenderer());
        juegos.stream().filter(v -> v.getCalificacion() >= 9).forEach(listModel::addElement);

        // --- Layout ---
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panelNorte.add(new JLabel("Plataforma:"));
        panelNorte.add(comboConsola);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Top Destacados (9-10)"));
        panelDerecho.setPreferredSize(new Dimension(280, 0));
        panelDerecho.add(new JScrollPane(jList));

        f.add(panelNorte, BorderLayout.NORTH);
        f.add(new JScrollPane(tabla), BorderLayout.CENTER);
        f.add(panelDerecho, BorderLayout.EAST);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static List<Videojuego> cargarDatos() {
        return new ArrayList<>(List.of(
                new Videojuego("The Legend of Zelda", "Switch", 59.99, 10),
                new Videojuego("Halo Infinite", "Xbox", 49.99, 8),
                new Videojuego("God of War Ragnarok", "PlayStation", 69.99, 10),
                new Videojuego("Cyberpunk 2077", "PC", 39.99, 7),
                new Videojuego("Elden Ring", "PC", 59.99, 9),
                new Videojuego("Spider-Man 2", "PlayStation", 69.99, 9),
                new Videojuego("Forza Horizon 5", "Xbox", 55.00, 9)
        ));
    }
}