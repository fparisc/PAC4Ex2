package edu.uoc.pac4.particle;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MaterialTypeTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsDefinition() {
        assertEquals(7, MaterialType.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredField("SILICON").getModifiers()));
            assertTrue(Modifier.isStatic(MaterialType.class.getDeclaredField("SILICON").getModifiers()));
            assertTrue(Modifier.isFinal(MaterialType.class.getDeclaredField("SILICON").getModifiers()));
            assertEquals(MaterialType.class, MaterialType.class.getDeclaredField("SILICON").getType());

            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredField("GRAPHENE").getModifiers()));
            assertTrue(Modifier.isStatic(MaterialType.class.getDeclaredField("GRAPHENE").getModifiers()));
            assertTrue(Modifier.isFinal(MaterialType.class.getDeclaredField("GRAPHENE").getModifiers()));
            assertEquals(MaterialType.class, MaterialType.class.getDeclaredField("GRAPHENE").getType());

            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredField("SEMICONDUCTOR").getModifiers()));
            assertTrue(Modifier.isStatic(MaterialType.class.getDeclaredField("SEMICONDUCTOR").getModifiers()));
            assertTrue(Modifier.isFinal(MaterialType.class.getDeclaredField("SEMICONDUCTOR").getModifiers()));
            assertEquals(MaterialType.class, MaterialType.class.getDeclaredField("SEMICONDUCTOR").getType());

            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredField("SUPERCONDUCTOR").getModifiers()));
            assertTrue(Modifier.isStatic(MaterialType.class.getDeclaredField("SUPERCONDUCTOR").getModifiers()));
            assertTrue(Modifier.isFinal(MaterialType.class.getDeclaredField("SUPERCONDUCTOR").getModifiers()));
            assertEquals(MaterialType.class, MaterialType.class.getDeclaredField("SUPERCONDUCTOR").getType());

            assertTrue(Modifier.isPrivate(MaterialType.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(MaterialType.class.getDeclaredField("name").getModifiers()));
            assertTrue(Modifier.isFinal(MaterialType.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, MaterialType.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(MaterialType.class.getDeclaredField("density").getModifiers()));
            assertFalse(Modifier.isStatic(MaterialType.class.getDeclaredField("density").getModifiers()));
            assertTrue(Modifier.isFinal(MaterialType.class.getDeclaredField("density").getModifiers()));
            assertEquals(double.class, MaterialType.class.getDeclaredField("density").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(1, MaterialType.class.getDeclaredConstructors().length);
        assertEquals(5, Arrays.stream(MaterialType.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredMethod("getDensity").getModifiers()));
            assertFalse(Modifier.isStatic(MaterialType.class.getDeclaredMethod("getDensity").getModifiers()));
            assertFalse(Modifier.isFinal(MaterialType.class.getDeclaredMethod("getDensity").getModifiers()));
            assertEquals(double.class, MaterialType.class.getDeclaredMethod("getDensity").getReturnType());

            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(MaterialType.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(MaterialType.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, MaterialType.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(MaterialType.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(MaterialType.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(MaterialType.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, MaterialType.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("minimum")
    @DisplayName("Minimum - Attributes")
    public void testMaterialTypeSymbol() {
        MaterialType silicon = MaterialType.SILICON;
        assertEquals("Silicon", silicon.getName());
        assertEquals(2.33, silicon.getDensity(), 0.01);

        MaterialType graphene = MaterialType.GRAPHENE;
        assertEquals("Graphene", graphene.getName());
        assertEquals(2.26, graphene.getDensity(), 0.01);

        MaterialType semiconductor = MaterialType.SEMICONDUCTOR;
        assertEquals("Semiconductor", semiconductor.getName());
        assertEquals(2.33, semiconductor.getDensity(), 0.01);

        MaterialType superconductor = MaterialType.SUPERCONDUCTOR;
        assertEquals("Superconductor", superconductor.getName());
        assertEquals(8.96, superconductor.getDensity(), 0.01);
    }

    private String normalize(String input) {
        return input.replaceAll("\\s*([:,{}])\\s*", "$1").trim();
    }

    @Test
    @Order(4)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testMaterialTypeToString() {
        MaterialType silicon = MaterialType.SILICON;
        String expected = "{\"name\": \"Silicon\", \"density\": 2.33}";
        String actual = silicon.toString();
        assertEquals(normalize(expected), normalize(actual));

        MaterialType graphene = MaterialType.GRAPHENE;
        expected = "{\"name\": \"Graphene\", \"density\": 2.26}";
        actual = graphene.toString();
        assertEquals(normalize(expected), normalize(actual));

        MaterialType semiconductor = MaterialType.SEMICONDUCTOR;
        expected = "{\"name\": \"Semiconductor\", \"density\": 2.33}";
        actual = semiconductor.toString();
        assertEquals(normalize(expected), normalize(actual));

        MaterialType superconductor = MaterialType.SUPERCONDUCTOR;
        expected = "{\"name\": \"Superconductor\", \"density\": 8.96}";
        actual = superconductor.toString();
        assertEquals(normalize(expected), normalize(actual));
    }

}
