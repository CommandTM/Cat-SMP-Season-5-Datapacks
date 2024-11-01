package command.net.json;

import java.util.LinkedList;

public class Function {
    public Function(int value) {
        function = "minecraft:set_custom_model_data";
        this.value = value;
    }

    public Function(Name name) {
        function = "minecraft:set_name";
        entity = "this";
        this.name = name;
    }

    public Function(Lore lore) {
        function = "minecraft:set_lore";
        entity = "this";
        mode = "replace_all";
        this.lore = new LinkedList<>();
        this.lore.add(lore);
    }

    public Function(Lore abilityLore, Lore numberLore) {
        function = "minecraft:set_lore";
        entity = "this";
        mode = "replace_all";
        this.lore = new LinkedList<>();
        this.lore.add(abilityLore);
        this.lore.add(numberLore);
    }

    String function;
    Integer value;
    String entity;
    Name name;
    LinkedList<Lore> lore;
    String mode;
}
