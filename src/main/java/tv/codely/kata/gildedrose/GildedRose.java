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
            if (!item.name.equals(SULFURAS)) {
                decreaseSellIn(item);
            }

            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrieQuality(item);
                    break;
                case BACKSTAGE_PASSES:
                    updateBackstagePassesQuality(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    updateDefaultItemQuality(item);
                    break;
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void updateAgedBrieQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePassesQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 10) {
            increaseQuality(item);
        }

        if (item.sellIn < 5) {
            increaseQuality(item);
        }

        if (item.sellIn < 0) {
            resetQuality(item);
        }
    }

    private void updateDefaultItemQuality(Item item) {
        decreaseQuality(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void resetQuality(Item item) {
        item.quality = 0;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
