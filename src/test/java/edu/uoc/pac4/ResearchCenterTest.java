package edu.uoc.pac4;

import edu.uoc.pac4.data.DataEntry;
import edu.uoc.pac4.data.DataRepository;
import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.exception.ResearchCenterException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ResearchCenterTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(6, ResearchCenter.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("city").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("city").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("city").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("city").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("address").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("address").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("address").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("address").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("phoneNumber").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("phoneNumber").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("phoneNumber").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("phoneNumber").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("email").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("email").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("email").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredField("email").getType());

            assertTrue(Modifier.isPrivate(ResearchCenter.class.getDeclaredField("dataRepository").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredField("dataRepository").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredField("dataRepository").getModifiers()));
            assertEquals(DataRepository.class, ResearchCenter.class.getDeclaredField("dataRepository").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, ResearchCenter.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, DataRepository.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(13, ResearchCenter.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getCity").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getCity").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getCity").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getCity").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setCity", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setCity", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setCity", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setCity", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getAddress").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getAddress").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getAddress").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getAddress").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setAddress", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getPhoneNumber").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setPhoneNumber", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getEmail").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getEmail").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getEmail").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("getEmail").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setEmail", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("getDataRepository").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("getDataRepository").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("getDataRepository").getModifiers()));
            assertEquals(DataRepository.class, ResearchCenter.class.getDeclaredMethod("getDataRepository").getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getModifiers()));
            assertEquals(void.class, ResearchCenter.class.getDeclaredMethod("setDataRepository", DataRepository.class).getReturnType());

            assertTrue(Modifier.isPublic(ResearchCenter.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ResearchCenter.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(ResearchCenter.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ResearchCenter.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

}
