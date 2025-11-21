package com.gildedtros.quality;

import com.gildedtros.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class QualityItemTest {

    @Mock
    private Item item1, item2;
    @Mock
    private QualityItem qualityItem1, qualityItem2;

    @Test
    void testFactoryMethod() {
        try (MockedStatic<QualityItemFactory> mockFactory = mockStatic(QualityItemFactory.class)) {
            mockFactory.when(() -> QualityItemFactory.create(item1)).thenReturn(qualityItem1);
            mockFactory.when(() -> QualityItemFactory.create(item2)).thenReturn(qualityItem2);

            // Just verifying that the factory method delegates to the actual internal factory
            assertEquals(qualityItem1, QualityItem.of(item1));
            assertEquals(qualityItem2, QualityItem.of(item2));
        }
    }

}