////////////////////////////////////////////////
// Author: Alan Huynh                         //
// Date: Oct 8 2024                           //
// Project: Programming Concept Final Project //
////////////////////////////////////////////////

// Main classes :D

import javax.swing.SwingUtilities;

// The "main" file (__main__ in python)
// Basically it just display the GUI
public class FoodApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodGUI gui = new FoodGUI();
            gui.setVisible(true);
        });
    }
}