package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizWindow extends JFrame implements ActionListener {
    Question[] questions;
    int current = 0, score = 0;
    JLabel qLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup bg = new ButtonGroup();
    JButton nextBtn, submitBtn;
    String userName;

    public QuizWindow(String userName) {
        this.userName = userName;
        setTitle("Java Quiz");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hardcoded questions
        questions = new Question[] {
            new Question("What is the size of int in Java?", new String[] {"4 bytes", "8 bytes", "2 bytes", "1 byte"}, 0),
            new Question("Which company created Java?", new String[] {"Microsoft", "Apple", "Sun Microsystems", "Google"}, 2),
            new Question("Which keyword is used to inherit a class in Java?", new String[] {"this", "super", "extends", "import"}, 2),
            new Question("What is JVM?", new String[] {"Java Virtual Machine", "Java Volatile Method", "Java Variable Manager", "None"}, 0),
            new Question("Which method is the entry point in Java?", new String[] {"main()", "start()", "init()", "run()"}, 0)
        };

        // UI components
        qLabel = new JLabel();
        qLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(qLabel, BorderLayout.NORTH);

        JPanel optionPanel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            optionPanel.add(options[i]);
        }
        add(optionPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);
        bottomPanel.add(nextBtn);

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        submitBtn.setEnabled(false);
        bottomPanel.add(submitBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        loadQuestion();
        setVisible(true);
    }

    void loadQuestion() {
        bg.clearSelection();
        qLabel.setText("Q" + (current + 1) + ": " + questions[current].getQuestion());
        String[] opts = questions[current].getOptions();
        for (int i = 0; i < 4; i++) {
            options[i].setText(opts[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selected = i;
            }
        }

        if (selected == questions[current].getCorrectIndex()) {
            score++;
        }

        if (e.getSource() == nextBtn) {
            current++;
            if (current == questions.length - 1) {
                nextBtn.setEnabled(false);
                submitBtn.setEnabled(true);
            }
            loadQuestion();
        }

        if (e.getSource() == submitBtn) {
            dispose();
            new ResultWindow(userName, score, questions.length);
        }
    }
}
