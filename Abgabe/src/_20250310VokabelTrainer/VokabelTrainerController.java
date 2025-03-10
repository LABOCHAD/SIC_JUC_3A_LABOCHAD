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

    //TODO: Hier soll eine Logik implementiert werden, die ein QUIZ startet, um Vokabeln zu üben.
    private void startQuiz() {
        Random keyPicker = new Random();
        int right = 0;
        int wrong = 0;
        //Collections.shuffle((List<?>) vocabMap.keySet()); //Help by IDE, make questioning random
        Set<String> values = (Set<String>) vocabMap.values(); //convert values of a map to list to make it accessible via random index
        for (Map.Entry<String, String> entry : vocabMap.entrySet()) { //so the list can be shrunken while count won't be touched
            int index = keyPicker.nextInt(vocabMap.size()); //get a random index
            String randomKey = vocabMap.get(values); //get key by value from the list with random index
            values.remove(randomKey); //so this vocabulary won't be asked for another time
            int tries = 3;
            boolean isCorrect = false;
            do {
                tries--;
                String userAnswer = JOptionPane.showInputDialog(ui.getFrame(), "Übersetzung für: " + randomKey);
                //if answer equals answer to this question in the map
                if (userAnswer.equals(vocabMap.get(randomKey))) {
                    isCorrect = true;
                    right++;
                    JOptionPane.showMessageDialog(ui.getFrame(), "Nice, that was correct.");
                } else {
                    JOptionPane.showMessageDialog(ui.getFrame(), ("Doh, that was wrong. Left tries: " + tries));
                    if (tries == 0) {
                        JOptionPane.showMessageDialog(ui.getFrame(), "Sorry, but this will count a a miss.");
                        wrong++;
                    }
                }
            } while (tries > 0 || !isCorrect);
        }
    }
}
