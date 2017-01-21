package pavel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pavel.runners.ConsoleApplicationRunner;

/**
 * Created by kalpak44 on 21.01.17.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplicationRunner.class, args);
    }
}
