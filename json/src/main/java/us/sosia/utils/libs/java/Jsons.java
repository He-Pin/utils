package us.sosia.utils.libs.java;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

/**
 * Author: kerr
 * Mail: pin.he@pekall.com
 */
public class Jsons {
    private static ObjectMapper mapper ;
    static {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T toBean(final JsonNode jsonNode,final Class<T> clazz){
        try {
            return mapper.treeToValue(jsonNode, clazz);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toBean(final String jsonStr,final Class<T> clazz){
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode toJsonNode(final String jsonStr){
        try {
            return mapper.readValue(jsonStr, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode toJsonNode(final byte[] bytes){
        try {
            return mapper.readValue(bytes, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode toJsonNode(final Object object){
        try {
            return mapper.valueToTree(object);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJsonString(final Object object){
        try {
            return mapper.writeValueAsString(object);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toJsonBytes(final Object object){
        try {
            return mapper.writeValueAsBytes(object);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectNode objectNode() {
        return mapper.createObjectNode();
    }

}
