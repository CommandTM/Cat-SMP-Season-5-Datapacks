package command.net;

import com.google.gson.Gson;
import command.net.json.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.*;

public class Main {
    final static public int NUMBER_OF_CARDS = 72;

    public static void main(String[] args) throws IOException {
        LootTable common = new LootTable();
        LootTable rare = new LootTable();
        LootTable epic = new LootTable();
        LootTable legendary = new LootTable();

        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(frame);
        File selFile = fileChooser.getSelectedFile();
        Reader reader = new FileReader(selFile);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(reader);

        for (CSVRecord record : records) {
            switch (record.get(11)){
                case "Common" -> {
                    Function loreFunction;
                    if (record.get(10).equals("N/A")){
                        loreFunction = new Function(new Lore(record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"));
                    } else {
                        loreFunction = new Function(
                                new Lore(
                                    record.get(10),
                                        "#FF55FF"
                                ),
                                new Lore(
                                        record.get(4) + " (" + record.get(2) + "/" + NUMBER_OF_CARDS +")"
                                )
                        );
                    }

                    String cost = "";
                    if (record.get(9).equals("N/A") && record.get(8).equals("N/A")){
                        cost = "(" + record.get(7) + ")";
                    } else {
                        cost = "("+record.get(7)+"/"+record.get(8)+"/"+record.get(9)+")";
                    }

                    common.addEntry(new Entry(
                            new Function(Integer.parseInt(record.get(0))),
                            new Function(new Name(
                                    record.get(3) + " ",
                                    "#EEC39A",
                                    false,
                                    new Extra(
                                            cost
                                    )
                            )
                            ),
                            loreFunction
                    ));
                }
                case "Rare" -> {
                    Function loreFunction;
                    if (record.get(10).equals("N/A")){
                        loreFunction = new Function(new Lore(record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"));
                    } else {
                        loreFunction = new Function(
                                new Lore(
                                        record.get(10),
                                        "#1bd262"
                                ),
                                new Lore(
                                        record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"
                                )
                        );
                    }

                    String cost = "";
                    if (record.get(9).equals("N/A") && record.get(8).equals("N/A")){
                        cost = "(" + record.get(7) + ")";
                    } else {
                        cost = "("+record.get(7)+"/"+record.get(8)+"/"+record.get(9)+")";
                    }

                    rare.addEntry(new Entry(
                            new Function(Integer.parseInt(record.get(0))),
                            new Function(new Name(
                                    record.get(3) + " ",
                                    "#EEC39A",
                                    false,
                                    new Extra(
                                            cost
                                    )
                            )
                            ),
                            loreFunction
                    ));
                }
                case "Epic" -> {
                    Function loreFunction;
                    if (record.get(10).equals("N/A")){
                        loreFunction = new Function(new Lore(record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"));
                    } else {
                        loreFunction = new Function(
                                new Lore(
                                        record.get(10),
                                        "#3c6ef9"
                                ),
                                new Lore(
                                        record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"
                                )
                        );
                    }

                    String cost = "";
                    if (record.get(9).equals("N/A") && record.get(8).equals("N/A")){
                        cost = "(" + record.get(7) + ")";
                    } else {
                        cost = "("+record.get(7)+"/"+record.get(8)+"/"+record.get(9)+")";
                    }

                    epic.addEntry(new Entry(
                            new Function(Integer.parseInt(record.get(0))),
                            new Function(new Name(
                                    record.get(3) + " ",
                                    "#EEC39A",
                                    false,
                                    new Extra(
                                            cost
                                    )
                            )
                            ),
                            loreFunction
                    ));
                }
                case "Legendary" -> {
                    Function loreFunction;
                    if (record.get(10).equals("N/A")){
                        loreFunction = new Function(new Lore(record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"));
                    } else {
                        loreFunction = new Function(
                                new Lore(
                                        record.get(10),
                                        "#e69138"
                                ),
                                new Lore(
                                        record.get(4) + " (" + record.get(2) + "/"+NUMBER_OF_CARDS+")"
                                )
                        );
                    }

                    String cost = "";
                    if (record.get(9).equals("N/A") && record.get(8).equals("N/A")){
                        cost = "(" + record.get(7) + ")";
                    } else {
                        cost = "("+record.get(7)+"/"+record.get(8)+"/"+record.get(9)+")";
                    }

                    legendary.addEntry(new Entry(
                            new Function(Integer.parseInt(record.get(0))),
                            new Function(new Name(
                                    record.get(3) + " ",
                                    "#EEC39A",
                                    false,
                                    new Extra(
                                            cost
                                    )
                            )
                            ),
                            loreFunction
                    ));
                }
            }
        }

        Gson gson = new Gson();
        System.out.println(gson.toJson(common));
        System.out.println(gson.toJson(rare));
        System.out.println(gson.toJson(epic));
        System.out.println(gson.toJson(legendary));
        common.becomeFoil();
        rare.becomeFoil();
        epic.becomeFoil();
        legendary.becomeFoil();
        System.out.println(gson.toJson(common));
        System.out.println(gson.toJson(rare));
        System.out.println(gson.toJson(epic));
        System.out.println(gson.toJson(legendary));

        System.exit(0);
    }
}