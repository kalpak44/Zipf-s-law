package pavel.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pavel.utils.FileUtil;

import java.io.IOException;

/**
 * Created by kalpak44 on 21.01.17.
 */
@Component
public class FileUtilService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Value("${input.file.path}")
    private String inputPath;

    @Value("${output.file.path}")
    private String outputPath;

    @Value("${words.case.sensitive}")
    private String caseSensitive;

    public String readFile() {
        logger.info("Reading from file: " + inputPath);
        try {
            return caseSensitive.toLowerCase().equals("true")
                    ? FileUtil.readFile(inputPath).toLowerCase() : FileUtil.readFile(inputPath);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    public void writeToFile(final String toFile) {
        logger.info("Writing to file: " + outputPath);
        try {
            FileUtil.writeFile(outputPath, toFile);
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

}
