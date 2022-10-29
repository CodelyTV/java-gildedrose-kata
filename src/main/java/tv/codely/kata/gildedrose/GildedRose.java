package tv.codely.kata.gildedrose;

class GildedRose {

  private static final String ITEM_AGED_BRIE_NAME = "Aged Brie";
  private static final String ITEM_BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
  private static final String ITEM_SULFURAS_PASSES_NAME = "Sulfuras, Hand of Ragnaros";
  private final Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (!item.name.equals(ITEM_SULFURAS_PASSES_NAME)) {
        decreaseSellIn(item);
      }
      switch (item.name) {
        case ITEM_AGED_BRIE_NAME:
          increaseQuality(item);

          if (item.sellIn < 0) {
            increaseQuality(item);
          }
        case ITEM_BACKSTAGE_PASSES_NAME:
          increaseQuality(item);

          if (item.sellIn < 10) {
            increaseQuality(item);
          }
          if (item.sellIn < 5) {
            increaseQuality(item);
          }
          if (item.sellIn < 0) {
            item.quality = 0;
          }
          break;
        case ITEM_SULFURAS_PASSES_NAME:
          break;
        default:
          decreaseQuality(item);
          if (item.sellIn < 0) {
            decreaseQuality(item);
          }
      }
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality += 1;
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality -= 1;
    }
  }

  private void decreaseSellIn(Item item) {
    item.sellIn -= 1;
  }
}
