package pl.java.borowiec.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class FileUtil {

    private FileUtil() {

    }

    public static void readFile(String file) throws IOException {
        Path path = Paths.get(file); //try-with-resources
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> log.info("++  {}", s));
        }
    }

    public static void readFile2(String file) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(file)));
        log.info(" --   {}", content);
    }
}
