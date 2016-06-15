package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class testGridPane extends Application {
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Button("0, 4"), 0, 4);
        gridPane.add(new Button("5, 0"), 5, 0);

        Scene scene = new Scene(gridPane, 500, 900);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String argv[]) {
        launch();
    }
}
