package tv.codely.kata.gildedrose;

class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatableItem = UpdatableItemFactory.basedOn(item);

            updatableItem.update();
        }
    }
}
