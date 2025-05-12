package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParticleExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(15, ParticleException.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_ID").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_ID").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_ID").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_ID").getType());
            assertEquals("ID cannot be null or blank.", ParticleException.ERROR_ID);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_MASS").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_MASS").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_MASS").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_MASS").getType());
            assertEquals("Mass cannot be negative or infinite.", ParticleException.ERROR_MASS);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_CHARGE").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_CHARGE").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_CHARGE").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_CHARGE").getType());
            assertEquals("Charge cannot be infinite.", ParticleException.ERROR_CHARGE);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_SPIN").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_SPIN").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_SPIN").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_SPIN").getType());
            assertEquals("Spin cannot be negative or infinite.", ParticleException.ERROR_SPIN);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_ENERGY").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_ENERGY").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_ENERGY").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_ENERGY").getType());
            assertEquals("Energy cannot be negative or infinite.", ParticleException.ERROR_ENERGY);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_WAVELENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_WAVELENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_WAVELENGTH").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_WAVELENGTH").getType());
            assertEquals("Wavelength cannot be negative or infinite.", ParticleException.ERROR_WAVELENGTH);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_COLOR_CHARGE").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_COLOR_CHARGE").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_COLOR_CHARGE").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_COLOR_CHARGE").getType());
            assertEquals("Color charge cannot be null or blank.", ParticleException.ERROR_COLOR_CHARGE);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_LIFETIME").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_LIFETIME").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_LIFETIME").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_LIFETIME").getType());
            assertEquals("Lifetime cannot be negative, zero or infinite.", ParticleException.ERROR_LIFETIME);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_COHERENCE_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_COHERENCE_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_COHERENCE_LENGTH").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_COHERENCE_LENGTH").getType());
            assertEquals("Coherence length cannot be negative or infinite.", ParticleException.ERROR_COHERENCE_LENGTH);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_MATERIAL_TYPE").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_MATERIAL_TYPE").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_MATERIAL_TYPE").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_MATERIAL_TYPE").getType());
            assertEquals("Material type cannot be null.", ParticleException.ERROR_MATERIAL_TYPE);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_VIBRATION_MODE").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_VIBRATION_MODE").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_VIBRATION_MODE").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_VIBRATION_MODE").getType());
            assertEquals("Vibration mode cannot be null or blank.", ParticleException.ERROR_VIBRATION_MODE);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_SPIN_FLIP_COUNT").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_SPIN_FLIP_COUNT").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_SPIN_FLIP_COUNT").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_SPIN_FLIP_COUNT").getType());
            assertEquals("Spin flip count cannot be negative.", ParticleException.ERROR_SPIN_FLIP_COUNT);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_LEPTON_NUMBER").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_LEPTON_NUMBER").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_LEPTON_NUMBER").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_LEPTON_NUMBER").getType());
            assertEquals("Lepton number cannot be negative.", ParticleException.ERROR_LEPTON_NUMBER);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_DECAY_TIME").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_DECAY_TIME").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_DECAY_TIME").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_DECAY_TIME").getType());
            assertEquals("Decay time cannot be negative or infinite.", ParticleException.ERROR_DECAY_TIME);

            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredField("ERROR_BINDING_ENERGY").getModifiers()));
            assertTrue(Modifier.isStatic(ParticleException.class.getDeclaredField("ERROR_BINDING_ENERGY").getModifiers()));
            assertTrue(Modifier.isFinal(ParticleException.class.getDeclaredField("ERROR_BINDING_ENERGY").getModifiers()));
            assertEquals(String.class, ParticleException.class.getDeclaredField("ERROR_BINDING_ENERGY").getType());
            assertEquals("Binding energy cannot be negative or infinite.", ParticleException.ERROR_BINDING_ENERGY);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Class definition")
    @SuppressWarnings("ConstantConditions")
    public void checkClassSanity() {
        assertFalse(Modifier.isAbstract(ParticleException.class.getModifiers()));
        assertTrue(AppException.class.isAssignableFrom(ParticleException.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, ParticleException.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(ParticleException.class.getDeclaredConstructor(String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

}
