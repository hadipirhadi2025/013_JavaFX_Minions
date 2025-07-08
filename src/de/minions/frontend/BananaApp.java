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
 *     Demonstriert eine JavaFX Anwendung
 *     File → Project Structure → Libraries → + → Java → JAR auswählen → OK
 *
 *      --module-path "C:\Users\alfa\Desktop\Bibliotheken\javafx-sdk-21.0.7\lib" --add-modules javafx.controls
 *
 *      Pro Projekte nur einmal extends Application!!!!
 *
 *      Stage: (Fenster) -> Bühne
 *      Scene: (Das was im Fenster angezeigt wird) -> Szene
 *      Parent/root (Organisation der Fenster Inhalte) -> Bühnenbild
 *      Parent enthält "Conrols" zb Button, TextField...
 * </pre>
 */
public class BananaApp extends Application {

    private Stage primaryStage;
    private KaugummiSceneCreator kaugummiSceneCreator;
    /**
     * Statt Konstruktor finden  werden alle Initialisierungen hier vorgenommen
     * zb Datenbankzugriff, ....
     * Wird automatisch aufgerufen
     */
    @Override
    public void init() {
        System.out.println("Ist das erste, was von einer Applikation aufgerufen wird (VOR der start-Methode)");
        System.out.println("Die Stage: " + primaryStage);
        kaugummiSceneCreator = new KaugummiSceneCreator();
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        primaryStage.setTitle("BANANAAAAA");//Setzt den Fenster Titel
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(7));

        Label begruessung = new Label("Willkommen");
        root.add(begruessung,0,0,4,1);
        begruessung.setStyle("-fx-font-family: \"Rock 3D\", system-ui;" +
                "-fx-font-size: 35;");

        Label minion = new Label("Minion");
        TextField minionEingabe = new TextField();
        root.add(minion,1,1);
        root.add(minionEingabe,2,1);

        Label chef = new Label("Chef");
        chef.setId("chef");
        PasswordField chefEingabe = new PasswordField();
        chefEingabe.setOnZoom(zoom-> System.out.println("zoom"));
        root.add(chef,1,2);
        root.add(chefEingabe,2,2);

        Button senden = new Button("senden");
        Button abbrechen = new Button("Abbrechen");
        Button wechseln = new Button("Scene wechseln");
        wechseln.setOnAction(klick-> anzegenKaugummiAnimation());

        HBox behaelterFuerButtons = new HBox();
        behaelterFuerButtons.getChildren().addAll(senden, abbrechen, wechseln);
        root.add(behaelterFuerButtons,0,3,3,1);

        senden.setOnAction(klick -> System.out.println("Gesendet"));
        abbrechen.setOnAction(klick -> minionEingabe.setText(""));

        Scene startSzene = new Scene(root,500,500);
        startSzene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Rock+3D&display=swap");
        startSzene.getStylesheets().add("file:resources/style.css");
        primaryStage.setScene(startSzene);
        // sent aktuelle Stage und Scene im nächst Scene
        kaugummiSceneCreator.setMyStage(primaryStage);
        kaugummiSceneCreator.setPreviousScen(startSzene);
        primaryStage.show();
    }

    /**
     *
     */
    private void anzegenKaugummiAnimation(){
        System.out.println("Die Kaugummianimation wird angezeigt.");

        Scene kaugummiScene = kaugummiSceneCreator.getKaugummiScene();
        primaryStage.setScene(kaugummiScene);
        kaugummiSceneCreator.startDerAnimation();
        System.out.println("before goto stop leave ahndel here");

    }

    @Override
    public void stop(){
        System.out.println("Wird aufgerufen, wenn die App sauber beendet wird (zb x)");
        System.out.println("Wird zum Aufräumen benutzt.");
    }

}
