package com.gildedtros.quality;

import com.gildedtros.Item;
import com.gildedtros.quality.impl.BackstagePass;
import com.gildedtros.quality.impl.GoodWine;
import com.gildedtros.quality.impl.LegendaryItem;
import com.gildedtros.quality.impl.NormalQualityItem;
import com.gildedtros.quality.impl.SmellyItem;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityItemFactoryTest {

    private static Stream<Arguments> testFactoryMappings() {
        return Stream.of(
                Arguments.of("Good Wine", GoodWine.class),
                Arguments.of("B-DAWG Keychain", LegendaryItem.class),
                Arguments.of("Backstage passes to a TAFKAL80ETC concert", BackstagePass.class),
                Arguments.of("Duplicate Code", SmellyItem.class),
                Arguments.of("Long Methods Are Bad", SmellyItem.class),
                Arguments.of("Ugly Variable Names Everywhere", SmellyItem.class),
                Arguments.of("Random Item", NormalQualityItem.class),
                Arguments.of("This assessment is kinda fun", NormalQualityItem.class)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Factory returns correct QualityItem subclass for all item names")
    void testFactoryMappings(String name, Class<? extends QualityItem> expectedClass) {
        Item item = new Item(name, 5, 10);
        QualityItem qItem = QualityItemFactory.create(item);
        assertEquals(expectedClass, qItem.getClass());
    }

}