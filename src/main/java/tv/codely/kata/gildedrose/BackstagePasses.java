package tv.codely.kata.gildedrose;

final class BackstagePasses extends Item {
    private static final int DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10;
    private static final int TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5;
    private static final int QUALITY_RESET_SELL_IN_THRESHOLD = 0;

    BackstagePasses(final ItemName name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        decreaseSellIn();

        increaseQuality();

        if (sellIn() < DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            increaseQuality();
        }

        if (sellIn() < TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            increaseQuality();
        }

        if (sellIn() < QUALITY_RESET_SELL_IN_THRESHOLD) {
            resetQuality();
        }
    }
}
