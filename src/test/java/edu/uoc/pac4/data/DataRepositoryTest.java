package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.AppException;
import edu.uoc.pac4.particle.Electron;
import edu.uoc.pac4.particle.Majorana;
import edu.uoc.pac4.particle.MaterialType;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataRepositoryTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(2, DataRepository.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(DataRepository.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, DataRepository.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(DataRepository.class.getDeclaredField("dataEntries").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredField("dataEntries").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredField("dataEntries").getModifiers()));
            assertEquals(HashMap.class, DataRepository.class.getDeclaredField("dataEntries").getType());
            ParameterizedType t = (ParameterizedType) DataRepository.class.getDeclaredField("dataEntries").getGenericType();
            assertEquals(Integer.class, t.getActualTypeArguments()[0]);
            assertEquals(DataEntry.class, t.getActualTypeArguments()[1]);
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
        assertTrue(Cloneable.class.isAssignableFrom(DataRepository.class));
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, DataRepository.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredConstructor(String.class, DataEntry[].class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(6, DataRepository.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, DataRepository.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, DataRepository.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getModifiers()));
            assertEquals(void.class, DataRepository.class.getDeclaredMethod("addDataEntry", DataEntry.class).getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getModifiers()));
            assertEquals(DataEntry.class, DataRepository.class.getDeclaredMethod("getDataEntry", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, DataRepository.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(DataRepository.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isStatic(DataRepository.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isFinal(DataRepository.class.getDeclaredMethod("clone").getModifiers()));
            assertEquals(Object.class, DataRepository.class.getDeclaredMethod("clone").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("advanced")
    @DisplayName("Advanced - clone")
    public void checkClone() {
        try {
            Majorana majorana = new Majorana("M1", 0.511, 0, 1 / 2.0, 0.511, 1e-9, 1e-9, MaterialType.SEMICONDUCTOR, true);
            Electron electron = new Electron("E1", 0.511, -1, 1 / 2.0, 0.511, 1);
            DataEntry dataEntry1 = new DataEntry(1, "Test", LocalDateTime.now(), "Test observations", majorana);
            DataEntry dataEntry2 = new DataEntry(2, "Test 2", LocalDateTime.now(), "Test observations 2", electron);
            DataRepository dataRepository = new DataRepository("Test Repository", new DataEntry[]{dataEntry1, dataEntry2});

            DataRepository clonedDataRepository = (DataRepository) dataRepository.clone();

            assertNotSame(dataRepository, clonedDataRepository);
            assertEquals(dataRepository.getName(), clonedDataRepository.getName());

            assertNotSame(dataRepository.getDataEntry(1), clonedDataRepository.getDataEntry(1));
            assertNotSame(dataRepository.getDataEntry(2), clonedDataRepository.getDataEntry(2));

            assertEquals(dataRepository.getDataEntry(1).getId(), clonedDataRepository.getDataEntry(1).getId());
            assertEquals(dataRepository.getDataEntry(2).getId(), clonedDataRepository.getDataEntry(2).getId());
        } catch (CloneNotSupportedException | AppException e) {
            fail("[ERROR] There is some problem with the clone method: " + e.getMessage());
        }
    }

}
