package com.gildedtros.quality.impl;

import com.gildedtros.Item;
import com.gildedtros.quality.QualityItem;
import lombok.Getter;

@Getter
public class NormalQualityItem implements QualityItem {

    protected static final int MAX_QUALITY = 50;

    private final Item item;

    public NormalQualityItem(Item item) {
        this.item = item;
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    @Override
    public void updateQuality() {
        int degradeFactor = getDegradationFactor();
        item.sellIn--;
        item.quality = Math.min(MAX_QUALITY, Math.max(0, item.quality - degradeFactor)); // never negative or over 50
    }

    @Override
    public int getDegradationFactor() {
        if (item.sellIn <= 0) {
            return 2;
        }
        return 1;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
