package tv.codely.kata.gildedrose;

import java.util.List;

final class GildedRose {
    void updateQuality(List<UpdatableItem> items) {
        items.forEach(UpdatableItem::update);
    }
}
