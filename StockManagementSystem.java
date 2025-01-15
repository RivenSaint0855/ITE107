import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class StockManagementSystem {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Stock Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());

        // Create side menu panel
        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new GridLayout(8, 1, 5, 5));
        sideMenu.setBackground(new Color(44, 62, 80));

        String[] menuItems = {"Add Item", "Issue Items", "Stock", "Employee", "Suppliers", "Reports","Settings", "Backup"};
        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(52, 73, 94));
            button.setFocusPainted(false);
            sideMenu.add(button);
        }

        // Add side menu to the frame
        frame.add(sideMenu, BorderLayout.WEST);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(41, 128, 185));
        JLabel title = new JLabel("Stock Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        header.add(title, BorderLayout.CENTER);
        header.add(new JLabel("2:32:28    2019-10-11", SwingConstants.RIGHT), BorderLayout.EAST);
        mainPanel.add(header, BorderLayout.NORTH);

        // Add form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 5, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        formPanel.add(new JLabel("EPF:"));
        formPanel.add(new JComboBox<>(new String[]{"All"}));
        formPanel.add(new JLabel("Department:"));
        formPanel.add(new JComboBox<>(new String[]{"Select Department"}));
        formPanel.add(new JLabel("Item:"));
        formPanel.add(new JComboBox<>(new String[]{"All"}));
        formPanel.add(new JLabel("Date From:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Date To:"));
        formPanel.add(new JTextField());
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Clear"));
        buttonPanel.add(new JButton("Print"));
        buttonPanel.add(new JButton("Filter"));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add table with new data and right-aligned text
        String[] columnNames = {"Item Code", "Item Name", "EPF Number", "Issue By", "Quantity", "Date", "Department"};
        Object[][] data = {
            {"42069", "Shabams", "4561", "Jasper Phillip", "666", "2024-12-06", "DPWH"},
            {"18464", "Ruler", "44", "Phil Bilo", "10", "2002-01-08", "DOH"},
            {"38781", "Pen", "94535", "Jas Villaluz", "298", "2019-07-20", "DOLE"},
            {"66524", "Paper", "6", "Repsaj", "1233", "2019-07-20", "DOJ"},
        };
        JTable table = new JTable(data, columnNames);

        // Set cell renderer for right alignment
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }

        // Add table to a scroll pane
        JScrollPane tablePane = new JScrollPane(table);
        mainPanel.add(tablePane, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
