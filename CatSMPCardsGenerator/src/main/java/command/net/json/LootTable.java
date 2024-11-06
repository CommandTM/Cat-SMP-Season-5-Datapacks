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

    public void becomeFoil(){
        for (Entry entry : pools.getFirst().entries){
            entry.functions.add(new Function());
        }
    }

    public void clone(LootTable clonee){
        pools.clear();
        pools.addAll(clonee.pools);
    }

    LinkedList<Pool> pools;
}
