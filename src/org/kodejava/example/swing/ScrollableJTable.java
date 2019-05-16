package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class ScrollableJTable extends JPanel {
    public ScrollableJTable() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 200));

        JTable table = new JTable(20, 20);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame() {
        JPanel panel = new ScrollableJTable();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Scrollable JTable");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ScrollableJTable.showFrame();
            }
        });
    }
}