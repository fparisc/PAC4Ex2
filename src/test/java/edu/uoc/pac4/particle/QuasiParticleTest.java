package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QuasiParticleTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(3, QuasiParticle.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(QuasiParticle.class.getDeclaredField("lifeTime").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredField("lifeTime").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredField("lifeTime").getModifiers()));
            assertEquals(double.class, QuasiParticle.class.getDeclaredField("lifeTime").getType());

            assertTrue(Modifier.isPrivate(QuasiParticle.class.getDeclaredField("coherenceLength").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredField("coherenceLength").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredField("coherenceLength").getModifiers()));
            assertEquals(double.class, QuasiParticle.class.getDeclaredField("coherenceLength").getType());

            assertTrue(Modifier.isPrivate(QuasiParticle.class.getDeclaredField("materialType").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredField("materialType").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredField("materialType").getModifiers()));
            assertEquals(MaterialType.class, QuasiParticle.class.getDeclaredField("materialType").getType());
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
        assertTrue(Modifier.isAbstract(QuasiParticle.class.getModifiers()));
        assertTrue(Particle.class.isAssignableFrom(QuasiParticle.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, QuasiParticle.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, double.class, double.class, MaterialType.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(7, QuasiParticle.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("getLifeTime").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("getLifeTime").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("getLifeTime").getModifiers()));
            assertEquals(double.class, QuasiParticle.class.getDeclaredMethod("getLifeTime").getReturnType());

            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("setLifeTime", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("setLifeTime", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("setLifeTime", double.class).getModifiers()));

            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("getCoherenceLength").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("getCoherenceLength").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("getCoherenceLength").getModifiers()));
            assertEquals(double.class, QuasiParticle.class.getDeclaredMethod("getCoherenceLength").getReturnType());

            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("setCoherenceLength", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("setCoherenceLength", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("setCoherenceLength", double.class).getModifiers()));

            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("getMaterialType").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("getMaterialType").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("getMaterialType").getModifiers()));
            assertEquals(MaterialType.class, QuasiParticle.class.getDeclaredMethod("getMaterialType").getReturnType());

            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("setMaterialType", MaterialType.class).getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("setMaterialType", MaterialType.class).getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("setMaterialType", MaterialType.class).getModifiers()));
            assertEquals(void.class, QuasiParticle.class.getDeclaredMethod("setMaterialType", MaterialType.class).getReturnType());

            assertTrue(Modifier.isPublic(QuasiParticle.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(QuasiParticle.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(QuasiParticle.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, QuasiParticle.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - LifeTime")
    public void testQuasiParticleLifeTime() {
        ParticleException exception = assertThrows(ParticleException.class, () -> new Majorana("MP1", 0.511, 0.0, 1/2.0, 0.511, -1.0, 0.0, MaterialType.SEMICONDUCTOR, true));
        assertEquals("[ERROR] Lifetime cannot be negative, zero or infinite.", exception.getMessage());

        exception = assertThrows(ParticleException.class, () -> new Majorana("MP1", 0.511, 0.0, 1/2.0, 0.511, Double.POSITIVE_INFINITY, 0.0, MaterialType.SEMICONDUCTOR, true));
        assertEquals("[ERROR] Lifetime cannot be negative, zero or infinite.", exception.getMessage());

        exception = assertThrows(ParticleException.class, () -> new Majorana("MP1", 0.511, 0.0, 1/2.0, 0.511, 0.0, 0.0, MaterialType.SEMICONDUCTOR, true));
        assertEquals("[ERROR] Lifetime cannot be negative, zero or infinite.", exception.getMessage());

        try {
            Majorana majorana = new Majorana("MP1", 0.511, 0.0, 1/2.0, 0.511, 1.0, 1.0, MaterialType.SEMICONDUCTOR, true);
            assertEquals(1.0, majorana.getLifeTime());

            majorana = new Majorana("MP1", 0.511, 0.0, 1/2.0, 0.511, 10.9, 1.0, MaterialType.SEMICONDUCTOR, true);
            assertEquals(10.9, majorana.getLifeTime());

            Majorana finalMajorana = majorana;
            exception = assertThrows(ParticleException.class, () -> finalMajorana.setLifeTime(-1.0));
            assertEquals("[ERROR] Lifetime cannot be negative, zero or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> finalMajorana.setLifeTime(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Lifetime cannot be negative, zero or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> finalMajorana.setLifeTime(0.0));
            assertEquals("[ERROR] Lifetime cannot be negative, zero or infinite.", exception.getMessage());

            finalMajorana.setLifeTime(1.1);
            assertEquals(1.1, finalMajorana.getLifeTime());

            finalMajorana.setLifeTime(11.9);
            assertEquals(11.9, finalMajorana.getLifeTime());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - CoherenceLength")
    public void testQuasiParticleCoherenceLength() {
        ParticleException exception = assertThrows(ParticleException.class, () -> new Majorana("MP1", 0.511, 0.0, 1 / 2.0, 0.511, 1.0, -1.0, MaterialType.SEMICONDUCTOR, true));
        assertEquals("[ERROR] Coherence length cannot be negative or infinite.", exception.getMessage());

        exception = assertThrows(ParticleException.class, () -> new Majorana("MP1", 0.511, 0.0, 1 / 2.0, 0.511, 1.0, Double.POSITIVE_INFINITY, MaterialType.SEMICONDUCTOR, true));
        assertEquals("[ERROR] Coherence length cannot be negative or infinite.", exception.getMessage());

        try {
            Majorana majorana = new Majorana("MP1", 0.511, 0.0, 1 / 2.0, 0.511, 1.0, 1.5e-9, MaterialType.SEMICONDUCTOR, true);
            assertEquals(1.5e-9, majorana.getCoherenceLength());

            majorana = new Majorana("MP1", 0.511, 0.0, 1 / 2.0, 0.511, 1.0, 0.0, MaterialType.SEMICONDUCTOR, true);
            assertEquals(0.0, majorana.getCoherenceLength());

            Majorana finalMajorana = majorana;
            exception = assertThrows(ParticleException.class, () -> finalMajorana.setCoherenceLength(-1e-9));
            assertEquals("[ERROR] Coherence length cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> finalMajorana.setCoherenceLength(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Coherence length cannot be negative or infinite.", exception.getMessage());

            finalMajorana.setCoherenceLength(1.5e-9);
            assertEquals(1.5e-9, finalMajorana.getCoherenceLength());

            finalMajorana.setCoherenceLength(1.5e-8);
            assertEquals(1.5e-8, finalMajorana.getCoherenceLength());

            finalMajorana.setCoherenceLength(0.0);
            assertEquals(0.0, finalMajorana.getCoherenceLength());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - MaterialType")
    public void testQuasiParticleMaterialType() {
        ParticleException exception = assertThrows(ParticleException.class, () -> new Majorana("MP1", 0.511, 0.0, 1 / 2.0, 0.511, 1.0, 1.5e-9, null, true));
        assertEquals("[ERROR] Material type cannot be null.", exception.getMessage());

        try {
            Majorana majorana = new Majorana("MP1", 0.511, 0.0, 1 / 2.0, 0.511, 1.0, 1.5e-9, MaterialType.SEMICONDUCTOR, true);
            assertEquals(MaterialType.SEMICONDUCTOR, majorana.getMaterialType());

            exception = assertThrows(ParticleException.class, () -> majorana.setMaterialType(null));
            assertEquals("[ERROR] Material type cannot be null.", exception.getMessage());

            majorana.setMaterialType(MaterialType.SEMICONDUCTOR);
            assertEquals(MaterialType.SEMICONDUCTOR, majorana.getMaterialType());
        } catch (ParticleException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

}
