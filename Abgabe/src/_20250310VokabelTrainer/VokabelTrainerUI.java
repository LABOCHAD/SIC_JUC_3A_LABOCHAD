package _20250310VokabelTrainer;

import javax.swing.*;
import java.awt.*;

public class VokabelTrainerUI {
    private JFrame frame;
    private JTextField originalField;
    private JTextField translationField;
    private JTextArea displayArea;
    private JButton saveButton, startQuizButton, deleteButton;


    public VokabelTrainerUI() {

        frame = new JFrame("Vokabeltrainer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Vokabeltrainer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Original:"), gbc);
        originalField = new JTextField();
        gbc.gridx = 1;
        panel.add(originalField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Übersetzung:"), gbc);
        translationField = new JTextField();
        gbc.gridx = 1;
        panel.add(translationField, gbc);

        saveButton = new JButton("Speichern");
        startQuizButton = new JButton("Quiz starten");
        deleteButton = new JButton("Löschen");

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridx = 1;
        panel.add(saveButton, gbc);
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridx = 1;
        panel.add(startQuizButton, gbc);
        gbc.gridx = 2;
        panel.add(deleteButton, gbc);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getStartQuizButton() {
        return startQuizButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextArea getDisplayArea() {
        return displayArea;
    }

    public JTextField getOriginalField() {
        return originalField;
    }

    public JTextField getTranslationField() {
        return translationField;
    }

    public JFrame getFrame() {
        return frame;
    }
}
