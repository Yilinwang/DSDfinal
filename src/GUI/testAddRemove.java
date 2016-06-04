import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class testAddRemove extends Application {
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(900);
        gridPane.setVgap(500);

        for(int i = 3; i < 5; i++) {
            /*
            Button tmp = new Button(String.valueOf(i));
            GridPane.setConstraints(tmp, i, i);
            gridPane.getChildren().add(tmp);
            */
            gridPane.add(new Button(String.valueOf(i)), i, i);
        }
        ColumnConstraints c = new ColumnConstraints();
        c.setPercentWidth(1);
        RowConstraints r = new RowConstraints();
        r.setPercentHeight(1);
        gridPane.getRowConstraints().addAll(r);
        gridPane.getColumnConstraints().addAll(c);

        /*
        Button button = new Button("O.o");
        gridPane.add(button, 0, 3);
        button.setOnAction((event -> {
            Button button2 = new Button(">.<");
            gridPane.add(button2, 0, 4);
            button2.setOnAction((event1 -> {
                Button button3 = new Button("^^");
                gridPane.add(button3, 0, 5);
                button3.setOnAction((event2 -> {
                    gridPane.getChildren().remove(button);
                }));
            }));
        }));
        */

        Scene scene = new Scene(gridPane, 500, 900);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String argv) {
        launch();
    }
}
