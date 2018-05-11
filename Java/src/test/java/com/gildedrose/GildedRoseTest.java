package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testQualityDecreseEveryDay()
    {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(19, app.items[0].quality);
    }

    @Test
    public void testQualityDecreaseWhenDatePassed()
    {
        Item[] items = new Item[] {
                new Item("Daft", 0, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void testQualityCannotBeNegative()
    {
        Item[] items = new Item[] {
                new Item("Daft", 0, 1)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBrieIncreaseTwiceInQuality()
    {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 1)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void testAgedBrieSellInDecrease()
    {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 1)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void testQualityItemCannotBeMoreFifty()
    {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 49)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testSulfurasQualityRemainsSame()
    {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 1, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, app.items[0].quality);
    }

    @Test
    public void testBackstageIncreasesTwoWhenSellInIsTen()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void testBackstageIncreasesTwoWhenSellInIsUnderTen()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void testBackstageIncreasesThreeWhenSellIngIsFive()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void testBackstageIncreasesThreeWhenSellIngIsUnderFive()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void testBackstageDropsZero()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testBackstageKeepsSameQuality()
    {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }
}
