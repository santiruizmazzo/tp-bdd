package ar.com.grupoesfera.repartir.uitest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("uiTest")
public class WebDriverSupport {

    @PostConstruct
    public void downloadWebDriver() {

        WebDriverManager.chromedriver()
                .setup();
    }

    @Bean
    public WebDriver buildWebDriver() {

        var chromeDriver = new ChromeDriver();

        return chromeDriver;
    }
}
