package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ResearchCenterExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(6, ResearchCenterException.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredField("ERROR_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(ResearchCenterException.class.getDeclaredField("ERROR_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(ResearchCenterException.class.getDeclaredField("ERROR_NAME").getModifiers()));
            assertEquals(String.class, ResearchCenterException.class.getDeclaredField("ERROR_NAME").getType());
            assertEquals("Name cannot be null or blank.", ResearchCenterException.ERROR_NAME);

            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredField("ERROR_ADDRESS").getModifiers()));
            assertTrue(Modifier.isStatic(ResearchCenterException.class.getDeclaredField("ERROR_ADDRESS").getModifiers()));
            assertTrue(Modifier.isFinal(ResearchCenterException.class.getDeclaredField("ERROR_ADDRESS").getModifiers()));
            assertEquals(String.class, ResearchCenterException.class.getDeclaredField("ERROR_ADDRESS").getType());
            assertEquals("Address cannot be null.", ResearchCenterException.ERROR_ADDRESS);

            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredField("ERROR_CITY").getModifiers()));
            assertTrue(Modifier.isStatic(ResearchCenterException.class.getDeclaredField("ERROR_CITY").getModifiers()));
            assertTrue(Modifier.isFinal(ResearchCenterException.class.getDeclaredField("ERROR_CITY").getModifiers()));
            assertEquals(String.class, ResearchCenterException.class.getDeclaredField("ERROR_CITY").getType());
            assertEquals("City cannot be null.", ResearchCenterException.ERROR_CITY);

            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredField("ERROR_PHONE_NUMBER").getModifiers()));
            assertTrue(Modifier.isStatic(ResearchCenterException.class.getDeclaredField("ERROR_PHONE_NUMBER").getModifiers()));
            assertTrue(Modifier.isFinal(ResearchCenterException.class.getDeclaredField("ERROR_PHONE_NUMBER").getModifiers()));
            assertEquals(String.class, ResearchCenterException.class.getDeclaredField("ERROR_PHONE_NUMBER").getType());
            assertEquals("Phone number cannot be null and it must contain a valid format", ResearchCenterException.ERROR_PHONE_NUMBER);

            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredField("ERROR_EMAIL").getModifiers()));
            assertTrue(Modifier.isStatic(ResearchCenterException.class.getDeclaredField("ERROR_EMAIL").getModifiers()));
            assertTrue(Modifier.isFinal(ResearchCenterException.class.getDeclaredField("ERROR_EMAIL").getModifiers()));
            assertEquals(String.class, ResearchCenterException.class.getDeclaredField("ERROR_EMAIL").getType());
            assertEquals("Email cannot be null and it must contain a valid format", ResearchCenterException.ERROR_EMAIL);

            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredField("ERROR_DATA_REPOSITORY").getModifiers()));
            assertTrue(Modifier.isStatic(ResearchCenterException.class.getDeclaredField("ERROR_DATA_REPOSITORY").getModifiers()));
            assertTrue(Modifier.isFinal(ResearchCenterException.class.getDeclaredField("ERROR_DATA_REPOSITORY").getModifiers()));
            assertEquals(String.class, ResearchCenterException.class.getDeclaredField("ERROR_DATA_REPOSITORY").getType());
            assertEquals("Data repository cannot be null.", ResearchCenterException.ERROR_DATA_REPOSITORY);
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
        assertFalse(Modifier.isAbstract(ResearchCenterException.class.getModifiers()));
        assertTrue(AppException.class.isAssignableFrom(ResearchCenterException.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        assertEquals(1, ResearchCenterException.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(ResearchCenterException.class.getDeclaredConstructor(String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

}
