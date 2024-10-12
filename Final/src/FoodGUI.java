////////////////////////////////////////////////
// Author: Alan Huynh                         //
// Date: Oct 8 2024                           //
// Project: Programming Concept Final Project //
////////////////////////////////////////////////


import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

// This is the main interface
public class FoodGUI extends JFrame {
    private JTextField nameField;
    private JTextField amountField;
    private JTextArea detailsArea;

    // Don't ask me why I hardcode -_-
    private final String fileName = "food_intake_1557984.txt";

    // Konsutorakuta- desu!!!
    public FoodGUI() {
        setupGUI();
    }

    private void setupGUI() {
        setTitle("Food Intake Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(500, 350);
        
        // Set look and feel
        // It just me messing with Java :D
        // Only affect the bottom panel on my machine :(
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {  // It have a warning here :((
            System.err.println("An error occurred: " + e.getMessage());

        }

        // Treat all following code as css :)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(230, 230, 250)); // Lavender background :D

        // Add components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Name field
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(new JLabel("Food Name:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 1.0;
        nameField = new JTextField(20);
        mainPanel.add(nameField, gbc);
        
        // Amount field
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Amount:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        amountField = new JTextField(20);
        mainPanel.add(amountField, gbc);
        
        // Details area
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Details:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.weightx = 1.0;
        detailsArea = new JTextArea(3, 20);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);
        detailsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        mainPanel.add(scrollPane, gbc);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        
        JButton saveButton = new JButton("Save to file");
        JButton viewButton = new JButton("View Records");
        JButton closeButton = new JButton("Close");
        
        // Customize button colors
        customizeButton(saveButton);
        customizeButton(viewButton);
        customizeButton(closeButton);
        
        buttonPanel.add(saveButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(closeButton);
        
        // Add action listeners
        saveButton.addActionListener(e -> saveToFile());
        viewButton.addActionListener(e -> viewRecords());
        closeButton.addActionListener(e -> dispose());
        
        // Add panels to frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Center the frame on screen
        setLocationRelativeTo(null);
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(100, 149, 237)); // Cornflower blue
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void saveToFile() {
        // Self explanatory
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Food name cannot be empty!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // try() with () eqivalent to python's with()
        // Basically auto destroy the thing declare in () when finish
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            Food food = new Food();
            food.setName(nameField.getText().trim());
            food.setAmount(amountField.getText().trim());
            food.setDetails(detailsArea.getText().trim());
            
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            // ||| is new item
            out.println("|||");
            out.println(timestamp);
            out.println("||" + food.getName());
            out.println("||" + food.getAmount());
            out.println("||" + food.getDetails());
            
            JOptionPane.showMessageDialog(this, "Food intake record saved successfully!");
            
            // Clear fields
            nameField.setText("");
            amountField.setText("");
            detailsArea.setText("");

            // Refocus on the name field after closing
            nameField.requestFocus();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                "Error saving to file: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Call the FileViewerGUI to display the saved record
    private void viewRecords() {
        FileViewerGUI viewer = new FileViewerGUI(fileName);
        viewer.setVisible(true);
    }
}
