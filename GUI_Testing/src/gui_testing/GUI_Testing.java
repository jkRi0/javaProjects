package gui_testing;

import java.awt.*;
import javax.swing.*;

public class GUI_Testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton button = new JButton("Test");
        label = new JLabel("Number of clicks: 0");
        
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("sheeeesh");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
