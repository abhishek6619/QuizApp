package src;

import javax.swing.*;
import java.awt.*;

public class ResultWindow extends JFrame {
    public ResultWindow(String name, int score, int total) {
        setTitle("Result");
        setSize(300, 150);
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel resultLabel = new JLabel("Thank you, " + name + "!");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        JLabel scoreLabel = new JLabel("Your score: " + score + "/" + total);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel);

        JLabel messageLabel = new JLabel(score >= total / 2 ? "Well done!" : "Better luck next time.");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel);

        setVisible(true);
    }
}
