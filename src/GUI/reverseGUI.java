package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class reverseGUI extends Application {
    public void start(Stage stage) {
        ArrayList<GateButton> queue = new ArrayList<>();

        BorderPane borderPane = new BorderPane();

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().add(new GateButton("cmd", "jkFF", queue));
        hBox.getChildren().add(new GateButton("cmd", "rsFF", queue));
        hBox.getChildren().add(new GateButton("cmd", "dFF", queue));
        hBox.getChildren().add(new GateButton("cmd", "tFF", queue));
        hBox.getChildren().add(new GateButton("cmd", "and", queue));
        hBox.getChildren().add(new GateButton("cmd", "or", queue));
        hBox.getChildren().add(new GateButton("cmd", "xor", queue));
        hBox.getChildren().add(new GateButton("cmd", "nand", queue));
        hBox.getChildren().add(new GateButton("cmd", "not", queue));
        borderPane.setTop(hBox);

        StackPane stackPane = new StackPane();
        borderPane.setCenter(stackPane);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                gridPane.add(new GateButton("obj", "", queue), i, j);
        stackPane.getChildren().add(gridPane);

        Scene scene = new Scene(borderPane, 640, 380);
        scene.getStylesheets().add("GUI/style.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String argv[]) {
        launch();
    }
}
