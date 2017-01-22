package pavel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pavel.services.FileUtilService;
import pavel.services.WordCalculationService;

import java.util.Map;

/**
 * Created by kalpak44 on 21.01.17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private WordCalculationService wordCalculationService;

    @Autowired
    private FileUtilService fileUtilService;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... strings) throws Exception {
        final Map<String, Integer> wordsCount = wordCalculationService.calculateWordsCount(fileUtilService.readFile());
        fileUtilService.writeToFile(mapToString(wordsCount));
    }

    private String mapToString(final Map<String, Integer> map) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("word: count").append(System.lineSeparator());
        map.forEach((k, v) -> stringBuilder.append(k + ":" + v).append(System.lineSeparator()));
        stringBuilder.append(System.lineSeparator()).append("total words: " + map.size());
        return stringBuilder.toString();
    }
}
