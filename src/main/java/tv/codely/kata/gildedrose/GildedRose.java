package tv.codely.kata.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE)
                    || item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES)) {
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
            } else {
                if (item.quality > 0) {
                    if (item.name.equals(SULFURAS)) {
                    } else {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if (item.name.equals(SULFURAS)) {
            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
