package pavel.runners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by kalpak44 on 21.01.17.
 */
@Component
public class ConsoleApplicationRunner implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(ConsoleApplicationRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Hello");
    }
}
