package command.net.json;

public class Lore {
    public Lore(String text){
        this.text = text;
        color = "#555555";
    }

    public Lore(String text, String color){
        this.text = text;
        this.color = color;
        italic = false;
    }

    String text;
    String color;
    Boolean italic;
}
