package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

        ItemQuality expectedQuality = new ItemQuality(9);
        assertEquals(expectedQuality, whateverItem.quality());
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = ItemFactory.basedOn("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemQuality expectedQuality = new ItemQuality(8);
        assertEquals(expectedQuality, whateverItem.quality());
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = ItemFactory.basedOn("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(expectedQuality, whateverItem.quality());
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = ItemFactory.basedOn("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        ItemQuality expectedQuality = new ItemQuality(2);
        assertEquals(expectedQuality, agedBrie.quality());
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = ItemFactory.basedOn("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        ItemQuality expectedQuality = new ItemQuality(50);
        assertEquals(expectedQuality, agedBrie.quality());
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = ItemFactory.basedOn("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(sulfuras));

        ItemQuality expectedQuality = new ItemQuality(25);
        assertEquals(expectedQuality, sulfuras.quality());

        ItemSellIn expectedSellIn = new ItemSellIn(0);
        assertEquals(expectedSellIn, sulfuras.sellIn());
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        ItemQuality expectedQuality = new ItemQuality(21);
        assertEquals(expectedQuality, backstagePasses.quality());
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        ItemQuality expectedQuality = new ItemQuality(22);
        assertEquals(expectedQuality, backstagePasses.quality());
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        ItemQuality expectedQuality = new ItemQuality(23);
        assertEquals(expectedQuality, backstagePasses.quality());
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = ItemFactory.basedOn("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(expectedQuality, backstagePasses.quality());
    }

    @Test
    public void testQualityDoesNotAllowValuesBelowZero() {
        Executable invalidInstantiation = () -> new ItemQuality(-1);

        assertThrows(ItemQualityOutOfRangeException.class, invalidInstantiation);
    }

    @Test
    public void testQualityDoesNotAllowValuesOverFifty() {
        Executable invalidInstantiation = () -> new ItemQuality(51);

        assertThrows(ItemQualityOutOfRangeException.class, invalidInstantiation);
    }
}
