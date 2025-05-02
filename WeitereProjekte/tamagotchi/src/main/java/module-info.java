module com.tamagotchi.tamagotchi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tamagotchi.tamagotchi to javafx.fxml;
    exports com.tamagotchi.tamagotchi;
}