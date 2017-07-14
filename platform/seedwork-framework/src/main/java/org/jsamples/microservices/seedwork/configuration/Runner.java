package org.jsamples.microservices.seedwork.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static java.util.Arrays.stream;

/**
 * ...
 *
 * @author Erick Vega De la Cruz
 * @since 1.0
 */
public class Runner {
    private static final String[] CONFIG_FILES = new String[]{"%s/app-config.yml", "%s/app-logback.xml"};
    private static final String CONFIG_DIRECTORY = System.getProperty("org.jsamples.microservices.conf");
    private Class<?> clazz;

    public Runner(Class<?> clazz) {
        this.clazz = clazz;
    }

    static public ApplicationContext run(Class<?> clazz, String[] args) {
        return new Runner(clazz).run();
    }

    private ApplicationContext run() {
        if (!this.existConfiguration()) {
            this.performCopies();
            throw new RuntimeException("Configuration not found !!!");
        }
        SpringApplication application = new SpringApplication(clazz);
        //application.setBanner(new Banner());
        return application.run(this.args());
    }

    private String[] args() {
        return new String[] {
                "--spring.config.location="+String.format(CONFIG_FILES[0], CONFIG_DIRECTORY),
                "--logging.config="+String.format(CONFIG_FILES[1], CONFIG_DIRECTORY)};
    }

    private boolean existConfiguration() {
        return stream(CONFIG_FILES)
                .map(format -> Paths.get(String.format(format, CONFIG_DIRECTORY)))
                .allMatch(Files::exists);
    }

    private void performCopies() {
        File dir = new File(CONFIG_DIRECTORY);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new RuntimeException("Config directory is inaccesible !!!");
        }
        stream(CONFIG_FILES).forEach(this::copy);
    }

    private void copy(String format) {
        StringBuilder pkg = new StringBuilder("/")
                .append(clazz.getPackage().getName().replace(".", "/"))
                .append("/configuration/templates");
        try {
            Files.copy(clazz.getResourceAsStream(String.format(format, pkg)), Paths.get(String.format(format, CONFIG_DIRECTORY)), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException("Error when trying to copy templates of config files", ex);
        }
    }
}
