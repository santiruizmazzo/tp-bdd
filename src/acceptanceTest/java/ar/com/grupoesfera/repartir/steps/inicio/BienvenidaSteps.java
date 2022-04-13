package ar.com.grupoesfera.repartir.steps.inicio;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Dado;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.*;

public class BienvenidaSteps extends CucumberSteps {

    @Then("el usuario accede a la aplicación")
    public void elUsuarioAccedeALaAplicacion() {

        driver.navigate().to(url("/"));
    }

    @Then("se muestra el mensaje de bienvenida")
    public void seMuestraElMensajeDeBienvenida() {

        var bienvenidaDialog = driver.findElement(By.tagName("p-dialog"));

        var contenido = bienvenidaDialog.getText();
        assertThat(contenido).contains("Repartir");
    }

    @Given("que el usuario accedió a la aplicación")
    public void queElUsuarioAccedioALaAplicacion() {

        driver.navigate().to(url("/"));
    }

    @When("decidió iniciar")
    public void decidioIniciar() {

        var iniciarButton = driver.findElement(By.id("iniciarBienvenidaButton"));
        iniciarButton.click();

        var crearGruposButton = driver.findElement(By.cssSelector("#crearGruposButton button"));
        crearGruposButton.click();
    }

    @Then("puede empezar a usarla")
    public void puedeEmpezarAUsarla() {

        var nuegoGrupoDialog = driver.findElement(By.cssSelector("app-grupo-nuevo"));

        assertThat(nuegoGrupoDialog.isDisplayed())
                .as("Dialogo de Nuevo Grupo visible")
                .isTrue();
        assertThat(nuegoGrupoDialog.getText())
                .as("Dialogo de Nuebo Grupo con titulo")
                .contains("Nuevo Grupo");
    }

    @Dado("que el usuario inició Repartir")
    public void elUsuarioInicioRepartir() {

        baseDeDatos.estaVacia();
        driver.navigate().to(url("/"));
        var iniciarButton = driver.findElement(By.id("iniciarBienvenidaButton"));
        iniciarButton.click();
    }

    @Before
    public void prepararBaseDeDatos() {

        baseDeDatos.estaVacia();
    }

}
