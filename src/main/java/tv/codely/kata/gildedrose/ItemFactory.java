package tv.codely.kata.gildedrose;

final class ItemFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    static Item basedOn(final String name, final int sellIn, final int quality) {
        switch (name) {
            case AGED_BRIE:
                return new AgedBrie(name, sellIn, quality);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(name, sellIn, quality);
            case SULFURAS:
                return new Sulfuras(name, sellIn, quality);
            default:
                return new StandardItem(name, sellIn, quality);
        }
    }
}
