package tv.codely.kata.gildedrose;

class GildedRose {

    private static final String ITEM_AGED_BRIE_NAME = "Aged Brie";
    private static final String ITEM_BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String ITEM_SULFURAS_PASSES_NAME = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(ITEM_AGED_BRIE_NAME)
                    && !item.name.equals(ITEM_BACKSTAGE_PASSES_NAME)) {
                if (item.quality > 0) {
                    if (!item.name.equals(ITEM_SULFURAS_PASSES_NAME)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ITEM_BACKSTAGE_PASSES_NAME)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(ITEM_SULFURAS_PASSES_NAME)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(ITEM_AGED_BRIE_NAME)) {
                    if (!item.name.equals(ITEM_BACKSTAGE_PASSES_NAME)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(ITEM_SULFURAS_PASSES_NAME)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
