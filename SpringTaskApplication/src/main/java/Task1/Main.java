package Task1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Main implements CommandLineRunner {

    private final ApplicationContext context;

    public Main(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {

        String[] names = context.getBeanNamesForAnnotation(Service.class);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
