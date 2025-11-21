package com.gildedtros;

import com.gildedtros.quality.QualityItem;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityItem.of(item).updateQuality();
        }
    }
}