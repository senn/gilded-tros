package com.gildedtros.quality;

import com.gildedtros.Item;
import org.jetbrains.annotations.NotNull;

public class QualityItemFactory {

    private QualityItemFactory() {
        throw new UnsupportedOperationException("Cannot instantiate this class");
    }

    public static QualityItem create(@NotNull Item item) {
        if ("Good Wine".equals(item.name)) {
            return new GoodWine(item);
        } else if ("B-DAWG Keychain".equals(item.name)) {
            return new LegendaryItem(item);
        } else if (item.name.startsWith("Backstage passes")) {
            return new BackstagePass(item);
        } else if ("Duplicate Code".equals(item.name)
                || item.name.startsWith("Long Methods")
                || item.name.startsWith("Ugly Variable Names")) {
            return new SmellyItem(item);
        } else {
            return new NormalQualityItem(item);
        }
    }

}
