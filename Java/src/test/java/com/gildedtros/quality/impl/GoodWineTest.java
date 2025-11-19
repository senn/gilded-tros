package com.gildedtros.quality.impl;

import com.gildedtros.Item;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoodWineTest {

    @ParameterizedTest
    @MethodSource
    void updateQualityAfter3Days(GoodWine wine, int expectedSellIn, int expectedQuality) {
        wine.updateQuality();
        wine.updateQuality();
        wine.updateQuality();
        assertEquals(expectedQuality, wine.getItem().quality);
        assertEquals(expectedSellIn, wine.getItem().sellIn);
    }

    private static Stream<Arguments> updateQualityAfter3Days() {
        return Stream.of(
                Arguments.of(new GoodWine(new Item("test1", 10, 10)), 7, 13),
                Arguments.of(new GoodWine(new Item("test2", 1, 10)), -2, 15),
                Arguments.of(new GoodWine(new Item("test3", 5, 100)), 2, 50)
        );
    }

}