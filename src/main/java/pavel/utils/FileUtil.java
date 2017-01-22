package pavel.utils;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kalpak44 on 21.01.17.
 */
@Service
public class FileUtil {

    FileUtil(){

    }

    public static String readFile(String filePath) throws IOException {
            return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void writeFile(final String filePath, final String toFile) throws IOException {
        Files.write(Paths.get(filePath), toFile.getBytes());
    }
}
