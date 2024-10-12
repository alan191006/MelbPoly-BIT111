////////////////////////////////////////////////
// Author: Alan Huynh                         //
// Date: Oct 8 2024                           //
// Project: Programming Concept Final Project //
////////////////////////////////////////////////

// Viewer GUI Classes :D Lot's of fun with this one

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class FileViewerGUI extends JFrame {
    private final JTextArea viewArea;
    private final JButton refreshButton;
    private final String fileName;

    public FileViewerGUI(String fileName) {
        this.fileName = fileName;
        setTitle("Food Intake Records");
        setSize(600, 450);
        setLayout(new BorderLayout(10, 10));

        // Set look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {  // It have a warning here :((
            System.err.println("An error occurred: " + e.getMessage());
        }

        // Create text area for viewing records
        viewArea = new JTextArea();
        viewArea.setEditable(false);
        viewArea.setMargin(new Insets(10, 10, 10, 10));
        viewArea.setFont(new Font("Arial", Font.PLAIN, 14));
        viewArea.setBackground(Color.WHITE);
        viewArea.setForeground(Color.BLACK);
        
        // Enhance scroll pane with a border and background
        JScrollPane scrollPane = new JScrollPane(viewArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2), "Records", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(100, 149, 237)));
        scrollPane.setBackground(new Color(240, 240, 240));
        
        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Create and customize refresh button
        refreshButton = new JButton("Refresh Records");
        customizeButton(refreshButton);
        refreshButton.addActionListener(e -> loadFileContents(fileName));

        // Add button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadFileContents(fileName);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadFileContents(String fileName) {
        StringBuilder displayText = new StringBuilder();

        try {
            if (!Files.exists(Paths.get(fileName))) {
                viewArea.setText("No records found.");
                return;
            }

            java.util.List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (int i = 0; i < lines.size(); i++) {
                // Parse the result
                // For the "writer" code refer to 
                // FoodGUI line 148
                String line = lines.get(i);

                if (line.equals("|||")) {
                    displayText.append("\n").append("=".repeat(50)).append("\n");
                    continue;
                    // Small gap below for a sense of hierachy
                }

                if (line.startsWith("||")) {
                    String content = line.substring(2);
                    if (i > 0 && lines.get(i - 1).equals("|||")) {
                        // Skip timestamp
                        continue;
                    } else if (i > 1 && lines.get(i - 2).equals("|||")) {
                        displayText.append("Name: ").append(content).append("\n");
                    } else if (i > 2 && lines.get(i - 3).equals("|||")) {
                        displayText.append("Amount: ").append(content).append("\n");
                    } else if (i > 3 && lines.get(i - 4).equals("|||")) {
                        displayText.append("Details: ").append(content).append("\n");
                    }
                } else {
                    displayText.append(line).append("\n");
                }
            }

            viewArea.setText(displayText.toString());
            viewArea.setCaretPosition(0);

        } catch (IOException e) {
            viewArea.setText("Error loading records: " + e.getMessage());
        }
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(100, 149, 237)); // Cornflower blue
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileViewerGUI("food_intake_1557984.txt"));
    }
}
