package com.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MapperUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // Register any additional modules if needed
        OBJECT_MAPPER.findAndRegisterModules();
    }

    /**
     * Read a JSON file and map its contents to a custom object.
     *
     * @param file  The JSON file to read.
     * @param clazz The class type to map to.
     * @param <T>   The type of the object to return.
     * @return      The mapped object.
     * @throws IOException If the file cannot be read or mapped.
     */
    public static <T> T readFileToObject(File file, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(file, clazz);
    }

    /**
     * Read an input stream and map its contents to a custom object.
     *
     * @param inputStream The input stream to read.
     * @param clazz       The class type to map to.
     * @param <T>         The type of the object to return.
     * @return            The mapped object.
     * @throws IOException If the input stream cannot be read or mapped.
     */
    public static <T> T readStreamToObject(InputStream inputStream, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(inputStream, clazz);
    }

    /**
     * Convert a JSON string to a custom object.
     *
     * @param content The JSON string.
     * @param clazz   The class type to map to.
     * @param <T>     The type of the object to return.
     * @return        The mapped object.
     * @throws IOException If the string cannot be mapped.
     */
    public static <T> T readStringToObject(String content, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(content, clazz);
    }

    /**
     * Convert a JSON string to a list or map of custom objects.
     *
     * @param content The JSON string.
     * @param typeRef The type reference for the object.
     * @param <T>     The type of the object to return.
     * @return        The mapped object.
     * @throws IOException If the string cannot be mapped.
     */
    public static <T> T readStringToList(String content, TypeReference<T> typeRef) throws IOException {
        return OBJECT_MAPPER.readValue(content, typeRef);
    }

    /**
     * Convert an object to a JSON string.
     *
     * @param object The object to serialize.
     * @return       The serialized JSON string.
     * @throws IOException If the object cannot be serialized.
     */
    public static String writeObjectToString(Object object) throws IOException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    /**
     * Write an object to a JSON file.
     *
     * @param file   The file to write to.
     * @param object The object to serialize.
     * @throws IOException If the object cannot be serialized.
     */
    public static void writeObjectToFile(File file, Object object) throws IOException {
        OBJECT_MAPPER.writeValue(file, object);
    }

    /**
     * Convert a Map<String, Object> to a custom object.
     *
     * @param map   The map containing data.
     * @param clazz The class type to map to.
     * @param <T>   The type of the object to return.
     * @return      The mapped object.
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }
}

