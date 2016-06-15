package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class testCanvas extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(640, 380);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.save();
        //gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.strokeLine(5, 5, 600, 300);
        //gc.restore();

        Pane pane = new Pane(canvas);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String argv[]) {
        launch();
    }
}
