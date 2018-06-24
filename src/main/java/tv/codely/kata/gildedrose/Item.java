package tv.codely.kata.gildedrose;

abstract class Item {
    private ItemName name;
    private ItemSellIn sellIn;
    private ItemQuality quality;

    Item(final ItemName name, final ItemSellIn sellIn, final ItemQuality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    abstract void update();

    ItemSellIn sellIn() {
        return sellIn;
    }

    ItemQuality quality() {
        return quality;
    }

    void decreaseSellIn() {
        sellIn = sellIn.decrease();
    }

    Boolean hasToBeSoldInLessThan(Integer days) {
        return sellIn.isLessThan(days);
    }

    void increaseQuality() {
        quality = quality.increase();
    }

    void decreaseQuality() {
        quality = quality.decrease();
    }

    void resetQuality() {
        quality = quality.reset();
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
