package de.minions.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
    @Override
    public void start(Stage primaryStage)  {
        primaryStage.setTitle("NananAAAAA"); //Setzt den Fenster Titel
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(7));

        Label begruessung = new Label("Willkommen bei den Minions");
        root.add(begruessung, 0, 0);
        Scene startSzene =new Scene(root, 500, 500);
        primaryStage.setScene(startSzene);
        primaryStage.show();
    }
}
