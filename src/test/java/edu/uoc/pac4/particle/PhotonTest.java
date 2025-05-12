package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhotonTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Photon.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Photon.class.getDeclaredField("wavelength").getModifiers()));
            assertFalse(Modifier.isStatic(Photon.class.getDeclaredField("wavelength").getModifiers()));
            assertFalse(Modifier.isFinal(Photon.class.getDeclaredField("wavelength").getModifiers()));
            assertEquals(double.class, Photon.class.getDeclaredField("wavelength").getType());
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
        assertFalse(Modifier.isAbstract(Photon.class.getModifiers()));
        assertTrue(Boson.class.isAssignableFrom(Photon.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Photon.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Photon.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, boolean.class, double.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(4, Photon.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Photon.class.getDeclaredMethod("getWavelength").getModifiers()));
            assertFalse(Modifier.isStatic(Photon.class.getDeclaredMethod("getWavelength").getModifiers()));
            assertFalse(Modifier.isFinal(Photon.class.getDeclaredMethod("getWavelength").getModifiers()));
            assertEquals(double.class, Photon.class.getDeclaredMethod("getWavelength").getReturnType());

            assertTrue(Modifier.isPublic(Photon.class.getDeclaredMethod("setWavelength", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Photon.class.getDeclaredMethod("setWavelength", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Photon.class.getDeclaredMethod("setWavelength", double.class).getModifiers()));
            assertEquals(void.class, Photon.class.getDeclaredMethod("setWavelength", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Photon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Photon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Photon.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Photon.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Photon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Photon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Photon.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Photon.class.getDeclaredMethod("simulate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testPhotonValidParameters() {
        try {
            Photon photon = new Photon("Photon", 0.7, 0.11, 0.75, 0.45, true, 1.0);
            assertEquals("Photon", photon.getId());
            assertEquals(0.7, photon.getMass());
            assertEquals(0.11, photon.getCharge());
            assertEquals(0.75, photon.getSpin());
            assertEquals(0.45, photon.getEnergy());
            assertTrue(photon.isForceCarrier());
            assertEquals(1.0, photon.getWavelength());

            photon = new Photon("Photon2", 0.8, 0.12, 0.76, 0.46, false, 1.5);
            assertEquals("Photon2", photon.getId());
            assertEquals(0.8, photon.getMass());
            assertEquals(0.12, photon.getCharge());
            assertEquals(0.76, photon.getSpin());
            assertEquals(0.46, photon.getEnergy());
            assertFalse(photon.isForceCarrier());
            assertEquals(1.5, photon.getWavelength());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - wavelength")
    public void testPhotonWavelength() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Photon("Photon", 0.7, 0.11, 0.75, 0.45, true, -1.0));
            assertEquals("[ERROR] Wavelength cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Photon("Photon", 0.7, 0.11, 0.75, 0.45, true, Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Wavelength cannot be negative or infinite.", exception.getMessage());

            Photon photon = new Photon("Photon", 0.7, 0.11, 0.75, 0.45, true, 1.0);
            assertEquals(1.0, photon.getWavelength());

            exception = assertThrows(ParticleException.class, () -> photon.setWavelength(-1.0));
            assertEquals("[ERROR] Wavelength cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> photon.setWavelength(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Wavelength cannot be negative or infinite.", exception.getMessage());

            photon.setWavelength(2.0);
            assertEquals(2.0, photon.getWavelength());

            photon.setWavelength(0.0);
            assertEquals(0.0, photon.getWavelength());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testPhotonToString() {
        try {
            Photon photon = new Photon("Photon", 0.7, 0.11, 0.75, 0.45, true, 1.0);
            String expected = "{\"type\":\"photon\",\"boson\":{\"particle\":{\"id\":\"Photon\",\"mass\":0.70,\"charge\":0.11,\"spin\":0.75,\"energy\":0.45},\"forceCarrier\":true},\"wavelength\":1.00}";
            String actual = photon.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testPhotonSimulate() {
        try {
            Photon photon = new Photon("Photon", 0.7, 0.11, 0.75, 0.45, true, 1.0);
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            photon.simulate();
            System.setOut(System.out);
            String expectedOutput = "Photon [Photon] with wavelength 1.00 nm has been absorbed, transferring 0.45 eV of energy.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            photon = new Photon("Photon2", 0.8, 0.12, 0.76, 0.46, false, 1.5);
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            photon.simulate();
            System.setOut(System.out);
            expectedOutput = "Photon [Photon2] with wavelength 1.50 nm has been absorbed, transferring 0.46 eV of energy.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

}
