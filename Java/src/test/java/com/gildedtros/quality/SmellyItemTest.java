package com.gildedtros.quality;

import com.gildedtros.Item;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmellyItemTest {

    @ParameterizedTest
    @MethodSource
    void updateQualityAfter3Days(SmellyItem smelly, int expectedSellIn, int expectedQuality) {
        smelly.updateQuality();
        smelly.updateQuality();
        smelly.updateQuality();
        assertEquals(expectedQuality, smelly.getItem().quality);
        assertEquals(expectedSellIn, smelly.getItem().sellIn);
    }

    private static Stream<Arguments> updateQualityAfter3Days() {
        return Stream.of(
                Arguments.of(new SmellyItem(new Item("test1", 10, 10)), 7, 4),
                Arguments.of(new SmellyItem(new Item("test2", 1, 10)), -2, 0),
                Arguments.of(new SmellyItem(new Item("test3", 5, 100)), 2, 44)
        );
    }

}