package tv.codely.kata.gildedrose;

final class ItemQualityOutOfRangeException extends IllegalArgumentException {
    ItemQualityOutOfRangeException(final Integer qualityCandidate) {
        super("Tried to set an ItemQuality of " + qualityCandidate +  " which is outside the valid range.");
    }
}
