package com.gildedtros;

import com.gildedtros.quality.QualityItemFactory;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityItemFactory.create(item).updateQuality();
        }
    }
}