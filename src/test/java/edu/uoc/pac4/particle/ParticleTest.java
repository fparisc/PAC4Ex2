package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParticleTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(5, Particle.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Particle.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredField("id").getModifiers()));
            assertEquals(String.class, Particle.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(Particle.class.getDeclaredField("mass").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredField("mass").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredField("mass").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredField("mass").getType());

            assertTrue(Modifier.isPrivate(Particle.class.getDeclaredField("charge").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredField("charge").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredField("charge").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredField("charge").getType());

            assertTrue(Modifier.isPrivate(Particle.class.getDeclaredField("spin").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredField("spin").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredField("spin").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredField("spin").getType());

            assertTrue(Modifier.isPrivate(Particle.class.getDeclaredField("energy").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredField("energy").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredField("energy").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredField("energy").getType());
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
        assertTrue(Modifier.isAbstract(Particle.class.getModifiers()));
        assertTrue(Cloneable.class.isAssignableFrom(Particle.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Particle.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Particle.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(12, Particle.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(String.class, Particle.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("setId", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("setId", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("setId", String.class).getModifiers()));
            assertEquals(void.class, Particle.class.getDeclaredMethod("setId", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("getMass").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("getMass").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("getMass").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredMethod("getMass").getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("setMass", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("setMass", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("setMass", double.class).getModifiers()));
            assertEquals(void.class, Particle.class.getDeclaredMethod("setMass", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("getCharge").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("getCharge").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("getCharge").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredMethod("getCharge").getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("setCharge", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("setCharge", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("setCharge", double.class).getModifiers()));
            assertEquals(void.class, Particle.class.getDeclaredMethod("setCharge", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("getSpin").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("getSpin").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("getSpin").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredMethod("getSpin").getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("setSpin", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("setSpin", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("setSpin", double.class).getModifiers()));
            assertEquals(void.class, Particle.class.getDeclaredMethod("setSpin", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("getEnergy").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("getEnergy").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("getEnergy").getModifiers()));
            assertEquals(double.class, Particle.class.getDeclaredMethod("getEnergy").getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("setEnergy", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("setEnergy", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("setEnergy", double.class).getModifiers()));
            assertEquals(void.class, Particle.class.getDeclaredMethod("setEnergy", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Particle.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(Particle.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isStatic(Particle.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isFinal(Particle.class.getDeclaredMethod("clone").getModifiers()));
            assertEquals(Object.class, Particle.class.getDeclaredMethod("clone").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Id")
    public void testParticleId() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Electron(null, 0.511, -1.0, 0.5, 1.0, 1));
            assertEquals("[ERROR] ID cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Electron("", 0.511, -1.0, 0.5, 1.0, 1));
            assertEquals("[ERROR] ID cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Electron(" ", 0.511, -1.0, 0.5, 1.0, 1));
            assertEquals("[ERROR] ID cannot be null or blank.", exception.getMessage());

            Electron particle = new Electron("Electron", 0.511, -1.0, 0.5, 1.0, 1);
            assertEquals("Electron", particle.getId());

            particle.setId("Electron2");
            assertEquals("Electron2", particle.getId());

            exception = assertThrows(ParticleException.class, () -> particle.setId(null));
            assertEquals("[ERROR] ID cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> particle.setId(""));
            assertEquals("[ERROR] ID cannot be null or blank.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> particle.setId(" "));
            assertEquals("[ERROR] ID cannot be null or blank.", exception.getMessage());

            particle.setId("Electron3");
            assertEquals("Electron3", particle.getId());
        } catch (AppException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Mass")
    public void testParticleMass() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Electron("Electron", -1.0, -1.0, 0.5, 1.0, 1));
            assertEquals("[ERROR] Mass cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Electron("Electron", Double.POSITIVE_INFINITY, -1.0, 0.5, 1.0, 1));
            assertEquals("[ERROR] Mass cannot be negative or infinite.", exception.getMessage());

            Electron particle = new Electron("Electron", 0.511, -1.0, 0.5, 1.0, 1);
            assertEquals(0.511, particle.getMass());

            particle.setMass(1.0);
            assertEquals(1.0, particle.getMass());

            exception = assertThrows(ParticleException.class, () -> particle.setMass(-1));
            assertEquals("[ERROR] Mass cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> particle.setMass(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Mass cannot be negative or infinite.", exception.getMessage());

            particle.setMass(2.0);
            assertEquals(2.0, particle.getMass());
        } catch (AppException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Charge")
    public void testParticleCharge() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 0.511, Double.POSITIVE_INFINITY, 0.5, 1.0, 1));
            assertEquals("[ERROR] Charge cannot be infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 0.511, Double.NEGATIVE_INFINITY, 0.5, 1.0, 1));
            assertEquals("[ERROR] Charge cannot be infinite.", exception.getMessage());

            Electron particle = new Electron("Electron", 0.511, -1.0, 0.5, 1.0, 1);
            assertEquals(-1.0, particle.getCharge());

            particle = new Electron("Electron", 0.511, 0, 0.5, 1.0, 1);
            assertEquals(0, particle.getCharge());

            particle.setCharge(1.0);
            assertEquals(1.0, particle.getCharge());

            particle.setCharge(0);
            assertEquals(0, particle.getCharge());

            Electron finalParticle = particle;
            exception = assertThrows(ParticleException.class, () -> finalParticle.setCharge(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Charge cannot be infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> finalParticle.setCharge(Double.NEGATIVE_INFINITY));
            assertEquals("[ERROR] Charge cannot be infinite.", exception.getMessage());

            particle.setCharge(-2.0);
            assertEquals(-2.0, particle.getCharge());
        } catch (AppException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - Spin")
    public void testParticleSpin() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 0.511, -1.0, -1.0, 1.0, 1));
            assertEquals("[ERROR] Spin cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 0.511, -1.0, Double.POSITIVE_INFINITY, 1.0, 1));
            assertEquals("[ERROR] Spin cannot be negative or infinite.", exception.getMessage());

            Electron particle = new Electron("Electron", 0.511, -1.0, 0.5, 1.0, 1);
            assertEquals(0.5, particle.getSpin());

            particle = new Electron("Electron", 0.511, -1.0, 0, 1.0, 1);
            assertEquals(0, particle.getSpin());

            particle.setSpin(1.0);
            assertEquals(1.0, particle.getSpin());

            particle.setSpin(0);
            assertEquals(0, particle.getSpin());

            Electron finalParticle = particle;
            exception = assertThrows(ParticleException.class, () -> finalParticle.setSpin(-1));
            assertEquals("[ERROR] Spin cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> finalParticle.setSpin(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Spin cannot be negative or infinite.", exception.getMessage());

            particle.setSpin(2.0);
            assertEquals(2.0, particle.getSpin());
        } catch (AppException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(9)
    @Tag("minimum")
    @DisplayName("Minimum - Energy")
    public void testParticleEnergy() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 0.511, -1.0, 0.5, -1.0, 1));
            assertEquals("[ERROR] Energy cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 0.511, -1.0, 0.5, Double.POSITIVE_INFINITY, 1));
            assertEquals("[ERROR] Energy cannot be negative or infinite.", exception.getMessage());

            Electron particle = new Electron("Electron", 0.511, -1.0, 0.5, 1.0, 1);
            assertEquals(1.0, particle.getEnergy());

            particle = new Electron("Electron", 0.511, -1.0, 0.5, 0, 1);
            assertEquals(0, particle.getEnergy());

            particle.setEnergy(2.0);
            assertEquals(2.0, particle.getEnergy());

            particle.setEnergy(0);
            assertEquals(0, particle.getEnergy());

            Electron finalParticle = particle;
            exception = assertThrows(ParticleException.class, () -> finalParticle.setEnergy(-1));
            assertEquals("[ERROR] Energy cannot be negative or infinite.", exception.getMessage());

            exception = assertThrows(ParticleException.class, () -> finalParticle.setEnergy(Double.POSITIVE_INFINITY));
            assertEquals("[ERROR] Energy cannot be negative or infinite.", exception.getMessage());

            particle.setEnergy(3.0);
            assertEquals(3.0, particle.getEnergy());
        } catch (AppException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(10)
    @Tag("advanced")
    @DisplayName("Advanced - clone")
    public void checkClone() {
        try {
            Majorana majorana = new Majorana("Majorana", 1.0, 0.0, 0.5, 1.0, 1.0, 1.0, MaterialType.SEMICONDUCTOR, true);
            Majorana majoranaClone = (Majorana) majorana.clone();

            assertNotSame(majorana, majoranaClone);

            assertEquals(majorana.getId(), majoranaClone.getId());
            assertEquals(majorana.getMass(), majoranaClone.getMass());
            assertEquals(majorana.getCharge(), majoranaClone.getCharge());
            assertEquals(majorana.getSpin(), majoranaClone.getSpin());
            assertEquals(majorana.getEnergy(), majoranaClone.getEnergy());
            assertEquals(majorana.getLifeTime(), majoranaClone.getLifeTime());
            assertEquals(majorana.getCoherenceLength(), majoranaClone.getCoherenceLength());
            assertEquals(majorana.getMaterialType(), majoranaClone.getMaterialType());
            assertEquals(majorana.getMaterialType(), majoranaClone.getMaterialType());
            assertEquals(majorana.isSelfConjugate(), majoranaClone.isSelfConjugate());

            Electron electron = new Electron("Electron", 0.511, -1.0, 0.5, 1.0, 1);
            Electron electronClone = (Electron) electron.clone();

            assertNotSame(electron, electronClone);

            assertEquals(electron.getId(), electronClone.getId());
            assertEquals(electron.getMass(), electronClone.getMass());
            assertEquals(electron.getCharge(), electronClone.getCharge());
            assertEquals(electron.getSpin(), electronClone.getSpin());
            assertEquals(electron.getEnergy(), electronClone.getEnergy());
            assertEquals(electron.getLeptonNumber(), electronClone.getLeptonNumber());
        } catch (AppException | CloneNotSupportedException e) {
            fail("[ERROR] There is some problem with the definition of the clone method: " + e.getMessage());
        }

    }

}
