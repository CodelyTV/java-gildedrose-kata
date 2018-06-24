package tv.codely.kata.gildedrose;

final class AgedBrie extends Item {
    private static final int DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD = 0;

    AgedBrie(final ItemName name, final ItemSellIn sellIn, final ItemQuality quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        decreaseSellIn();

        increaseQuality();

        if (hasToBeSoldInLessThan(DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD)) {
            increaseQuality();
        }
    }
}
