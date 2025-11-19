package com.gildedtros.quality.impl;

import com.gildedtros.Item;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassTest {

    @ParameterizedTest
    @MethodSource
    void updateQualityAfter3Days(BackstagePass pass, int expectedSellIn, int expectedQuality) {
        pass.updateQuality();
        pass.updateQuality();
        pass.updateQuality();
        assertEquals(expectedQuality, pass.getItem().quality);
        assertEquals(expectedSellIn, pass.getItem().sellIn);
    }

    private static Stream<Arguments> updateQualityAfter3Days() {
        return Stream.of(
                Arguments.of(new BackstagePass(new Item("Backstage passes for Re:Factor", 15, 20)), 12, 23),
                Arguments.of(new BackstagePass(new Item("Backstage passes for Re:Factor", 10, 49)), 7, 50),
                Arguments.of(new BackstagePass(new Item("Backstage passes for Re:Factor", 10, 40)), 7, 46),
                Arguments.of(new BackstagePass(new Item("Backstage passes for HAXX", 5, 49)), 2, 50),
                Arguments.of(new BackstagePass(new Item("Backstage passes for HAXX", 5, 30)), 2, 39),
                Arguments.of(new BackstagePass(new Item("Backstage passes for HAXX", 1, 49)), -2, 0)
        );
    }

}