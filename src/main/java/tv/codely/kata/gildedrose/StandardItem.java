package tv.codely.kata.gildedrose;

final class StandardItem extends Item {
    private static final int DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD = 0;

    StandardItem(final ItemName name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        decreaseSellIn();
        decreaseQuality();

        if (sellIn() < DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD) {
            decreaseQuality();
        }
    }
}
