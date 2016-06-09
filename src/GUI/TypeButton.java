package GUI;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class TypeButton extends Button {
    private String type;

    public TypeButton(String _type, ArrayList<Button> queue) {
        super(_type);
        type = _type;
        queue.add(this);
    }

    public String getType() {
        return type;
    }
}
