package com.gildedtros;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @ParameterizedTest
    @MethodSource("testUpdateQualityItemsWith3DayExpectations")
    void testUpdatedQualityAfter3Days(Item item, int expectedSellIn, int expectedQuality) {
        GildedTros app = new GildedTros(new Item[]{item});
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    private static Stream<Arguments> testUpdateQualityItemsWith3DayExpectations() {
        return Stream.of(
                Arguments.of(new Item("Ring of Cleansening Code", 10, 20), 7, 17),
                Arguments.of(new Item("Good Wine", 2, 0), -1, 4),
                Arguments.of(new Item("Elixir of the SOLID", 5, 7), 2, 4),
                Arguments.of(new Item("Elixir of the SOLID", 1, 10), -2, 5),
                Arguments.of(new Item("B-DAWG Keychain", 0, 80), 0, 80),
                Arguments.of(new Item("B-DAWG Keychain", -1, 80), -1, 80),
                Arguments.of(new Item("Backstage passes for Re:Factor", 15, 20), 12, 23),
                Arguments.of(new Item("Backstage passes for Re:Factor", 10, 49), 7, 50),
                Arguments.of(new Item("Backstage passes for Re:Factor", 10, 40), 7, 46),
                Arguments.of(new Item("Backstage passes for HAXX", 5, 49), 2, 50),
                Arguments.of(new Item("Backstage passes for HAXX", 5, 30), 2, 39),
                Arguments.of(new Item("Backstage passes for HAXX", 1, 49), -2, 0),
                Arguments.of(new Item("Duplicate Code", 3, 6), 0, 0),
                Arguments.of(new Item("Duplicate Code", 10, 10), 7, 4),
                Arguments.of(new Item("Long Methods", 3, 6), 0, 0),
                Arguments.of(new Item("Long Methods", 10, 10), 7, 4),
                Arguments.of(new Item("Ugly Variable Names", 3, 6), 0, 0),
                Arguments.of(new Item("Ugly Variable Names", 10, 10), 7, 4)
        );
    }

}
