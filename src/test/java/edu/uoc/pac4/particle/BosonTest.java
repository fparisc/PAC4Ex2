package edu.uoc.pac4.particle;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BosonTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(1, Boson.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Boson.class.getDeclaredField("forceCarrier").getModifiers()));
            assertFalse(Modifier.isStatic(Boson.class.getDeclaredField("forceCarrier").getModifiers()));
            assertFalse(Modifier.isFinal(Boson.class.getDeclaredField("forceCarrier").getModifiers()));
            assertEquals(boolean.class, Boson.class.getDeclaredField("forceCarrier").getType());
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
        assertTrue(Modifier.isAbstract(Boson.class.getModifiers()));
        assertTrue(Particle.class.isAssignableFrom(Boson.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, Boson.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Boson.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(3, Boson.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Boson.class.getDeclaredMethod("isForceCarrier").getModifiers()));
            assertFalse(Modifier.isStatic(Boson.class.getDeclaredMethod("isForceCarrier").getModifiers()));
            assertFalse(Modifier.isFinal(Boson.class.getDeclaredMethod("isForceCarrier").getModifiers()));
            assertEquals(boolean.class, Boson.class.getDeclaredMethod("isForceCarrier").getReturnType());

            assertTrue(Modifier.isPublic(Boson.class.getDeclaredMethod("setForceCarrier", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Boson.class.getDeclaredMethod("setForceCarrier", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Boson.class.getDeclaredMethod("setForceCarrier", boolean.class).getModifiers()));
            assertEquals(void.class, Boson.class.getDeclaredMethod("setForceCarrier", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Boson.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Boson.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Boson.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Boson.class.getDeclaredMethod("toString").getReturnType());

        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - forceCarrier")
    public void testBosonForceCarrier() {
        try {
            Gluon gluon = new Gluon("g", 0.0, 0.0, 1.0, 0.0, true, "red");
            assertTrue(gluon.isForceCarrier());

            gluon = new Gluon("g", 0.0, 0.0, 1.0, 0.0, false, "red");
            assertFalse(gluon.isForceCarrier());

            gluon.setForceCarrier(true);
            assertTrue(gluon.isForceCarrier());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

}
