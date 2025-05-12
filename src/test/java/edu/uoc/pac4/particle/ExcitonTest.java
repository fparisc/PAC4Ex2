package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExcitonTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(2, Exciton.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Exciton.class.getDeclaredField("bindingEnergy").getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredField("bindingEnergy").getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredField("bindingEnergy").getModifiers()));
            assertEquals(double.class, Exciton.class.getDeclaredField("bindingEnergy").getType());

            assertTrue(Modifier.isPrivate(Exciton.class.getDeclaredField("decayTime").getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredField("decayTime").getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredField("decayTime").getModifiers()));
            assertEquals(double.class, Exciton.class.getDeclaredField("decayTime").getType());
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
        assertFalse(Modifier.isAbstract(Exciton.class.getModifiers()));
        assertTrue(QuasiParticle.class.isAssignableFrom(Exciton.class));
        assertTrue(QuantumDecaying.class.isAssignableFrom(Exciton.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Exciton.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, double.class, double.class, MaterialType.class, double.class, double.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethod() {
        assertEquals(6, Exciton.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredMethod("getBindingEnergy").getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredMethod("getBindingEnergy").getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredMethod("getBindingEnergy").getModifiers()));
            assertEquals(double.class, Exciton.class.getDeclaredMethod("getBindingEnergy").getReturnType());

            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredMethod("setBindingEnergy", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredMethod("setBindingEnergy", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredMethod("setBindingEnergy", double.class).getModifiers()));
            assertEquals(void.class, Exciton.class.getDeclaredMethod("setBindingEnergy", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredMethod("getDecayTime").getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredMethod("getDecayTime").getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredMethod("getDecayTime").getModifiers()));
            assertEquals(double.class, Exciton.class.getDeclaredMethod("getDecayTime").getReturnType());

            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredMethod("setDecayTime", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredMethod("setDecayTime", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredMethod("setDecayTime", double.class).getModifiers()));
            assertEquals(void.class, Exciton.class.getDeclaredMethod("setDecayTime", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Exciton.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Exciton.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Exciton.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Exciton.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Exciton.class.getDeclaredMethod("simulate").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testExcitonValidParameters() {
        try {
            Exciton exciton = new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, 1.0, 2.0);
            assertEquals("Exciton1", exciton.getId());
            assertEquals(0.511, exciton.getMass());
            assertEquals(1.6e-19, exciton.getCharge());
            assertEquals(0.5, exciton.getSpin());
            assertEquals(1.0, exciton.getEnergy());
            assertEquals(0.51, exciton.getLifeTime());
            assertEquals(0.46, exciton.getCoherenceLength());
            assertEquals(MaterialType.SEMICONDUCTOR, exciton.getMaterialType());
            assertEquals(1.0, exciton.getBindingEnergy());
            assertEquals(2.0, exciton.getDecayTime());

            // Create another with different values
            Exciton exciton2 = new Exciton("Exciton2", 0.512, 1.7e-19, 0.6, 1.1, 0.52, 0.47, MaterialType.GRAPHENE, 1.1, 2.1);
            assertEquals("Exciton2", exciton2.getId());
            assertEquals(0.512, exciton2.getMass());
            assertEquals(1.7e-19, exciton2.getCharge());
            assertEquals(0.6, exciton2.getSpin());
            assertEquals(1.1, exciton2.getEnergy());
            assertEquals(0.52, exciton2.getLifeTime());
            assertEquals(0.47, exciton2.getCoherenceLength());
            assertEquals(MaterialType.GRAPHENE, exciton2.getMaterialType());
            assertEquals(1.1, exciton2.getBindingEnergy());
            assertEquals(2.1, exciton2.getDecayTime());
        } catch (ParticleException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Binding energy")
    public void testExcitonBindingEnergy() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, -1.0, 2.0));
            assertEquals("[ERROR] Binding energy cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, Double.POSITIVE_INFINITY, 2.0));
            assertEquals("[ERROR] Binding energy cannot be negative or infinite.", exception.getMessage());

            Exciton exciton = new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, 1.0, 2.0);
            assertEquals(1.0, exciton.getBindingEnergy());

            exception = assertThrows(ParticleException.class, () -> exciton.setBindingEnergy(-1.0));
            assertEquals("[ERROR] Binding energy cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> exciton.setBindingEnergy(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Binding energy cannot be negative or infinite.", exception.getMessage());

            exciton.setBindingEnergy(1.5);
            assertEquals(1.5, exciton.getBindingEnergy());

            exciton.setBindingEnergy(0.7);
            assertEquals(0.7, exciton.getBindingEnergy());
        } catch (ParticleException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Decay time")
    public void testExcitonDecayTime() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, 1.0, -1.0));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, 1.0, Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            Exciton exciton = new Exciton("Exciton1", 0.511, 1.6e-19, 0.5, 1.0, 0.51, 0.46, MaterialType.SEMICONDUCTOR, 1.0, 2.0);
            assertEquals(2.0, exciton.getDecayTime());

            exception = assertThrows(ParticleException.class, () -> exciton.setDecayTime(-1.0));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> exciton.setDecayTime(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Decay time cannot be negative or infinite.", exception.getMessage());

            exciton.setDecayTime(3.5);
            assertEquals(3.5, exciton.getDecayTime());

            exciton.setDecayTime(4.2);
            assertEquals(4.2, exciton.getDecayTime());
        } catch (ParticleException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Minimum - toString")
    public void testExcitonToString() {
        try {
            Exciton exciton = new Exciton("x1", 0.05, 0.0, 0.5, 1.2, 5.0, 0.8, MaterialType.SEMICONDUCTOR, 1.50, 2.5e-9);
            String expected = "{\"type\":\"exciton\",\"quasiParticle\":{\"particle\":{\"id\":\"x1\",\"mass\":0.05,\"charge\":0.00,\"spin\":0.50,\"energy\":1.20},\"lifeTime\":5.000e+00,\"coherenceLength\":8.000e-01,\"materialType\":{\"name\":\"Semiconductor\",\"density\":2.33}},\"bindingEnergy\":1.50,\"decayTime\":2.50e-09}";
            String actual = exciton.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor of Exciton: " + e.getMessage());
        }
    }

    @Test
    @Order(9)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testExcitonSimulate() {
        try {
            Exciton exciton = new Exciton("x1", 0.05, 0.0, 0.5, 1.2, 5.0, 0.8, MaterialType.SEMICONDUCTOR, 1.50, 2.5e-9);
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            exciton.simulate();
            System.setOut(System.out);
            String expectedOutput = "Exciton [x1] with binding energy 1.50 eV decays after 2.50e-09 s.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            exciton = new Exciton("x2", 0.04, 0.0, 0.5, 1.0, 4.0, 1.0, MaterialType.SUPERCONDUCTOR, 0.90, 1.0e-8);
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            exciton.simulate();
            System.setOut(System.out);
            expectedOutput = "Exciton [x2] with binding energy 0.90 eV decays after 1.00e-08 s.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the constructor or simulate() of Exciton: " + e.getMessage());
        }
    }

}
