package command.net.json;

public class Name {
    public Name(String text, String color, Boolean italic, Extra extra){
        this.text = text;
        this.color = color;
        this.italic = italic;
        this.extra = extra;
    }

    String text;
    String color;
    Boolean italic;
    Extra extra;
}
