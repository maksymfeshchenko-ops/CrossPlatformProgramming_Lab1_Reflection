package lab1.task1;

import javax.swing.*;
import java.awt.*;

public class MainGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Reflection Analyzer");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField input = new JTextField();
        JTextArea output = new JTextArea();
        JButton button = new JButton("Analyze");

        button.addActionListener(e -> {
            try {
                output.setText(ClassAnalyzer.analyze(input.getText()));
            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(input, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
