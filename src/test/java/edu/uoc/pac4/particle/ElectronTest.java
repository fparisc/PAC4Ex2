package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElectronTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(0, Electron.class.getDeclaredFields().length);
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Class definition")
    @SuppressWarnings("ConstantConditions")
    public void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Electron.class.getModifiers()));
        assertTrue(Fermion.class.isAssignableFrom(Electron.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Electron.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Electron.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(2, Electron.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Electron.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Electron.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Electron.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Electron.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Electron.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Electron.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Electron.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Electron.class.getDeclaredMethod("simulate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testElectronValidParameters() {
        try {
            Electron electron = new Electron("Electron", 9.11e-31, 1.6e-19, 0.5, 0.4, 1);
            assertEquals("Electron", electron.getId());
            assertEquals(9.11e-31, electron.getMass());
            assertEquals(1.6e-19, electron.getCharge());
            assertEquals(0.5, electron.getSpin());
            assertEquals(0.4, electron.getEnergy());
            assertEquals(1, electron.getLeptonNumber());

            electron = new Electron("Electron2", 6.23e-31, -1.6e-19, 0.1, 0.33, 14);
            assertEquals("Electron2", electron.getId());
            assertEquals(6.23e-31, electron.getMass());
            assertEquals(-1.6e-19, electron.getCharge());
            assertEquals(0.1, electron.getSpin());
            assertEquals(0.33, electron.getEnergy());
            assertEquals(14, electron.getLeptonNumber());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the parameters: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testElectronToString() {
        try {
            Electron electron = new Electron("e1", 0.511, -1.0, 0.5, 10.0, 1);
            String expected = "{\"type\":\"electron\",\"fermion\":{\"particle\":{\"id\":\"e1\",\"mass\":0.51,\"charge\":-1.00,\"spin\":0.50,\"energy\":10.00},\"leptonNumber\":1}}";
            String actual = electron.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor of Electron: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testElectronSimulate() {
        try {
            Electron electron = new Electron("e1", 0.511, -1.0, 0.5, 10.0, 1);
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            electron.simulate();
            System.setOut(System.out);
            String expectedOutput = "Electron [e1] with lepton number 1 is stable and does not decay.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            electron = new Electron("e2", 0.511, -1.0, 0.5, 12.0, 2);
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            electron.simulate();
            System.setOut(System.out);
            expectedOutput = "Electron [e2] with lepton number 2 is stable and does not decay.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor or simulate() of Electron: " + e.getMessage());
        }
    }

}
