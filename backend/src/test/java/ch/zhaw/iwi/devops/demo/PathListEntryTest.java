package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class PathListEntryTest {

    private PathListEntry<Object> entry;

    @BeforeEach
    void setUp() {
        entry = new PathListEntry<>();
    }

    @Test
    void testSetColorAndGetColor() {
        entry.setColor("red");
        assertEquals("red", entry.getColor(), "Die Fareb sollte rot sein.");
    }

    @Test
    void testSetIconAndGetIcon() {
        entry.setIcon("icon.png");
        assertEquals("icon.png", entry.getIcon(), "Das icon ist icon.png.");
    }

    @Test
    void testSetDetailsAndGetDetails() {
        List<String> details = Arrays.asList("Detail1", "Detail2");
        entry.setDetails(details);
        assertEquals(details, entry.getDetails(), "Die Details sollen übereinstimmen.");
    }

    @Test
    void testSetUrlAndGetUrl() {
        entry.setUrl("http://example.com");
        assertEquals("http://example.com", entry.getUrl(), "Die Adresse soltte 'http://example.com'.");
    }
}
