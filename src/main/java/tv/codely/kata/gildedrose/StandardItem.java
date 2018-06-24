package tv.codely.kata.gildedrose;

final class StandardItem extends Item {
    private static final int DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    StandardItem(final ItemName name, final ItemSellIn sellIn, final ItemQuality quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        decreaseSellIn();
        decreaseQuality();

        if (hasToBeSoldInLessThan(DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD)) {
            decreaseQuality();
        }
    }
}
