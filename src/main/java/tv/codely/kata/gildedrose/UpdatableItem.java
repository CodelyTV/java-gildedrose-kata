package tv.codely.kata.gildedrose;

final class UpdatableItem extends Item {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int AGED_BRIE_DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD = 0;

    private static final int BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10;
    private static final int BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5;
    private static final int BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD = 0;

    private static final int DEFAULT_ITEM_DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private Item item;

    UpdatableItem(Item item) {
        super(item.name, item.sellIn, item.quality);

        this.item = item;
    }

    void update() {
        switch (item.name) {
            case AGED_BRIE:
                decreaseSellIn();
                updateAgedBrieQuality();
                break;
            case BACKSTAGE_PASSES:
                decreaseSellIn();
                updateBackstagePassesQuality();
                break;
            case SULFURAS:
                break;
            default:
                decreaseSellIn();
                updateDefaultItemQuality();
                break;
        }
    }

    private void decreaseSellIn() {
        item.sellIn -= 1;
    }

    private void updateAgedBrieQuality() {
        increaseQuality();

        if (item.sellIn < AGED_BRIE_DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD) {
            increaseQuality();
        }
    }

    private void updateBackstagePassesQuality() {
        increaseQuality();

        if (item.sellIn < BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            increaseQuality();
        }

        if (item.sellIn < BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            increaseQuality();
        }

        if (item.sellIn < BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD) {
            resetQuality();
        }
    }

    private void updateDefaultItemQuality() {
        decreaseQuality();

        if (item.sellIn < DEFAULT_ITEM_DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD) {
            decreaseQuality();
        }
    }

    private void resetQuality() {
        item.quality = 0;
    }

    private void increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1;
        }
    }

    private void decreaseQuality() {
        if (item.quality > MIN_QUALITY) {
            item.quality -= 1;
        }
    }
}
