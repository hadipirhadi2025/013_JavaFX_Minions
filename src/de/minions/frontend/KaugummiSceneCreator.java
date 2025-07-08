package de.minions.frontend;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Eine Scene soll erstellt erstellt werden, die eine Animation anzeigt:
 * Win Kreis enthält ein Bild. dieser Kreis wird vergrößert, und dabei uns Bild mit
 * Hier nicht extends Application(!) nur eine(!) Application pro Anwendung!
 */
public class KaugummiSceneCreator  {

    private  Scene  kaugummiScene;
    /** Kann sdie Große eines Nodes ändern. Scale.
     * Nodes können sein: Button, TextField, ImageView, Circle
     */
    private ScaleTransition animation = new ScaleTransition() ;

    /**
     * Ruft die Methode erstelleAnimation auf, um sicher zu stellen,
     * dass sie getKaugummiScene nicht null zurückgibt
     */

    /** stage transition kontroller*/
    private Stage myStage;

    public void setPreviousScen(Scene previousScen) {
        this.previousScen = previousScen;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }
    /** speicher lästest Scene*/
    private Scene previousScen;
    public KaugummiSceneCreator(){
        erstellenAnimation();
    }

    private void erstellenAnimation() {
        animation.setDuration(Duration.seconds(4));
        animation.setCycleCount(4);
        animation.setAutoReverse(true);

        animation.setByX(4.5);
        animation.setByY(2.5);

        Circle kreis = new Circle();
        kreis.setRadius(20);
        kreis.setCenterX(250);
        kreis.setCenterY(250);

        //Image bilsDatei = new Image("file:resources/Hund.png");
        Image bilsDatei = new Image("file:resources/s-l1600.jpg");
        ImagePattern dasMuster = new ImagePattern(bilsDatei);
        kreis.setFill((dasMuster));

        animation.setNode(kreis);


        Group parent = new Group();
        parent.getChildren().addAll(kreis);
        kaugummiScene  = new Scene(parent, 500, 500);
    }

    public void startDerAnimation(){
        animation.play();
        //animation.setOnFinished(ende-> Platform.exit());
        animation.setOnFinished(ende->{
            if(myStage!=null && previousScen!=null){
                myStage.setScene(previousScen);
            }else{
                Platform.exit();
            }
        });

    }

    /**
     * Kann aufgerufen werden, zb in der BananaApp um fie hier erstellt Scene
     * auf der primaryStage aufzuziehen
     *
     * @return die hier erstelle Scene
     */
    public Scene getKaugummiScene() {
        return kaugummiScene;
    }




}
