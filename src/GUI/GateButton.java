package GUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GateButton extends Button {
    private String type; // cmd or obj
    private String gate; // jkff, rsff, dff, tff, and, or, xor, nand, not
    private String name;
    private ArrayList<GateButton> input;
    private GraphicsContext gc;

    private void maintain(ArrayList<GateButton> queue) {
        if(queue.size() >= 2 && queue.get(queue.size() - 1).getType() == "obj") {
            GateButton last = queue.get(queue.size() - 1);
            GateButton second = queue.get(queue.size() - 2);

            if(second.getType() == "obj" && last.getGate() != "" && second.getGate() != "") {
                // draw line!!!!
                if(!last.isInputFull() && !(second.getGate() == "z")) {
                    GridPane gridPane = (GridPane) last.getParent();
                    int prevRowIndex = gridPane.getRowIndex(second);
                    int lastRowIndex = gridPane.getRowIndex(last);
                    int prevColIndex = gridPane.getColumnIndex(second);
                    int lastColIndex = gridPane.getColumnIndex(last);
                    if(prevRowIndex != lastRowIndex || prevColIndex != lastColIndex) {
                        gc.strokeLine(70 + prevColIndex * 70, 25 + prevRowIndex * 40, 10 + lastColIndex * 70, 25 + lastRowIndex * 40);
                        last.setInput(second);
                    }
                }
            }
            else if(second.getType() == "cmd" && last.getGate() == "")
                last.setGate(second.getGate());

            queue.clear();
        }
    }

    public GateButton(String _type, String _gate, ArrayList<GateButton> queue, GraphicsContext _gc) {
        super(_gate);
        type = _type;
        gate = _gate;
        gc = _gc;
        input = new ArrayList<>();
        super.setOnAction((event -> {
            queue.add(this);
            maintain(queue);
        }));
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<GateButton> getInput() {
        return input;
    }

    public boolean isInputFull() {
        switch(gate) {
            case "x":
                return true;
            case "jkFF": case"rsFF":
                if(input.size() >= 2)
                    return true;
                break;
            case "dFF": case "tFF": case "not":case "z":
                if(input.size() >= 1)
                    return true;
                break;
        }
        return false;
    }

    public void setInput(GateButton _input) {
        input.add(_input);
    }

    public String getType() {
        return type;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String _gate) {
        gate = _gate;
        super.setText(gate);
        super.setStyle("-fx-border-width: 1px");
    }
}
