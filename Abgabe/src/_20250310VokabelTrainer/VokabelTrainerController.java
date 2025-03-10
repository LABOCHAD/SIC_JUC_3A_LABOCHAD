package _20250310VokabelTrainer;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class VokabelTrainerController {
    private HashMap<String, String> vocabMap;
    private IO dateiManager;
    private VokabelTrainerUI ui;

    public VokabelTrainerController() {
        try {
            dateiManager = new IO();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
        ui = new VokabelTrainerUI();
        loadVocab();
        ui.getSaveButton().addActionListener(e -> saveVocab(ui.getOriginalField().getText().trim(), ui.getTranslationField().getText().trim()));
        ui.getStartQuizButton().addActionListener(e -> startQuiz());
        ui.getDeleteButton().addActionListener(e -> deleteVocab(ui.getOriginalField().getText()));
    }

    public static void main(String[] args) {
        VokabelTrainerController c = new VokabelTrainerController();
    }

    private void saveVocab(String word, String translation) {
        try {
            if (!word.isEmpty() && !translation.isEmpty()) {
                vocabMap.put(word, translation);
                dateiManager.saveVocab(vocabMap);
                loadVocab();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
    }

    private void loadVocab() {
        try {
            vocabMap = dateiManager.loadVocab();
            ui.getDisplayArea().setText("");
            vocabMap.forEach((key, value) -> ui.getDisplayArea().append(key + " - " + value + "\n"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
    }

    private void deleteVocab(String word) {
        try {
            dateiManager.deleteWord(word);
            loadVocab();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
    }

    //DONE: Hier soll eine Logik implementiert werden, die ein QUIZ startet, um Vokabeln zu üben.
    private void startQuiz() {
        Random keyPicker = new Random();
        int right = 0;
        int wrong = 0;
        //https://stackoverflow.com/questions/929554/is-there-a-way-to-get-the-value-of-a-hashmap-randomly-in-java
        List<String> keys = new ArrayList<>(vocabMap.keySet()); //convert keys of a map to list to make it accessible via random index
        QUESTION: for (Map.Entry<String, String> entry : vocabMap.entrySet()) {
            int index = keyPicker.nextInt(keys.size()); //get a random index
            String randomKey = keys.get(index); //get key by value from the list with random index
            keys.remove(randomKey); //so this vocabulary won't be asked for another time
            int tries = 3;
            do {
                String userAnswer = JOptionPane.showInputDialog(ui.getFrame(), "Übersetzung für: " + randomKey);
                if (userAnswer == null ||userAnswer.isBlank()) return;
                //if answer equals answer to this question in the map
                if (userAnswer.equalsIgnoreCase(vocabMap.get(randomKey))) {
                    right++;
                    JOptionPane.showMessageDialog(ui.getFrame(), "Nice, that was correct.");
                    continue QUESTION;
                } else
                    JOptionPane.showMessageDialog(ui.getFrame(), ("Doh, that was wrong. Left tries: " + tries));
            } while (--tries > 0);
            JOptionPane.showMessageDialog(ui.getFrame(), "Sorry, but this will count a a miss.");
            wrong++;
        }
        JOptionPane.showMessageDialog(ui.getFrame(), String.format("Result: %d right / %d wrong", right, wrong));

    }
}
