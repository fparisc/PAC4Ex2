package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MajoranaTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Majorana.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Majorana.class.getDeclaredField("isSelfConjugate").getModifiers()));
            assertFalse(Modifier.isStatic(Majorana.class.getDeclaredField("isSelfConjugate").getModifiers()));
            assertFalse(Modifier.isFinal(Majorana.class.getDeclaredField("isSelfConjugate").getModifiers()));
            assertEquals(boolean.class, Majorana.class.getDeclaredField("isSelfConjugate").getType());
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
        assertFalse(Modifier.isAbstract(Majorana.class.getModifiers()));
        assertTrue(QuasiParticle.class.isAssignableFrom(Majorana.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Majorana.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Majorana.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, double.class, double.class, MaterialType.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(4, Majorana.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Majorana.class.getDeclaredMethod("isSelfConjugate").getModifiers()));
            assertFalse(Modifier.isStatic(Majorana.class.getDeclaredMethod("isSelfConjugate").getModifiers()));
            assertFalse(Modifier.isFinal(Majorana.class.getDeclaredMethod("isSelfConjugate").getModifiers()));
            assertEquals(boolean.class, Majorana.class.getDeclaredMethod("isSelfConjugate").getReturnType());

            assertTrue(Modifier.isPublic(Majorana.class.getDeclaredMethod("setSelfConjugate", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Majorana.class.getDeclaredMethod("setSelfConjugate", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Majorana.class.getDeclaredMethod("setSelfConjugate", boolean.class).getModifiers()));
            assertEquals(void.class, Majorana.class.getDeclaredMethod("setSelfConjugate", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Majorana.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Majorana.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Majorana.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Majorana.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Majorana.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isStatic(Majorana.class.getDeclaredMethod("simulate").getModifiers()));
            assertFalse(Modifier.isFinal(Majorana.class.getDeclaredMethod("simulate").getModifiers()));
            assertEquals(void.class, Majorana.class.getDeclaredMethod("simulate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Vaid parameters")
    public void testMajoranaValidParameters() {
        try {
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0, 0.1, 0, MaterialType.SEMICONDUCTOR, true);
            assertEquals("M1", majorana.getId());
            assertEquals(0.511, majorana.getMass());
            assertEquals(0, majorana.getCharge());
            assertEquals(1 / 2.0, majorana.getSpin());
            assertEquals(0, majorana.getEnergy());
            assertEquals(0.1, majorana.getLifeTime());
            assertEquals(0, majorana.getCoherenceLength());
            assertEquals(MaterialType.SEMICONDUCTOR, majorana.getMaterialType());
            assertTrue(majorana.isSelfConjugate());

            Majorana majorana2 = new Majorana("M2", 0.7, -0.3, 1.1, 2.1, 5.44, 2.27, MaterialType.SILICON, false);
            assertEquals("M2", majorana2.getId());
            assertEquals(0.7, majorana2.getMass());
            assertEquals(-0.3, majorana2.getCharge());
            assertEquals(1.1, majorana2.getSpin());
            assertEquals(2.1, majorana2.getEnergy());
            assertEquals(5.44, majorana2.getLifeTime());
            assertEquals(2.27, majorana2.getCoherenceLength());
            assertEquals(MaterialType.SILICON, majorana2.getMaterialType());
            assertFalse(majorana2.isSelfConjugate());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - IsSelfConjugate")
    public void testMajoranaIsSelfConjugate() {
        try {
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0, 0.1, 0, MaterialType.SEMICONDUCTOR, true);
            assertTrue(majorana.isSelfConjugate());

            majorana = new Majorana("M2", 0.7, -0.3, 1.1, 2.1, 5.44, 2.27, MaterialType.SILICON, false);
            assertFalse(majorana.isSelfConjugate());

            majorana.setSelfConjugate(true);
            assertTrue(majorana.isSelfConjugate());

            majorana.setSelfConjugate(false);
            assertFalse(majorana.isSelfConjugate());
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
    public void testMajoranaToString() {
        try {
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0, 0.1, 0, MaterialType.SEMICONDUCTOR, true);
            String expected = "{\"type\":\"majorana\",\"quasiParticle\":{\"particle\":{\"id\":\"M1\",\"mass\":0.51,\"charge\":0.00,\"spin\":0.50,\"energy\":0.00},\"lifeTime\":1.000e-01,\"coherenceLength\":0.000e+00,\"materialType\":{\"name\":\"Semiconductor\",\"density\":2.33}},\"isSelfConjugate\":true}";
            String actual = majorana.toString();
            assertEquals(normalize(expected), normalize(actual));
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - simulate")
    public void testEmergentPhononSimulate() {
        try {
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0, 0.1, 0, MaterialType.SEMICONDUCTOR, true);
            java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));
            majorana.simulate();
            System.setOut(System.out);
            String expectedOutput = "Majorana [M1] in {\"name\": \"Semiconductor\", \"density\": 2.33} material behaving as self-conjugate particle.";
            String actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);

            majorana = new Majorana("M2", 0.7, -0.3, 1.1, 2.1, 5.44, 2.27, MaterialType.SILICON, false);
            outputStream.reset();
            System.setOut(new java.io.PrintStream(outputStream));
            majorana.simulate();
            System.setOut(System.out);
            expectedOutput = "Majorana [M2] in {\"name\": \"Silicon\", \"density\": 2.33} material behaving as distinct from its antiparticle particle.";
            actualOutput = outputStream.toString().replaceAll("[\\r\\n]+", "").trim();
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructor or simulate(): " + e.getMessage());
        }
    }

}
