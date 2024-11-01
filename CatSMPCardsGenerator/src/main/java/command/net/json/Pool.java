package command.net.json;

import java.util.LinkedList;

public class Pool {
    public Pool(){
        rolls = 1;
        entries = new LinkedList<>();
    }

    int rolls;
    LinkedList<Entry> entries;
}
