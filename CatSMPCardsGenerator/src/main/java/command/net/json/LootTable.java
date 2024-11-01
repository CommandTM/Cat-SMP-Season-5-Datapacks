package command.net.json;

import java.util.LinkedList;

public class LootTable {
    public LootTable() {
        pools = new LinkedList<>();
        pools.add(new Pool());
    }

    public void addEntry(Entry entry){
        pools.getFirst().entries.add(entry);
    }

    LinkedList<Pool> pools;
}
