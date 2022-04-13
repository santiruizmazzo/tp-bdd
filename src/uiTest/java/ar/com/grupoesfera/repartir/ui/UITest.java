package ar.com.grupoesfera.repartir.ui;

import ar.com.grupoesfera.repartir.services.GruposService;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("uiTest")
public abstract class UITest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    WebDriver driver;

    @MockBean
    GruposService gruposService;

    String url(String path) {

        return "http://localhost:" + randomServerPort + path;
    }

    @AfterEach
    public void quitDriver() {

        driver.quit();
    }

    public abstract static class PageObject {

        private UITest test;

        public PageObject(UITest test) {
            this.test = test;
        }

        protected WebDriver driver() {

            return this.test.driver;
        }

        protected String url(String path) {

            return this.test.url(path);
        }
    }
}
