package com.tamagotchi.tamagotchi;

import com.tamagotchi.tamagotchi.Exceptions.InvalidFoodTypeException;
import com.tamagotchi.tamagotchi.Exceptions.InvalidPetStatusException;
import com.tamagotchi.tamagotchi.Exceptions.InvalidPetTypeException;
import com.tamagotchi.tamagotchi.Pets.Cat;
import com.tamagotchi.tamagotchi.Pets.Dog;
import com.tamagotchi.tamagotchi.Pets.Fish;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


/**
 * The TamagotchiView class represents the graphical user interface for interacting with the Tamagotchi pet.
 * It allows the user to feed the pet, make it sleep, wake it up, and change the pet type.
 */
public class TamagotchiView extends Application {
private Random rd = new Random();
    private TamagotchiPresenter presenter;
    private int health;
    private int play;
    private Label petFaceLabel, actionLabel;
    private ProgressBar healthBar, playBar;
    private ComboBox<String> foodComboBox;
    private ComboBox<String> petComboBox;
    private Circle petFaceCircle;
    private Text healthText, playText;  // Textual description for ProgressBars
    private TextArea outputArea;
    private Button sleepButton;
    private Button wakeButton;
    private Button feedButton;
    private Button changePetButton;
    private Button playButton;

    /**
     * Constructor to initialize the TamagotchiView with a default presenter.
     */
    public TamagotchiView() {
        // Initialize presenter with a default pet (Cat)
        presenter = new TamagotchiPresenter(new TamagotchiModel(new Cat("Cat")));
        presenter = new TamagotchiPresenter(new TamagotchiModel(new Dog("Dog")));
        presenter = new TamagotchiPresenter(new TamagotchiModel(new Fish("Fish")));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Initialize pet with a starting health and play values
        this.health = 100;
        this.play = 100;

        //Pet face circle setup
        petFaceCircle = new Circle(100, Color.LIGHTGREEN); // initial circle color
        petFaceCircle.setCenterX(150);
        petFaceCircle.setCenterY(150);

        petFaceLabel = new Label(":-)");
        petFaceLabel.setTextFill(Color.BLACK);
        petFaceLabel.setStyle("-fx-font-weight: bold;");
        petFaceLabel.setMaxWidth(Double.MAX_VALUE);
        petFaceLabel.setAlignment(Pos.CENTER);

        // Wrap the pet face label inside a stack pane to overlay it on the circle
        StackPane petFaceWrapper = new StackPane();
        petFaceWrapper.getChildren().addAll(petFaceCircle, petFaceLabel);

        // Health bar
        healthBar = new ProgressBar(1.0);
        healthBar.setPrefWidth(200);
        healthBar.setStyle("-fx-accent: green;");
        healthBar.setProgress(health / 100.0);
        healthBar.setMaxWidth(Double.MAX_VALUE);

        // Play bar
        playBar = new ProgressBar(1.0);
        playBar.setPrefWidth(200);
        playBar.setStyle("-fx-accent: blue;");
        playBar.setProgress(play / 100.0);
        playBar.setMaxWidth(Double.MAX_VALUE);

        // Textual descriptions for health and play progress
        healthText = new Text("Health: " + health + "%");
        playText = new Text("Play: " + play + "%");

        // Action label
        actionLabel = new Label("Actions: ");
        actionLabel.setFont(new Font("Arial", 14));
        actionLabel.setTextFill(Color.BLACK);

        // Buttons for actions
        sleepButton = new Button("Sleep");
        wakeButton = new Button("Wake Up");
        playButton = new Button("Play");
        wakeButton.setDisable(true);
        feedButton = new Button("Feed");
        changePetButton = new Button("Change Pet");

        // ComboBox for food
        foodComboBox = new ComboBox<>();
        foodComboBox.getItems().addAll("Fish", "Bone", "Milk");
        foodComboBox.setValue("Fish");

        // ComboBox for pet type
        petComboBox = new ComboBox<>();
        petComboBox.getItems().addAll("Cat", "Dog", "Fish");
        petComboBox.setValue("Cat");

        // Output Text Area
        outputArea = new TextArea();
        outputArea.setEditable(false); // Disable editing
        outputArea.setPrefHeight(250); // Set a reasonable height for output

        // Event Handlers
        sleepButton.setOnAction(event -> {
            try {
                presenter.sleepAction(petComboBox.getValue(), rd);
            } catch (InvalidPetStatusException e) {
                outputArea.appendText( petComboBox.getValue() + ": " + e.getMessage() + "\n");
            }
            sleepButton.setDisable(true);
            wakeButton.setDisable(false);
            playButton.setDisable(true);
            feedButton.setDisable(true);
        });
        wakeButton.setOnAction(event -> {
            presenter.wakeUpAction(petComboBox.getValue());
            wakeButton.setDisable(true);
            sleepButton.setDisable(false);
            playButton.setDisable(false);
            feedButton.setDisable(false);
        });
        playButton.setOnAction(actionEvent -> {
            /*Es muss hier noch in dem Textfeld informiert werden, dass gespielt wird. Nutze dafür:
            outputArea.appendText(message + "\n");*/
            try {  setPlay(rd.nextInt(20));
                outputArea.appendText(petComboBox.getValue() + " is currently playing" + "\n");
        } catch (InvalidPetStatusException e){
            outputArea.appendText( e.getMessage() + "\n");
        }
        });
        feedButton.setOnAction(event -> {
            String selectedFood = foodComboBox.getValue();
            try {
                presenter.feedAction(selectedFood, rd);
            } catch (InvalidPetStatusException |  InvalidFoodTypeException e) {
                outputArea.appendText( selectedFood + ": " + e.getMessage() + "\n");
            }
        });
        changePetButton.setOnAction(event -> {
            /*Für den Fall, dass ein nicht vorhandenes Tier gewählt wird, benötigt es eine InvalidPetTypeException.
             1. Erstelle dafür ein neues Package "Exceptions" - Done
             2. Erstelle eine neue Exception InvalidPetTypeException - Done
             3. Ergänze das passende Exception-Handling:
             Wo muss die Exception geworfen werden? Wo gefangen? Muss sie gefangen werden? Müssen anderen Dinge ergänzt werden?
             4. über outputArea.appendText(message + "\n"); kannst du in der GUI den Text anzeigen lassen
             - die Alternative wäre eine Fehlermeldung in der Konsole oder eine Fehlermeldung der GUI (hierzu: Google)*/
            String selectedPet = petComboBox.getValue();
            try {
                presenter.changePet(selectedPet);
            } catch (InvalidPetTypeException | InvalidPetStatusException e) {
                outputArea.appendText(selectedPet + ": " + e.getMessage() + "\n");
            }
        });

        // Layout setup
        HBox sleepWakeBox = new HBox(10, sleepButton, wakeButton, playButton);
        sleepWakeBox.setAlignment(Pos.CENTER);

        HBox feedBox = new HBox(10, feedButton, foodComboBox);
        feedBox.setAlignment(Pos.CENTER);

        HBox changePetBox = new HBox(10, changePetButton, petComboBox);
        changePetBox.setAlignment(Pos.CENTER);

        presenter.setView(this);
        // Add all components to the main layout
        vbox.getChildren().addAll(petFaceWrapper, healthBar, healthText, playBar, playText, actionLabel,
                sleepWakeBox, feedBox, changePetBox, outputArea);
        // Scene and Stage setup
        Scene scene = new Scene(vbox, 500, 700);
        primaryStage.setTitle("Tamagotchi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Update the GUI with the latest information about the pet.
     * This method is invoked whenever the pet's state changes.
     * @param message The message to display in the output area (e.g., pet sound).
     * @param petColor The color to represent the pet.
     */
    public void updateView(String message, Color petColor) {
        // Update the output text area with the message (e.g., sound, status)
        outputArea.appendText(message + "\n");

        // Update the pet avatar color to match the pet type
        petFaceCircle.setFill(petColor);

        // Update the smile of the Tamagotchi
        updateHealth();
        updatePlay();
    }

    /*Es gibt bisher noch kein Handling, was passiert, wenn die Gesundheit >100 oder <0 ist.
    Werfe für diesen Fall eine Exception: InvalidPetStatusException - Was musst du dafür tun?
    An welcher Stelle musst du die Exception fangen?*/
    private void updateHealth()  {
        if (this.health > 50) {
            petFaceLabel.setText(":-)");
        } else {
            petFaceLabel.setText(":-(");
        }
    }

    // Es gibt bisher noch kein Handling, was passiert, wenn die Play >100 oder <0 ist.
    // Werfe für diesen Fall eine Exception: InvalidPetStatusException - Was musst du dafür tun?
    // An welcher Stelle musst du die Exception fangen?
    private void updatePlay() {
        if (this.play > 50) {
            petFaceLabel.setText(":-)");
        } else {
            petFaceLabel.setText(":-(");
        }
    }

    public void setHealth(int health) throws InvalidPetStatusException {
        int sum = this.health + health;
        if (sum > 100 || sum < 0) {
            throw new InvalidPetStatusException();
        }
        this.health = sum;
        healthBar.setProgress(this.health / 100.0);
        buttonCheck();
    }

    public void setPlay(int play) throws InvalidPetStatusException {
        int sum = this.play + play;
        if (sum > 100 || sum < 0) {
            throw new InvalidPetStatusException();
        }

        this.play = sum;
        playBar.setProgress(this.play / 100.0);
        buttonCheck();
    }

    private void buttonCheck(){
        sleepButton.setDisable(play < 10);
        changePetButton.setDisable(health < 50 || play < 20);
    }
}
