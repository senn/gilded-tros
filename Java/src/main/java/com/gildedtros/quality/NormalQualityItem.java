package com.gildedtros.quality;

import com.gildedtros.Item;
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
        int degradeFactor = 1;
        if (item.sellIn <= 0) {
            degradeFactor = 2;
        }
        return degradeFactor;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
