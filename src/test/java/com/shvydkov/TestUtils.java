package com.shvydkov;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestUtils {

    public static String readFileContent(String fileName) throws IOException {
        ClassLoader classLoader = TestUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return new String(Files.readAllBytes(file.toPath()));
    }

}
