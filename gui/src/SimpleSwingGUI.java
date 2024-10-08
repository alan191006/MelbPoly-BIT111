import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingGUI {
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("Simple Swing GUI");

        // Set the frame's size
        frame.setSize(400, 200);

        // Specify what happens when the close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold components
        JPanel panel = new JPanel();

        // Add the panel to the frame
        frame.add(panel);

        // Place components inside the panel
        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Set layout for the panel
        panel.setLayout(null);

        // Create a label
        JLabel label = new JLabel("Click the button to change text!");
        label.setBounds(50, 20, 300, 25);
        panel.add(label);

        // Create a button
        JButton button = new JButton("Click Me!");
        button.setBounds(150, 80, 100, 25);
        panel.add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button clicked!");
            }
        });
    }
}
