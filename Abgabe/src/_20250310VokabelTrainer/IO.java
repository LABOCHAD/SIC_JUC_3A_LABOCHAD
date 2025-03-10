package _20250310VokabelTrainer;

import java.io.*;
import java.util.HashMap;

public class IO {
    private String dateiPfad = "vokabel.txt"; //Make it relative to package containing main class?

    public IO() throws IOException {
        File myFile = new File(dateiPfad);
        if (myFile.createNewFile())
            System.out.println("A new vocabulary file has been created successfully");
        else
            System.out.println("A vocabulary file already exists.");
    }

    public void saveVocab(HashMap<String, String> vocabMap) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateiPfad))) {
            for (java.util.Map.Entry<String, String> entry : vocabMap.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public HashMap<String, String> loadVocab() throws IOException {
        HashMap<String, String> vocabMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiPfad))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    vocabMap.put(parts[0], parts[1]);
                }
            }
        }
        return vocabMap;
    }

    //Implementiere eine Methode, welche das Wort aus der Datei löscht.
    // Nutze dafür die loadVocab und saveVocab()
    // -Methoden und dein Wissen über HashMaps.
    public void deleteWord(String word) throws IOException {
        HashMap<String, String> vocabMap = loadVocab();
        Object removed = vocabMap.remove(word);
        if (removed != null) {
            System.out.println(removed + " has been removed.");
            saveVocab(vocabMap);
        } else
            System.out.println("Nothing could have been removed.");
    }
}
