package src;

import javax.swing.*;

public class QuizMain {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name != null && !name.trim().isEmpty()) {
            new QuizWindow(name);
        } else {
            JOptionPane.showMessageDialog(null, "Name cannot be empty. Exiting.");
        }
    }
}
