package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ArrayExtractor {
    public static List<String> extract(String JsonArray, String value) {
        List<String> genres = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(JsonArray);

            if (rootNode.isArray()) {
                for (JsonNode genreNode : rootNode) {
                    String genreName = genreNode.get(value).asText();
                    genres.add(genreName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }
}
