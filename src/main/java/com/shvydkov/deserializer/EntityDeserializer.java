package com.shvydkov.deserializer;

import java.io.FileNotFoundException;
import java.util.List;

public interface EntityDeserializer {
    String DEFAULT_RECOURSE_PATH = "src/main/resources/tables/";
    String TEST_RECOURSE_PATH = "src/main/test/resources/tables/";

    <T> List<T> deserialize(String filename, Class<T> typeOf) throws FileNotFoundException;
}
