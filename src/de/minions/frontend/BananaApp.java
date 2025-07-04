package de.minions.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * <pre>
 *     Demonistriert eine JavaFx Anwendung
 *     File -> Project stucture -> Libraries->+->Java ->JAR->auswählen ->OK * </pre>
 *
 *     --module-path "C:\Users\alfa\Desktop\Bibliotheken\javafx-sdk-21.0.7\lib" --add-modules javafx.controls
 *     --module-path "C:\Users\alfa\Desktop\Bibliotheken\javafx-sdk-21.0.7\lib" --add-modules javafx.controls
 *
 *     Pro Projektte nur einmal extends Application!!!!
 *
 *     Stage: (Fenster) -> Bühne
 *     Stage: (Das was im Fenster angezeigt wird) - Szene
 *     Parent/root (Organisation der Fenster Inhalt) -> Bühnenbild
 *     Parent enthält "Controls" zb Button, TextField ...
 */
public class BananaApp extends Application {
    private Stage primaryStage;
    /**
     * Statt Konstruktor finden werden alle Initioalisierungen hier vorgenommen
     * zb Datenbanktzgriff, ...
     * Wird auromatisch aufgerufen
     */
    @Override
    public void init()  {
        System.out.println("Ist das erste, was von einer Applikation aufgerufen wird (VoR der start-Methode");
        System.out.println("Die Satge : " + primaryStage);
    }

    @Override
    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("BaNanAAAAA"); //Setzt den Fenster Titel
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(7));

        Label begruessung = new Label("Willkommen bei den Minions");
        begruessung.setStyle("-fx-font-family: \"Rock 3D\", system-ui;" +
                "-fx-font-size: 16;");

        Label minion = new Label("Minion");
        TextField minionEingabe  =new TextField();
        root.add(minion, 1, 1);
        root.add(minionEingabe, 2, 1);

        Label chef = new Label("Chef");
        PasswordField chefEingabe = new PasswordField();
        //root.add(minion, 1, 1);
        root.add(chef, 1,2);
        root.add(chefEingabe, 2, 2);

        Button senden = new Button("senden");
        Button abbrechen = new Button("Abbrechen");
        Button wechseln = new Button("Scene wechseln");

        HBox behaelterFuerButtons = new HBox();
        behaelterFuerButtons.getChildren().addAll(senden, abbrechen, wechseln);
        root.add(behaelterFuerButtons, 0,3,3,1);
        root.add(begruessung, 0, 0, 4, 1);

        senden.setOnAction(klick-> System.out.println("Gesendet") );
        abbrechen.setOnAction(klick->minionEingabe.setText(""));

        Scene startSzene =new Scene(root, 500, 500);
        startSzene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Rock+3D&display=swap");
        startSzene.getStylesheets().add("file:resources/style.css");
        primaryStage.setScene(startSzene);
        primaryStage.show();
    }

    @Override
    public void stop()  {
        System.out.println("Wird aufgerufen, wenn die App sauber beendet wird (zb x)");
        System.out.println("Wird zum Aufräumen benutzt.");
    }
}
