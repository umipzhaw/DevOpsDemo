package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class MountainTest {

        @Test
    public void testMountainDefaultConstructor() {
        mountain m = new mountain();
        assertEquals(0, m.getId());  
        assertNull(m.getTitle());   
        assertNull(m.getmountain_type());  
    }
    
    @Test
    public void testMountainProperties() {
        mountain m = new mountain(1, "Saas-Fee", "Wallis");
        assertEquals(1, m.getId());
        assertEquals("Saas-Fee", m.getTitle());
        assertEquals("Wallis", m.getmountain_type());

        m.setId(2);
        m.setTitle("Grindelwald");
        m.setmountain_type("Berner_Oberland");
        assertEquals(2, m.getId());
        assertEquals("Grindelwald", m.getTitle());
        assertEquals("Berner_Oberland", m.getmountain_type());
    }
}
