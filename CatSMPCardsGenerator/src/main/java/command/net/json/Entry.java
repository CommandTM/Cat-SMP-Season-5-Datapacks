package command.net.json;

import java.util.LinkedList;

public class Entry {
    public Entry(Function cmdFunction, Function nameFunction, Function loreFunction){
        type = "minecraft:item";
        name = "minecraft:paper";
        functions = new LinkedList<>();
        functions.add(cmdFunction);
        functions.add(nameFunction);
        functions.add(loreFunction);
    }

    String type;
    String name;
    LinkedList<Function> functions;
}
