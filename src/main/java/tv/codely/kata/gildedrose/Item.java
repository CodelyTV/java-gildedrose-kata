package tv.codely.kata.gildedrose;

abstract class Item {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private ItemName name;

    private int sellIn;

    private int quality;

    Item(final ItemName name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract void update();

    int sellIn() {
        return sellIn;
    }

    int quality() {
        return quality;
    }

    void decreaseSellIn() {
        sellIn -= 1;
    }

    void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality += 1;
        }
    }

    void decreaseQuality() {
        if (quality > MIN_QUALITY) {
            quality -= 1;
        }
    }

    void resetQuality() {
        quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
