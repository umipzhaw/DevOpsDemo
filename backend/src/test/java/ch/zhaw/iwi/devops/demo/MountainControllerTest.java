package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MountainControllerTest {

    private mountainController controller;

    @BeforeEach
    public void setUp() {
        controller = new mountainController();
        controller.init();
    }

    @Test
    public void testMountainListEndpoint() {
        List<PathListEntry<Integer>> entries = controller.mountain();
        
        
        assertNotNull(entries);
        assertEquals(5, entries.size()); 

        
        PathListEntry<Integer> firstEntry = entries.get(0);
        assertNotNull(firstEntry);
        assertEquals(1, firstEntry.getKey().getKey());  
        assertEquals("Laax", firstEntry.getName());
        assertEquals("Graubünden", firstEntry.getTooltip());
        assertEquals("Graubünden", firstEntry.getDetails().get(0));
    }

    @Test
    public void testMountainManagement() {
        assertEquals(5, controller.count());

        
        mountain newMountain = new mountain(6, "Pilatus", "Luzern");
        controller.createMountain(newMountain);
        assertEquals(6, controller.count());

       
        mountain retrievedMountain = controller.getMountain(1);
        assertNotNull(retrievedMountain);
        assertEquals("Laax", retrievedMountain.getTitle());

        
        mountain deletedMountain = controller.deleteMountain(1);
        assertNotNull(deletedMountain);
        assertEquals(5, controller.count());
        assertNull(controller.getMountain(1));
    }

    @Test
    public void testAppStatus() {
    String response = controller.test();
    assertNotNull(response, "Die Antwort sollte nicht null sein");
    assertEquals("Mountain app is up and running!", response, "Die Antwort sollte 'Mountain app is up and running!' sein");
}
@Test
    public void testPingEndpoint() {
    String expectedJson = "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}";
    String response = controller.ping();
    assertNotNull(response, "Die Antwort sollte nicht null sein");
    assertEquals(expectedJson, response, "Entsprechende Antwort");
}

@Test
    public void testUpdateMountain() {
    mountain updatedMountain = new mountain(1, "Obersaxen", "Graubünden");
    controller.updateMountain(1, updatedMountain);

    mountain retrievedMountain = controller.getMountain(1);
    assertNotNull(retrievedMountain, "Der Berg sollte nach dem Update vorhanden sein");
    assertEquals("Obersaxen", retrievedMountain.getTitle(), "Der Titel des Bergs sollte aktualisiert werden");
    assertEquals("Graubünden", retrievedMountain.getmountain_type(), "Der Typ des Bergs sollte gleich bleiben");

    mountain nonExistingMountain = new mountain(99, "Staffeleg", "Aarau");
    controller.updateMountain(99, nonExistingMountain);
    mountain resultMountain = controller.getMountain(99);
    assertNotNull(resultMountain, "Test");
    assertEquals("Staffeleg", resultMountain.getTitle(), "Staffeleg");
    }
}
