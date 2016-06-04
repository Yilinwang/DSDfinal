package GUI;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class GateButton extends Button {
    private String type; // cmd or obj
    private String gate; // jkff, rsff, dff, tff, and, or, xor, nand, not
    private ArrayList<GateButton> input;

    private void maintain(ArrayList<GateButton> queue) {
        if(queue.size() >= 2 && queue.get(queue.size() - 1).getType() == "obj") {
            GateButton last = queue.get(queue.size() - 1);
            GateButton second = queue.get(queue.size() - 2);

            if(second.getType() == "obj" && last.getGate() != "" && second.getGate() != "") {
                // draw line!!!!
                if(!last.isInputFull())
                    last.setInput(second);
            }
            else if(second.getType() == "cmd" && last.getGate() == "")
                last.setGate(second.getGate());

            queue.clear();
        }
    }

    public GateButton(String _type, String _gate, ArrayList<GateButton> queue) {
        super(_gate);
        type = _type;
        gate = _gate;
        input = new ArrayList<>();
        super.setOnAction((event -> {
            queue.add(this);
            maintain(queue);
        }));
    }

    public boolean isInputFull() {
        switch(gate) {
            case "jkFF": case"rsFF":
                if(input.size() == 2)
                    return true;
            case "dFF": case "tFF": case"not":
                if(input.size() == 1)
                    return true;
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
    }
}
