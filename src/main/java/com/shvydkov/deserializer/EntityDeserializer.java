package com.shvydkov.deserializer;

import java.io.FileNotFoundException;
import java.util.List;

public interface EntityDeserializer {
    <T> List<T> deserialize(String filename, Class<T> typeOf) throws FileNotFoundException;
}
