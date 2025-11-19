package com.gildedtros.quality.impl;

import com.gildedtros.Item;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalQualityItemTest {

    @ParameterizedTest
    @MethodSource
    void updateQualityAfter3Days(NormalQualityItem qItem, int expectedSellIn, int expectedQuality) {
        qItem.updateQuality();
        qItem.updateQuality();
        qItem.updateQuality();
        assertEquals(expectedQuality, qItem.getItem().quality);
        assertEquals(expectedSellIn, qItem.getItem().sellIn);
    }

    private static Stream<Arguments> updateQualityAfter3Days() {
        return Stream.of(
                Arguments.of(new NormalQualityItem(new Item("test1", 10, 10)), 7, 7),
                Arguments.of(new NormalQualityItem(new Item("test2", 1, 10)), -2, 5),
                Arguments.of(new NormalQualityItem(new Item("test3", 5, 100)), 2, 47)
        );
    }

}