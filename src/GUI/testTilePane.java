
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class testTilePane extends Application {
    @Override
    public void start(Stage primaryStage) {
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(10);
        tilePane.setPrefRows(5);
        for(int i = 0; i < 50; i++) {
            tilePane.getChildren().add(new Button(String.valueOf(i)));
        }

        Scene scene = new Scene(tilePane, 500, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String argv[]) {
        launch();
    }
}
