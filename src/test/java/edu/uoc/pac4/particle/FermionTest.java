package edu.uoc.pac4.particle;

import edu.uoc.pac4.exception.ParticleException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FermionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Fermion.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Fermion.class.getDeclaredField("leptonNumber").getModifiers()));
            assertFalse(Modifier.isStatic(Fermion.class.getDeclaredField("leptonNumber").getModifiers()));
            assertFalse(Modifier.isFinal(Fermion.class.getDeclaredField("leptonNumber").getModifiers()));
            assertEquals(int.class, Fermion.class.getDeclaredField("leptonNumber").getType());
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
        assertTrue(Modifier.isAbstract(Fermion.class.getModifiers()));
        assertTrue(Particle.class.isAssignableFrom(Fermion.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Fermion.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Fermion.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(3, Fermion.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Fermion.class.getDeclaredMethod("getLeptonNumber").getModifiers()));
            assertFalse(Modifier.isStatic(Fermion.class.getDeclaredMethod("getLeptonNumber").getModifiers()));
            assertFalse(Modifier.isFinal(Fermion.class.getDeclaredMethod("getLeptonNumber").getModifiers()));
            assertEquals(int.class, Fermion.class.getDeclaredMethod("getLeptonNumber").getReturnType());

            assertTrue(Modifier.isPublic(Fermion.class.getDeclaredMethod("setLeptonNumber", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Fermion.class.getDeclaredMethod("setLeptonNumber", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Fermion.class.getDeclaredMethod("setLeptonNumber", int.class).getModifiers()));
            assertEquals(void.class, Fermion.class.getDeclaredMethod("setLeptonNumber", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Fermion.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Fermion.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Fermion.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Fermion.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Lepton number")
    public void testFermionLeptonNumber() {
        try {
            ParticleException exception = assertThrows(ParticleException.class, () -> new Electron("Electron", 1.0, 1.0, 1.0, 1.0, -1));
            assertEquals("[ERROR] Lepton number cannot be negative.", exception.getMessage());

            Electron electron = new Electron("Fermion", 1.0, 1.0, 1.0, 1.0, 1);
            assertEquals(1, electron.getLeptonNumber());

            exception = assertThrows(ParticleException.class, () -> electron.setLeptonNumber(-1));
            assertEquals("[ERROR] Lepton number cannot be negative.", exception.getMessage());

            electron.setLeptonNumber(2);
            assertEquals(2, electron.getLeptonNumber());

            electron.setLeptonNumber(0);
            assertEquals(0, electron.getLeptonNumber());
        } catch (Exception e) {
            fail("There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
