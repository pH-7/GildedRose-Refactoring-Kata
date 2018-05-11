package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateAgedBrieQuality(Item agedBrie) {
        if (agedBrie.quality < 50) {
            agedBrie.quality++;
            if (agedBrie.sellIn <= 0) {
                agedBrie.quality++;
            }
            if (agedBrie.quality > 50) {
                agedBrie.quality = 50;
            }
        }
        agedBrie.sellIn--;
    }

    private void updateBackstragePasses(Item backstagePasses) {
        if (backstagePasses.quality < 50) {
            backstagePasses.quality++;
            if (backstagePasses.sellIn <= 0) {
                backstagePasses.quality = 0;
            } else if (backstagePasses.sellIn <= 5) {
                backstagePasses.quality += 2;
            } else if (backstagePasses.sellIn <= 10) {
                backstagePasses.quality += 1;
            }
            if (backstagePasses.quality > 50) {
                backstagePasses.quality = 50;
            }
        }
        backstagePasses.sellIn--;

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (items[i].getName().equals("Aged Brie")) {
                updateAgedBrieQuality(items[i]);
            } else if (items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstragePasses(items[i]);
            } else  {
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }

                items[i].sellIn = items[i].sellIn - 1;

                if (items[i].sellIn < 0) {
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
        }
    }
}
