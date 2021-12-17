package com.petroskovatsis.projects.amaze.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class TextReader {

    private static TextReader instance;

    private TextReader() {
    }

    public static TextReader getInstance() {
        return Optional.ofNullable(instance).orElseGet(() -> {
            instance = new TextReader();
            return instance;
        });
    }

    public List<String> read(String path) throws IOException {
        File file = new File(path);
        return FileUtils.readLines(file, StandardCharsets.UTF_8);
    }
}
