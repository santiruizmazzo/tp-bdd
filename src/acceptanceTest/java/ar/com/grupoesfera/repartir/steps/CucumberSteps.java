package ar.com.grupoesfera.repartir.steps;

import ar.com.grupoesfera.repartir.atest.BaseDeDatosFixture;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("acceptanceTest")
public abstract class CucumberSteps {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected BaseDeDatosFixture baseDeDatos;

    protected String url(String path) {

        return "http://localhost:" + randomServerPort + path;
    }

}
