package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.exception.DataEntryException;
import edu.uoc.pac4.exception.ParticleException;
import edu.uoc.pac4.particle.*;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataEntryTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(5, DataEntry.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("id").getModifiers()));
            assertEquals(int.class, DataEntry.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("title").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("title").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("title").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredField("title").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("timestamp").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("timestamp").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("timestamp").getModifiers()));
            assertEquals(LocalDateTime.class, DataEntry.class.getDeclaredField("timestamp").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("observations").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("observations").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("observations").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredField("observations").getType());

            assertTrue(Modifier.isPrivate(DataEntry.class.getDeclaredField("particle").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredField("particle").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredField("particle").getModifiers()));
            assertEquals(Particle.class, DataEntry.class.getDeclaredField("particle").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Class definition")
    @SuppressWarnings("ConstantConditions")
    public void checkClassSanity() {
        assertTrue(Cloneable.class.isAssignableFrom(DataEntry.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, DataEntry.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredConstructor(int.class, String.class, LocalDateTime.class, String.class, Particle.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(13, DataEntry.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(int.class, DataEntry.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setId", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setId", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setId", int.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setId", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getTitle").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getTitle").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getTitle").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredMethod("getTitle").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setTitle", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setTitle", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setTitle", String.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setTitle", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getTimestamp").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getTimestamp").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getTimestamp").getModifiers()));
            assertEquals(LocalDateTime.class, DataEntry.class.getDeclaredMethod("getTimestamp").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setTimestamp", LocalDateTime.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getObservations").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getObservations").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getObservations").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredMethod("getObservations").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setObservations", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setObservations", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setObservations", String.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setObservations", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, DataEntry.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertEquals(boolean.class, DataEntry.class.getDeclaredMethod("equals", Object.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("getParticle").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("getParticle").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("getParticle").getModifiers()));
            assertEquals(Particle.class, DataEntry.class.getDeclaredMethod("getParticle").getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("setParticle", Particle.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("setParticle", Particle.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("setParticle", Particle.class).getModifiers()));
            assertEquals(void.class, DataEntry.class.getDeclaredMethod("setParticle", Particle.class).getReturnType());

            assertTrue(Modifier.isPublic(DataEntry.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isStatic(DataEntry.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isFinal(DataEntry.class.getDeclaredMethod("clone").getModifiers()));
            assertEquals(Object.class, DataEntry.class.getDeclaredMethod("clone").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Particle")
    public void testDataEntryParticle() {
        try {
            AppException exception = assertThrows(DataEntryException.class, () -> new DataEntry(1, "Test Entry", LocalDateTime.now(), "Test observations", null));
            assertEquals("[ERROR] Particle cannot be null.", exception.getMessage());

            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0.511, 1e-9, 1e-9, MaterialType.SEMICONDUCTOR, true);
            DataEntry dataEntry = new DataEntry(1, "Test Entry", LocalDateTime.now(), "Test observations", majorana);
            assertEquals(majorana, dataEntry.getParticle());

            Gluon gluon = new Gluon("G1", 0, 0, 1, 0, true, "red");
            dataEntry.setParticle(gluon);
            assertEquals(gluon, dataEntry.getParticle());
        } catch (AppException e) {
            fail("[ERROR] DataEntry creation failed: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testDataEntryToString() {
        try {
            LocalDateTime now = LocalDateTime.now();
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0.511, 1e-9, 1e-9, MaterialType.SEMICONDUCTOR, true);
            DataEntry dataEntry = new DataEntry(1, "Test Entry", now, "Test observations", majorana);
            String expected = "{\"id\":1,\"title\":\"Test Entry\",\"timestamp\":\"" + now + "\",\"observations\":\"Test observations\",\"particle\":{\"type\":\"majorana\",\"quasiParticle\":{\"particle\":{\"id\":\"M1\",\"mass\":0.51,\"charge\":0.00,\"spin\":0.50,\"energy\":0.51},\"lifeTime\":1.000e-09,\"coherenceLength\":1.000e-09,\"materialType\":{\"name\":\"Semiconductor\",\"density\":2.33}},\"isSelfConjugate\":true}}";
            String actualString = dataEntry.toString();
            assertEquals(normalize(expected), normalize(actualString));
        } catch (AppException e) {
            fail("[ERROR] DataEntry creation failed: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - clone")
    public void testDataEntryClone() {
        try {
            LocalDateTime now = LocalDateTime.now();
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0.511, 1e-9, 1e-9, MaterialType.SEMICONDUCTOR, true);
            DataEntry dataEntry = new DataEntry(1, "Test Entry", now, "Test observations", majorana);
            DataEntry clonedDataEntry = (DataEntry) dataEntry.clone();

            assertNotSame(dataEntry.getParticle(), clonedDataEntry.getParticle());

            assertEquals(dataEntry.getId(), clonedDataEntry.getId());
            assertEquals(dataEntry.getTitle(), clonedDataEntry.getTitle());
            assertEquals(dataEntry.getTimestamp(), clonedDataEntry.getTimestamp());
            assertEquals(dataEntry.getObservations(), clonedDataEntry.getObservations());

            assertEquals(dataEntry.getParticle().getId(), clonedDataEntry.getParticle().getId());
            assertEquals(dataEntry.getParticle().getMass(), clonedDataEntry.getParticle().getMass());
            assertEquals(dataEntry.getParticle().getCharge(), clonedDataEntry.getParticle().getCharge());
            assertEquals(dataEntry.getParticle().getSpin(), clonedDataEntry.getParticle().getSpin());
            assertEquals(dataEntry.getParticle().getEnergy(), clonedDataEntry.getParticle().getEnergy());

            Electron electron = new Electron("E1", 0.511, -1, 1 / 2.0, 0.511, 1);
            dataEntry.setParticle(electron);
            clonedDataEntry = (DataEntry) dataEntry.clone();

            assertNotSame(dataEntry.getParticle(), clonedDataEntry.getParticle());

            assertEquals(dataEntry.getParticle().getId(), clonedDataEntry.getParticle().getId());
            assertEquals(dataEntry.getParticle().getMass(), clonedDataEntry.getParticle().getMass());
            assertEquals(dataEntry.getParticle().getCharge(), clonedDataEntry.getParticle().getCharge());
            assertEquals(dataEntry.getParticle().getSpin(), clonedDataEntry.getParticle().getSpin());
            assertEquals(dataEntry.getParticle().getEnergy(), clonedDataEntry.getParticle().getEnergy());
        } catch (AppException | CloneNotSupportedException e) {
            fail("[ERROR] DataEntry creation failed: " + e.getMessage());
        }
    }

}
