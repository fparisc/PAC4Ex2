package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GluonTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Gluon.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Gluon.class.getDeclaredField("colorCharge").getModifiers()));
            assertFalse(Modifier.isStatic(Gluon.class.getDeclaredField("colorCharge").getModifiers()));
            assertFalse(Modifier.isFinal(Gluon.class.getDeclaredField("colorCharge").getModifiers()));
            assertEquals(String.class, Gluon.class.getDeclaredField("colorCharge").getType());
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
        assertFalse(Modifier.isAbstract(Gluon.class.getModifiers()));
        assertTrue(Boson.class.isAssignableFrom(Gluon.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Gluon.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Gluon.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, boolean.class, String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(4, Gluon.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Gluon.class.getDeclaredMethod("getColorCharge").getModifiers()));
            assertFalse(Modifier.isStatic(Gluon.class.getDeclaredMethod("getColorCharge").getModifiers()));
            assertFalse(Modifier.isFinal(Gluon.class.getDeclaredMethod("getColorCharge").getModifiers()));
            assertEquals(String.class, Gluon.class.getDeclaredMethod("getColorCharge").getReturnType());

            assertTrue(Modifier.isPublic(Gluon.class.getDeclaredMethod("setColorCharge", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Gluon.class.getDeclaredMethod("setColorCharge", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Gluon.class.getDeclaredMethod("setColorCharge", String.class).getModifiers()));
            assertEquals(void.class, Gluon.class.getDeclaredMethod("setColorCharge", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Gluon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Gluon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Gluon.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Gluon.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Gluon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Gluon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Gluon.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Gluon.class.getDeclaredMethod("simulate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testGluonValidParameters() {
        try {
            Gluon gluon = new Gluon("g1", 0.0, 0.0, 0.0, 0.0, true, "red");
            assertEquals("g1", gluon.getId());
            assertEquals(0.0, gluon.getMass());
            assertEquals(0.0, gluon.getCharge());
            assertEquals(0.0, gluon.getSpin());
            assertEquals(0.0, gluon.getEnergy());
            assertTrue(gluon.isForceCarrier());
            assertEquals("red", gluon.getColorCharge());

            gluon = new Gluon("g2", 1.0, 1.0, 1.0, 1.0, false, "blue");
            assertEquals("g2", gluon.getId());
            assertEquals(1.0, gluon.getMass());
            assertEquals(1.0, gluon.getCharge());
            assertEquals(1.0, gluon.getSpin());
            assertEquals(1.0, gluon.getEnergy());
            assertFalse(gluon.isForceCarrier());
            assertEquals("blue", gluon.getColorCharge());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - colorCharge")
    public void testGluonColorCharge() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Gluon("g1", 0.0, 0.0, 0.0, 0.0, true, null));
            assertEquals("[ERROR] Color charge cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Gluon("g1", 0.0, 0.0, 0.0, 0.0, true, ""));
            assertEquals("[ERROR] Color charge cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Gluon("g1", 0.0, 0.0, 0.0, 0.0, true, "   "));
            assertEquals("[ERROR] Color charge cannot be null or blank.", exception.getMessage());

            Gluon gluon = new Gluon("g1", 0.0, 0.0, 0.0, 0.0, true, "red");
            assertEquals("red", gluon.getColorCharge());

            exception = assertThrows(ParticleException.class, () -> gluon.setColorCharge(null));
            assertEquals("[ERROR] Color charge cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> gluon.setColorCharge(""));
            assertEquals("[ERROR] Color charge cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> gluon.setColorCharge("   "));
            assertEquals("[ERROR] Color charge cannot be null or blank.", exception.getMessage());

            gluon.setColorCharge("blue");
            assertEquals("blue", gluon.getColorCharge());
        } catch (Exception e) {
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
    public void testGluonToString() {
        try {
            Gluon gluon = new Gluon("g1", 1.0, -0.3, 0.8, 0.03, true, "red");
            String expected = "{\"type\":\"gluon\",\"boson\":{\"particle\":{\"id\":\"g1\",\"mass\":1.00,\"charge\":-0.30,\"spin\":0.80,\"energy\":0.03},\"forceCarrier\":true},\"colorCharge\":\"red\"}";
            String actual = gluon.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testGluonSimulate() {
        try {
            Gluon gluon = new Gluon("g1", 1.0, -0.3, 0.8, 0.03, true, "red");
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            gluon.simulate();
            System.setOut(System.out);
            String expectedOutput = "Gluon [g1] interaction: carrying color charge red to mediate strong force.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            gluon = new Gluon("g2", 1.0, -0.3, 0.8, 0.03, false, "blue");
            outputStream.reset();
            gluon.simulate();
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            expectedOutput = "Gluon [g2] interaction: carrying color charge blue to mediate strong force.";
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

}
