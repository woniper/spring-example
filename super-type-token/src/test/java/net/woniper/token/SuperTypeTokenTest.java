package net.woniper.token;

import org.junit.Test;
import org.modelmapper.TypeToken;
import org.springframework.core.ParameterizedTypeReference;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by woniper on 2016. 11. 12..
 */
public class SuperTypeTokenTest {

    private final static String STRING_TYPE =               "java.lang.String";
    private final static String LIST_TYPE =                 "java.util.List";
    private final static String STRING_LIST_TYPE =          "java.util.List<java.lang.String>";
    private final static String STRING_OBJECT_MAP_TYPE =    "java.util.Map<java.lang.String, java.lang.Object>";

    @Test
    public void testModelMapper() throws Exception {
        assertModelMapperTypeToken(STRING_TYPE, new TypeToken<String>(){});
        assertModelMapperTypeToken(LIST_TYPE, new TypeToken<List>(){});
        assertModelMapperTypeToken(STRING_LIST_TYPE, new TypeToken<List<String>>(){});
        assertModelMapperTypeToken(STRING_OBJECT_MAP_TYPE, new TypeToken<Map<String, Object>>(){});
    }

    @Test
    public void testSpringParameterizedTypeReference() throws Exception {
        assertParameterizedTypeReference(STRING_TYPE, new ParameterizedTypeReference<String>() {});
        assertParameterizedTypeReference(LIST_TYPE, new ParameterizedTypeReference<List>() {});
        assertParameterizedTypeReference(STRING_LIST_TYPE, new ParameterizedTypeReference<List<String>>() {});
        assertParameterizedTypeReference(STRING_OBJECT_MAP_TYPE, new ParameterizedTypeReference<Map<String, Object>>() {});
    }

    private void assertModelMapperTypeToken(String expected, TypeToken<?> typeToken) {
        assertSuperTypeToken(expected, typeToken.getType());
    }

    private void assertParameterizedTypeReference(String expected, ParameterizedTypeReference<?> typeReference) {
        assertSuperTypeToken(expected, typeReference.getType());
    }

    private void assertSuperTypeToken(String expected, Type type) {
        assertThat(type.getTypeName(), is(expected));
    }
}
