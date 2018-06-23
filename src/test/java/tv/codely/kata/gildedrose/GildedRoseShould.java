package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseShould {
    private List<Item> listOf(Item item) {
        return new ArrayList<Item>(){{
            add(item);
        }};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = ItemFactory.basedOn("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemSellIn expectedSellIn = new ItemSellIn(9);
        assertEquals(expectedSellIn, whateverItem.sellIn());
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = ItemFactory.basedOn("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        assertEquals(9, whateverItem.quality());
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = ItemFactory.basedOn("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        assertEquals(8, whateverItem.quality());
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = ItemFactory.basedOn("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        assertEquals(0, whateverItem.quality());
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = ItemFactory.basedOn("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        assertEquals(2, agedBrie.quality());
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = ItemFactory.basedOn("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        assertEquals(50, agedBrie.quality());
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = ItemFactory.basedOn("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(sulfuras));

        assertEquals(25, sulfuras.quality());

        ItemSellIn expectedSellIn = new ItemSellIn(0);
        assertEquals(expectedSellIn, sulfuras.sellIn());
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        assertEquals(21, backstagePasses.quality());
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        assertEquals(22, backstagePasses.quality());
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        assertEquals(23, backstagePasses.quality());
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        assertEquals(0, backstagePasses.quality());
    }
}
