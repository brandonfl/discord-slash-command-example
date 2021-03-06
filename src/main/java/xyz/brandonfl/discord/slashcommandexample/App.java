package xyz.brandonfl.discord.slashcommandexample;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class App extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Value("${bot.setting.version}")
    String version;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @PostConstruct
    protected void appStarted() {
        logger.info("Bot v{} started", version);
    }

}