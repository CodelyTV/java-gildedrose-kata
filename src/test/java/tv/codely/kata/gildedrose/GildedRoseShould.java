package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseShould {
    private List<UpdatableItem> listOf(UpdatableItem item) {
        return new ArrayList<UpdatableItem>(){{
            add(item);
        }};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = new Item("whatever", 10, 0);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(9, whateverItem.sellIn);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = new Item("whatever", 1, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(9, whateverItem.quality);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = new Item("whatever", 0, 10);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(8, whateverItem.quality);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = new Item("whatever", 0, 0);
        UpdatableItem updatableItem = UpdatableItemFactory.basedOn(whateverItem);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableItem));

        assertEquals(0, whateverItem.quality);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new Item("Aged Brie", 5, 1);
        UpdatableItem updatableAgedBrie = UpdatableItemFactory.basedOn(agedBrie);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableAgedBrie));

        assertEquals(2, agedBrie.quality);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);
        UpdatableItem updatableAgedBrie = UpdatableItemFactory.basedOn(agedBrie);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableAgedBrie));

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);
        UpdatableItem updatableSulfuras = UpdatableItemFactory.basedOn(sulfuras);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableSulfuras));

        assertEquals(25, sulfuras.quality);
        assertEquals(0, sulfuras.sellIn);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        UpdatableItem updatableBackstagePasses = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableBackstagePasses));

        assertEquals(21, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        UpdatableItem updatableBackstagePasses = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableBackstagePasses));

        assertEquals(22, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        UpdatableItem updatableBackstagePasses = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableBackstagePasses));

        assertEquals(23, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        UpdatableItem updatableBackstagePasses = UpdatableItemFactory.basedOn(backstagePasses);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(updatableBackstagePasses));

        assertEquals(0, backstagePasses.quality);
    }
}
