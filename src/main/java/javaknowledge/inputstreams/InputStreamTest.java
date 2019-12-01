package javaknowledge.inputstreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        var classLoader = ClassLoader.getSystemClassLoader();
        var inputStream = classLoader.getResourceAsStream("afile.txt");
        var tempFile = File.createTempFile("myFileCopy", "txt");
        try (var outputStream = new FileOutputStream(tempFile)) {
            inputStream.transferTo(outputStream);
        }
        System.out.println("Output");
    }

}

