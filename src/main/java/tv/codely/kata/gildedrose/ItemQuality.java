package tv.codely.kata.gildedrose;

import java.util.Objects;

final class ItemQuality {
    private static final int MAX_VALUE = 50;
    private static final int MIN_VALUE = 0;

    private final Integer value;

    ItemQuality(final Integer value) throws ItemQualityOutOfRangeException {
        if (value < MIN_VALUE || value > MAX_VALUE) throw new ItemQualityOutOfRangeException(value);

        this.value = value;
    }

    ItemQuality increase() {
        if (value == MAX_VALUE) {
            return this;
        }

        return new ItemQuality(value + 1);
    }

    ItemQuality decrease() {
        if (value == MIN_VALUE) {
            return this;
        }

        return new ItemQuality(value - 1);
    }

    ItemQuality reset() {
        return new ItemQuality(MIN_VALUE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemQuality)) return false;
        final ItemQuality that = (ItemQuality) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
