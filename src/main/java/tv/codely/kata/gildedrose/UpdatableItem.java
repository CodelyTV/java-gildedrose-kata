package tv.codely.kata.gildedrose;

abstract class UpdatableItem extends Item {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    Item item;

    UpdatableItem(Item item) {
        super(item.name, item.sellIn, item.quality);

        this.item = item;
    }

    abstract void update();

    void decreaseSellIn() {
        item.sellIn -= 1;
    }

    void increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1;
        }
    }

    void decreaseQuality() {
        if (item.quality > MIN_QUALITY) {
            item.quality -= 1;
        }
    }
}
