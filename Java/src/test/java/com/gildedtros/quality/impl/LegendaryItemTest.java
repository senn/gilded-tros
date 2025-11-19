package com.gildedtros.quality.impl;

import com.gildedtros.Item;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryItemTest {

    @ParameterizedTest
    @MethodSource
    void updateQualityAfter3Days(LegendaryItem legItem) {
        int expectedQuality = legItem.item.quality;
        int expectedSellIn = legItem.item.sellIn;
        legItem.updateQuality();
        legItem.updateQuality();
        legItem.updateQuality();
        assertEquals(expectedQuality, legItem.item.quality);
        assertEquals(expectedSellIn, legItem.item.sellIn);
    }

    private static Stream<Arguments> updateQualityAfter3Days() {
        return Stream.of(
                Arguments.of(new LegendaryItem(new Item("test1", 10, 10))),
                Arguments.of(new LegendaryItem(new Item("test2", 1, 10))),
                Arguments.of(new LegendaryItem(new Item("test3", 5, 100)))
        );
    }

}