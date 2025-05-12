package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MagnonTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Magnon.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Magnon.class.getDeclaredField("spinFlipCount").getModifiers()));
            assertFalse(Modifier.isStatic(Magnon.class.getDeclaredField("spinFlipCount").getModifiers()));
            assertFalse(Modifier.isFinal(Magnon.class.getDeclaredField("spinFlipCount").getModifiers()));
            assertEquals(int.class, Magnon.class.getDeclaredField("spinFlipCount").getType());
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
        assertFalse(Modifier.isAbstract(Magnon.class.getModifiers()));
        assertTrue(QuasiParticle.class.isAssignableFrom(Magnon.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Magnon.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Magnon.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, double.class, double.class, MaterialType.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(4, Magnon.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Magnon.class.getDeclaredMethod("getSpinFlipCount").getModifiers()));
            assertFalse(Modifier.isStatic(Magnon.class.getDeclaredMethod("getSpinFlipCount").getModifiers()));
            assertFalse(Modifier.isFinal(Magnon.class.getDeclaredMethod("getSpinFlipCount").getModifiers()));
            assertEquals(int.class, Magnon.class.getDeclaredMethod("getSpinFlipCount").getReturnType());

            assertTrue(Modifier.isPublic(Magnon.class.getDeclaredMethod("setSpinFlipCount", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Magnon.class.getDeclaredMethod("setSpinFlipCount", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Magnon.class.getDeclaredMethod("setSpinFlipCount", int.class).getModifiers()));
            assertEquals(void.class, Magnon.class.getDeclaredMethod("setSpinFlipCount", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Magnon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Magnon.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Magnon.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Magnon.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Magnon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Magnon.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Magnon.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Magnon.class.getDeclaredMethod("simulate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testMagnonValidParameters() {
        try {
            Magnon magnon = new Magnon("magnon1", 9.11e-31, 1.6e-19, 0.5, 1.0, 1.0, 1.0, MaterialType.SEMICONDUCTOR, 10);
            assertEquals("magnon1", magnon.getId());
            assertEquals(9.11e-31, magnon.getMass());
            assertEquals(1.6e-19, magnon.getCharge());
            assertEquals(0.5, magnon.getSpin());
            assertEquals(1.0, magnon.getEnergy());
            assertEquals(1.0, magnon.getLifeTime());
            assertEquals(1.0, magnon.getCoherenceLength());
            assertEquals(MaterialType.SEMICONDUCTOR, magnon.getMaterialType());
            assertEquals(10, magnon.getSpinFlipCount());

            magnon = new Magnon("magnon2", 9.11e-31, 1.6e-19, 0.5, 1.0, 1.0, 1.0, MaterialType.GRAPHENE, 20);
            assertEquals("magnon2", magnon.getId());
            assertEquals(9.11e-31, magnon.getMass());
            assertEquals(1.6e-19, magnon.getCharge());
            assertEquals(0.5, magnon.getSpin());
            assertEquals(1.0, magnon.getEnergy());
            assertEquals(1.0, magnon.getLifeTime());
            assertEquals(1.0, magnon.getCoherenceLength());
            assertEquals(MaterialType.GRAPHENE, magnon.getMaterialType());
            assertEquals(20, magnon.getSpinFlipCount());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Spin flip count")
    public void testMagnonSpinFlipCount() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Magnon("magnon1", 9.11e-31, 1.6e-19, 0.5, 1.0, 1.0, 1.0, MaterialType.SEMICONDUCTOR, -1));
            assertEquals("[ERROR] Spin flip count cannot be negative.", exception.getMessage());

            Magnon magnon = new Magnon("magnon1", 9.11e-31, 1.6e-19, 0.5, 1.0, 1.0, 1.0, MaterialType.SEMICONDUCTOR, 10);
            assertEquals(10, magnon.getSpinFlipCount());

            exception = assertThrows(ParticleException.class, () -> magnon.setSpinFlipCount(-1));
            assertEquals("[ERROR] Spin flip count cannot be negative.", exception.getMessage());

            magnon.setSpinFlipCount(20);
            assertEquals(20, magnon.getSpinFlipCount());

            magnon.setSpinFlipCount(0);
            assertEquals(0, magnon.getSpinFlipCount());
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
    public void testMagnonToString() {
        try {
            Magnon magnon = new Magnon("m1", 0.02, 0.0, 1.0, 0.01, 8.0, 2.0, MaterialType.SEMICONDUCTOR, 12);
            String expected = "{\"type\":\"magnon\",\"quasiParticle\":{\"particle\":{\"id\":\"m1\",\"mass\":0.02,\"charge\":0.00,\"spin\":1.00,\"energy\":0.01},\"lifeTime\":8.000e+00,\"coherenceLength\":2.000e+00,\"materialType\":{\"name\":\"Semiconductor\",\"density\":2.33}},\"spinFlipCount\":12}";
            String actual = magnon.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor of Magnon: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testMagnonSimulate() {
        try {
            Magnon magnon = new Magnon("m1", 0.02, 0.0, 1.0, 0.01, 8.0, 2.0, MaterialType.SILICON, 12);
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            magnon.simulate();
            System.setOut(System.out);
            String expectedOutput = "Magnon [m1] propagating in Silicon with 12 spin flips.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            magnon = new Magnon("m2", 0.03, 0.0, 1.0, 0.02, 5.0, 1.0, MaterialType.SUPERCONDUCTOR, 7);
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            magnon.simulate();
            System.setOut(System.out);
            expectedOutput = "Magnon [m2] propagating in Superconductor with 7 spin flips.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor or simulate(): " + e.getMessage());
        }
    }

}
