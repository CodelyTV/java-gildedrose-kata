package tv.codely.kata.gildedrose;

import java.util.Objects;

final class ItemName {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final String value;

    ItemName(final String value) {
        this.value = value;
    }

    Boolean isAgedBrie() {
        return AGED_BRIE.equals(value);
    }

    Boolean isBackstagePasses() {
        return BACKSTAGE_PASSES.equals(value);
    }

    Boolean isSulfuras() {
        return SULFURAS.equals(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemName)) return false;
        final ItemName itemName = (ItemName) o;
        return Objects.equals(value, itemName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
