package command.net.json;

import java.util.LinkedList;

public class Name {
    public Name(String text, String color, Boolean italic, Extra extra){
        this.text = text;
        this.color = color;
        this.italic = italic;
        this.extra = new LinkedList<>();
        this.extra.add(extra);
    }

    String text;
    String color;
    Boolean italic;
    LinkedList<Extra> extra;
}
