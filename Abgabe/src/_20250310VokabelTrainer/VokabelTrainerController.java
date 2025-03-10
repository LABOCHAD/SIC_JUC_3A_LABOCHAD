package _20250310VokabelTrainer;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class VokabelTrainerController {
    private HashMap<String, String> vocabMap;
    private IO dateiManager;
    private VokabelTrainerUI ui;

    public VokabelTrainerController(){
        try {
            dateiManager = new IO();
        }catch (IOException e){
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
        ui = new VokabelTrainerUI();
        loadVocab();
        ui.getSaveButton().addActionListener(e -> saveVocab(ui.getOriginalField().getText().trim(),ui.getTranslationField().getText().trim()));
        ui.getStartQuizButton().addActionListener(e -> startQuiz());
        ui.getDeleteButton().addActionListener(e -> deleteVocab(ui.getOriginalField().getText()));
    }

    private void saveVocab(String word, String translation) {
        try {
            if (!word.isEmpty() && !translation.isEmpty()){
                vocabMap.put(word, translation);
                dateiManager.saveVocab(vocabMap);
                loadVocab();
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
    }

    private void loadVocab() {
        try {
            vocabMap = dateiManager.loadVocab();
            ui.getDisplayArea().setText("");
            vocabMap.forEach((key, value) -> ui.getDisplayArea().append(key + " - " + value + "\n"));
        }catch (IOException e){
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
    }

    private void deleteVocab(String word){
        try{
            dateiManager.deleteWord(word);
            loadVocab();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ui.getFrame(), e.getMessage());
        }
    }

    //TODO: Hier soll eine Logik implementiert werden, die ein QUIZ startet, um Vokabeln zu üben.
    private void startQuiz() {
    }


    public static void main(String[] args) {
        VokabelTrainerController c = new VokabelTrainerController();
    }
}
