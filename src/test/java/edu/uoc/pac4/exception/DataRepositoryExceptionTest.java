package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataRepositoryExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(4, DataRepositoryException.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(DataRepositoryException.class.getDeclaredField("ERROR_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(DataRepositoryException.class.getDeclaredField("ERROR_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(DataRepositoryException.class.getDeclaredField("ERROR_NAME").getModifiers()));
            assertEquals(String.class, DataRepositoryException.class.getDeclaredField("ERROR_NAME").getType());
            assertEquals("Name cannot be null or blank.", DataRepositoryException.ERROR_NAME);

            assertTrue(Modifier.isPublic(DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NULL").getModifiers()));
            assertTrue(Modifier.isStatic(DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NULL").getModifiers()));
            assertTrue(Modifier.isFinal(DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NULL").getModifiers()));
            assertEquals(String.class, DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NULL").getType());
            assertEquals("Data entry cannot be null.", DataRepositoryException.ERROR_DATA_ENTRY_NULL);

            assertTrue(Modifier.isPublic(DataRepositoryException.class.getDeclaredField("ERROR_ENTRY_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isStatic(DataRepositoryException.class.getDeclaredField("ERROR_ENTRY_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isFinal(DataRepositoryException.class.getDeclaredField("ERROR_ENTRY_ALREADY_EXISTS").getModifiers()));
            assertEquals(String.class, DataRepositoryException.class.getDeclaredField("ERROR_ENTRY_ALREADY_EXISTS").getType());
            assertEquals("Data entry with this ID already exists.", DataRepositoryException.ERROR_ENTRY_ALREADY_EXISTS);

            assertTrue(Modifier.isPublic(DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isStatic(DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isFinal(DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NOT_FOUND").getModifiers()));
            assertEquals(String.class, DataRepositoryException.class.getDeclaredField("ERROR_DATA_ENTRY_NOT_FOUND").getType());
            assertEquals("Data entry not found.", DataRepositoryException.ERROR_DATA_ENTRY_NOT_FOUND);
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
        assertFalse(Modifier.isAbstract(DataRepositoryException.class.getModifiers()));
        assertTrue(AppException.class.isAssignableFrom(DataRepositoryException.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, DataRepositoryException.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(DataRepositoryException.class.getDeclaredConstructor(String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

}
