package tv.codely.kata.gildedrose;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatableItem = new UpdatableItem(item);

            updatableItem.update();
        }
    }
}
