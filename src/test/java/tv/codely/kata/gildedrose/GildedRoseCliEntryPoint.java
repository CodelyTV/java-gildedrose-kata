package tv.codely.kata.gildedrose;

import java.util.Arrays;
import java.util.List;

public class GildedRoseCliEntryPoint {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<Item> items = Arrays.asList(
                ItemFactory.basedOn("+5 Dexterity Vest", 10, 20), //
                ItemFactory.basedOn("Aged Brie", 2, 0), //
                ItemFactory.basedOn("Elixir of the Mongoose", 5, 7), //
                ItemFactory.basedOn("Sulfuras, Hand of Ragnaros", 0, 80), //
                ItemFactory.basedOn("Sulfuras, Hand of Ragnaros", -1, 80),
                ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                ItemFactory.basedOn("Conjured Mana Cake", 3, 6)
        );

        GildedRose app = new GildedRose();

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality(items);
        }
    }

}
