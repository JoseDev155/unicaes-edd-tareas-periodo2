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
        JFrame f = new JFrame("Catálogo de Tienda Online");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(850, 500);

        // 1. Datos iniciales
        List<Producto> productos = cargarDatos();

        // 2. Modelos
        ProductoTableModel tableModel = new ProductoTableModel(productos);
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        DefaultListModel<Producto> listModel = new DefaultListModel<>();

        // 3. Tabla y Sorter (Fundamental para el filtrado)
        JTable tabla = new JTable(tableModel);
        tabla.getColumnModel().getColumn(2).setCellRenderer(new EstrellasRenderer());

        // Creamos el sorter manualmente para poder aplicarle filtros después
        TableRowSorter<ProductoTableModel> sorter = new TableRowSorter<>(tableModel);
        tabla.setRowSorter(sorter);

        // 4. JComboBox con Lógica de Filtro
        comboModel.addElement("Todas");
        productos.stream().map(Producto::getCategoria).distinct().forEach(comboModel::addElement);
        JComboBox<String> comboCat = new JComboBox<>(comboModel);

        // Evento que se dispara al cambiar la categoría
        comboCat.addActionListener(e -> {
            String seleccion = (String) comboCat.getSelectedItem();

            if (seleccion == null || seleccion.equals("Todas")) {
                sorter.setRowFilter(null); // Muestra todos los productos
            } else {
                // Filtra por la columna 3 (Categoría) buscando coincidencia exacta
                sorter.setRowFilter(RowFilter.regexFilter("^" + seleccion + "$", 3));
            }
        });

        // 5. JList y Renderers
        JList<Producto> jList = new JList<>(listModel);
        jList.setCellRenderer(new ProductoListCellRenderer());
        productos.stream().filter(p -> p.getValoracion() >= 5).forEach(listModel::addElement);

        // --- Diseño de la Interfaz ---
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(new JLabel("Filtrar por Categoría: "));
        panelNorte.add(comboCat);

        f.add(panelNorte, BorderLayout.NORTH);
        f.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panelEste = new JPanel(new BorderLayout());
        panelEste.setBorder(BorderFactory.createTitledBorder("Destacados (5★)"));
        panelEste.add(new JScrollPane(jList));
        f.add(panelEste, BorderLayout.EAST);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static List<Producto> cargarDatos() {
        return new ArrayList<>(List.of(
                new Producto("Smartphone X", 799.99, 5, "Electrónica"),
                new Producto("Cafetera Express", 120.50, 4, "Hogar"),
                new Producto("Monitor 4K", 350.00, 5, "Electrónica"),
                new Producto("Silla Gamer", 210.00, 3, "Muebles"),
                new Producto("Laptop Pro", 1200.00, 5, "Electrónica")
        ));
    }
}