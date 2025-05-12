package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MuonTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Muon.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Muon.class.getDeclaredField("decayTime").getModifiers()));
            assertFalse(Modifier.isStatic(Muon.class.getDeclaredField("decayTime").getModifiers()));
            assertFalse(Modifier.isFinal(Muon.class.getDeclaredField("decayTime").getModifiers()));
            assertEquals(double.class, Muon.class.getDeclaredField("decayTime").getType());
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
        assertFalse(Modifier.isAbstract(Muon.class.getModifiers()));
        assertTrue(Fermion.class.isAssignableFrom(Muon.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Muon.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Muon.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, int.class, double.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(4, Muon.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Muon.class.getDeclaredMethod("getDecayTime").getModifiers()));
            assertFalse(Modifier.isStatic(Muon.class.getDeclaredMethod("getDecayTime").getModifiers()));
            assertFalse(Modifier.isFinal(Muon.class.getDeclaredMethod("getDecayTime").getModifiers()));
            assertEquals(double.class, Muon.class.getDeclaredMethod("getDecayTime").getReturnType());

            assertTrue(Modifier.isPublic(Muon.class.getDeclaredMethod("setDecayTime", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Muon.class.getDeclaredMethod("setDecayTime", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Muon.class.getDeclaredMethod("setDecayTime", double.class).getModifiers()));
            assertEquals(void.class, Muon.class.getDeclaredMethod("setDecayTime", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Muon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Muon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Muon.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Muon.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Muon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Muon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Muon.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Muon.class.getDeclaredMethod("simulate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testMuonValidParameters() {
        try {
            Muon muon = new Muon("Muon", 0.1056583745, -0.77, 0.3, 0.51, 1, 2.2E-6);
            assertEquals("Muon", muon.getId());
            assertEquals(0.1056583745, muon.getMass());
            assertEquals(-0.77, muon.getCharge());
            assertEquals(0.3, muon.getSpin());
            assertEquals(0.51, muon.getEnergy());
            assertEquals(1, muon.getLeptonNumber());
            assertEquals(2.2E-6, muon.getDecayTime());

            muon = new Muon("Muon2", 0.1157415, -0.01, 0.7, 0.12, 5, 2.11E-6);
            assertEquals("Muon2", muon.getId());
            assertEquals(0.1157415, muon.getMass());
            assertEquals(-0.01, muon.getCharge());
            assertEquals(0.7, muon.getSpin());
            assertEquals(0.12, muon.getEnergy());
            assertEquals(5, muon.getLeptonNumber());
            assertEquals(2.11E-6, muon.getDecayTime());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Decay Time")
    public void testMuonDecayTime() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Muon("Muon", 0.1056583745, -0.77, 0.3, 0.51, 1, -2.2E-6));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Muon("Muon", 0.1056583745, -0.77, 0.3, 0.51, 1, Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            Muon muon = new Muon("Muon", 0.1056583745, -0.77, 0.3, 0.51, 1, 2.2E-6);
            assertEquals(2.2E-6, muon.getDecayTime());

            exception = assertThrows(ParticleException.class, () -> muon.setDecayTime(-2.2E-6));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> muon.setDecayTime(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            muon.setDecayTime(3.5E-6);
            assertEquals(3.5E-6, muon.getDecayTime());

            muon.setDecayTime(0.0);
            assertEquals(0.0, muon.getDecayTime());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the parameters: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testMuonToString() {
        try {
            Muon muon = new Muon("mu1", 105.7, -1.0, 0.5, 200.0, 1, 2.2e-6);
            String expected = "{\"type\":\"muon\",\"fermion\":{\"particle\":{\"id\":\"mu1\",\"mass\":105.70,\"charge\":-1.00,\"spin\":0.50,\"energy\":200.00},\"leptonNumber\":1},\"decayTime\":2.20e-06}";
            String actual = muon.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor of Muon: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testMuonSimulate() {
        try {
            Muon muon = new Muon("mu1", 105.7, -1.0, 0.5, 200.0, 1, 2.2e-6);
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            muon.simulate();
            System.setOut(System.out);
            String expectedOutput = "Muon [mu1] with lepton number 1 decays after 2.20e-06 s.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            muon = new Muon("mu2", 106.0, 1.0, 0.5, 210.0, 2, 3.5e-6);
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            muon.simulate();
            System.setOut(System.out);
            expectedOutput = "Muon [mu2] with lepton number 2 decays after 3.50e-06 s.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor or simulate() of Muon: " + e.getMessage());
        }
    }

}
