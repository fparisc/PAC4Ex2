package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmergentPhononTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, EmergentPhonon.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(EmergentPhonon.class.getDeclaredField("vibrationMode").getModifiers()));
            assertFalse(Modifier.isStatic(EmergentPhonon.class.getDeclaredField("vibrationMode").getModifiers()));
            assertFalse(Modifier.isFinal(EmergentPhonon.class.getDeclaredField("vibrationMode").getModifiers()));
            assertEquals(String.class, EmergentPhonon.class.getDeclaredField("vibrationMode").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Class definition")
    @SuppressWarnings("ConstantConditions")
    public void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(EmergentPhonon.class.getModifiers()));
        assertTrue(QuasiParticle.class.isAssignableFrom(EmergentPhonon.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, EmergentPhonon.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(EmergentPhonon.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, double.class, double.class, MaterialType.class, String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(4, EmergentPhonon.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(EmergentPhonon.class.getDeclaredMethod("getVibrationMode").getModifiers()));
            assertFalse(Modifier.isStatic(EmergentPhonon.class.getDeclaredMethod("getVibrationMode").getModifiers()));
            assertFalse(Modifier.isFinal(EmergentPhonon.class.getDeclaredMethod("getVibrationMode").getModifiers()));
            assertEquals(String.class, EmergentPhonon.class.getDeclaredMethod("getVibrationMode").getReturnType());

            assertTrue(Modifier.isPublic(EmergentPhonon.class.getDeclaredMethod("setVibrationMode", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(EmergentPhonon.class.getDeclaredMethod("setVibrationMode", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(EmergentPhonon.class.getDeclaredMethod("setVibrationMode", String.class).getModifiers()));
            assertEquals(void.class, EmergentPhonon.class.getDeclaredMethod("setVibrationMode", String.class).getReturnType());

            assertTrue(Modifier.isPublic(EmergentPhonon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(EmergentPhonon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(EmergentPhonon.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, EmergentPhonon.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(EmergentPhonon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(EmergentPhonon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(EmergentPhonon.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, EmergentPhonon.class.getDeclaredMethod("simulate").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testEmergentPhononValidParameters() {
        try {
            EmergentPhonon emergentPhonon = new EmergentPhonon("EP1", 0.5, 0.7, 0.55, 0.51, 1.0, 1.3, MaterialType.SEMICONDUCTOR, "Optical");
            assertEquals("EP1", emergentPhonon.getId());
            assertEquals(0.5, emergentPhonon.getMass());
            assertEquals(0.7, emergentPhonon.getCharge());
            assertEquals(0.55, emergentPhonon.getSpin());
            assertEquals(0.51, emergentPhonon.getEnergy());
            assertEquals(1.0, emergentPhonon.getLifeTime());
            assertEquals(1.3, emergentPhonon.getCoherenceLength());
            assertEquals(MaterialType.SEMICONDUCTOR, emergentPhonon.getMaterialType());
            assertEquals("Optical", emergentPhonon.getVibrationMode());

            emergentPhonon = new EmergentPhonon("EP2", 1.0, 2.0, 1.0, 1.0, 2.0, 2.0, MaterialType.SUPERCONDUCTOR, "Acoustic");
            assertEquals("EP2", emergentPhonon.getId());
            assertEquals(1.0, emergentPhonon.getMass());
            assertEquals(2.0, emergentPhonon.getCharge());
            assertEquals(1.0, emergentPhonon.getSpin());
            assertEquals(1.0, emergentPhonon.getEnergy());
            assertEquals(2.0, emergentPhonon.getLifeTime());
            assertEquals(2.0, emergentPhonon.getCoherenceLength());
            assertEquals(MaterialType.SUPERCONDUCTOR, emergentPhonon.getMaterialType());
            assertEquals("Acoustic", emergentPhonon.getVibrationMode());
        } catch (ParticleException e) {
            fail("There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Vibration mode")
    public void testEmergentPhononVibrationMode() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new EmergentPhonon("EP1", 0.5, 0.7, 0.55, 0.51, 1.0, 1.3, MaterialType.SEMICONDUCTOR, null));
            assertEquals("[ERROR] Vibration mode cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new EmergentPhonon("EP1", 0.5, 0.7, 0.55, 0.51, 1.0, 1.3, MaterialType.SEMICONDUCTOR, ""));
            assertEquals("[ERROR] Vibration mode cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new EmergentPhonon("EP1", 0.5, 0.7, 0.55, 0.51, 1.0, 1.3, MaterialType.SEMICONDUCTOR, "   "));
            assertEquals("[ERROR] Vibration mode cannot be null or blank.", exception.getMessage());

            EmergentPhonon emergentPhonon = new EmergentPhonon("EP1", 0.5, 0.7, 0.55, 0.51, 1.0, 1.3, MaterialType.SEMICONDUCTOR, "Optical");
            assertEquals("Optical", emergentPhonon.getVibrationMode());

            exception = assertThrows(ParticleException.class, () -> emergentPhonon.setVibrationMode(null));
            assertEquals("[ERROR] Vibration mode cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> emergentPhonon.setVibrationMode(""));
            assertEquals("[ERROR] Vibration mode cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> emergentPhonon.setVibrationMode("   "));
            assertEquals("[ERROR] Vibration mode cannot be null or blank.", exception.getMessage());

            emergentPhonon.setVibrationMode("Acoustic");
            assertEquals("Acoustic", emergentPhonon.getVibrationMode());
        } catch (ParticleException e) {
            fail("There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testEmergentPhononToString() {
        try {
            EmergentPhonon phonon = new EmergentPhonon("ep1", 0.01, 0.0, 1.0, 0.005, 10.0, 1.5, MaterialType.SILICON, "longitudinal");
            String expected = "{\"type\":\"emergentPhonon\",\"quasiParticle\":{\"particle\":{\"id\":\"ep1\",\"mass\":0.01,\"charge\":0.00,\"spin\":1.00,\"energy\":0.01},\"lifeTime\":1.000e+01,\"coherenceLength\":1.500e+00,\"materialType\":{\"name\":\"Silicon\",\"density\":2.33}},\"vibrationMode\":\"longitudinal\"}";
            String actual = phonon.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor of EmergentPhonon: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testEmergentPhononSimulate() {
        try {
            EmergentPhonon phonon = new EmergentPhonon("ep1", 0.01, 0.0, 1.0, 0.005, 10.0, 1.5, MaterialType.SUPERCONDUCTOR, "longitudinal");
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            phonon.simulate();
            System.setOut(System.out);
            String expectedOutput = "EmergentPhonon [ep1] vibrating in longitudinal mode with lifetime 1.00e+01 s.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            phonon = new EmergentPhonon("ep2", 0.02, 0.0, 1.0, 0.010, 5.0, 2.0, MaterialType.SEMICONDUCTOR, "transverse");
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            phonon.simulate();
            System.setOut(System.out);
            expectedOutput = "EmergentPhonon [ep2] vibrating in transverse mode with lifetime 5.00e+00 s.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor or simulate(): " + e.getMessage());
        }
    }

}
