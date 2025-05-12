package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataEntryExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(5, DataEntryException.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(DataEntryException.class.getDeclaredField("ERROR_ID").getModifiers()));
            assertTrue(Modifier.isStatic(DataEntryException.class.getDeclaredField("ERROR_ID").getModifiers()));
            assertTrue(Modifier.isFinal(DataEntryException.class.getDeclaredField("ERROR_ID").getModifiers()));
            assertEquals(String.class, DataEntryException.class.getDeclaredField("ERROR_ID").getType());
            assertEquals("ID cannot be negative or zero.", DataEntryException.ERROR_ID);

            assertTrue(Modifier.isPublic(DataEntryException.class.getDeclaredField("ERROR_TITLE").getModifiers()));
            assertTrue(Modifier.isStatic(DataEntryException.class.getDeclaredField("ERROR_TITLE").getModifiers()));
            assertTrue(Modifier.isFinal(DataEntryException.class.getDeclaredField("ERROR_TITLE").getModifiers()));
            assertEquals(String.class, DataEntryException.class.getDeclaredField("ERROR_TITLE").getType());
            assertEquals("Title cannot be null or blank.", DataEntryException.ERROR_TITLE);

            assertTrue(Modifier.isPublic(DataEntryException.class.getDeclaredField("ERROR_TIMESTAMP").getModifiers()));
            assertTrue(Modifier.isStatic(DataEntryException.class.getDeclaredField("ERROR_TIMESTAMP").getModifiers()));
            assertTrue(Modifier.isFinal(DataEntryException.class.getDeclaredField("ERROR_TIMESTAMP").getModifiers()));
            assertEquals(String.class, DataEntryException.class.getDeclaredField("ERROR_TIMESTAMP").getType());
            assertEquals("Timestamp cannot be null or in the future.", DataEntryException.ERROR_TIMESTAMP);

            assertTrue(Modifier.isPublic(DataEntryException.class.getDeclaredField("ERROR_OBSERVATIONS").getModifiers()));
            assertTrue(Modifier.isStatic(DataEntryException.class.getDeclaredField("ERROR_OBSERVATIONS").getModifiers()));
            assertTrue(Modifier.isFinal(DataEntryException.class.getDeclaredField("ERROR_OBSERVATIONS").getModifiers()));
            assertEquals(String.class, DataEntryException.class.getDeclaredField("ERROR_OBSERVATIONS").getType());
            assertEquals("Observations cannot be null.", DataEntryException.ERROR_OBSERVATIONS);

            assertTrue(Modifier.isPublic(DataEntryException.class.getDeclaredField("ERROR_PARTICLE").getModifiers()));
            assertTrue(Modifier.isStatic(DataEntryException.class.getDeclaredField("ERROR_PARTICLE").getModifiers()));
            assertTrue(Modifier.isFinal(DataEntryException.class.getDeclaredField("ERROR_PARTICLE").getModifiers()));
            assertEquals(String.class, DataEntryException.class.getDeclaredField("ERROR_PARTICLE").getType());
            assertEquals("Particle cannot be null.", DataEntryException.ERROR_PARTICLE);
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
        assertFalse(Modifier.isAbstract(DataEntryException.class.getModifiers()));
        assertTrue(AppException.class.isAssignableFrom(DataEntryException.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, DataEntryException.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(DataEntryException.class.getDeclaredConstructor(String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

}
