package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NombreQueLosIdentificaSteps extends CucumberSteps {

    private String nombreIndicado;
    private String mensaje;

    @Cuando("el usuario crea un grupo indicando el nombre {string}")
    public void elUsuarioCreaUnGrupoIndicandoElNombre(String nombre) {

        nombreIndicado = nombre;

        var crearGruposButton = driver.findElement(By.id("crearGruposButton"));
        crearGruposButton.click();

        driver.findElement(By.id("nombreGrupoNuevoInput")).sendKeys(nombreIndicado);

        var miembrosInput = driver.findElement(By.id("miembrosGrupoNuevoInput"));
        miembrosInput.sendKeys("Victor");
        miembrosInput.sendKeys(Keys.ENTER);
        miembrosInput.sendKeys("Brenda");
        miembrosInput.sendKeys(Keys.ENTER);

        driver.findElement(By.id("guardarGrupoNuevoButton")).click();

        var wait = new WebDriverWait(driver, 2);
        wait.until(visibilityOfElementLocated(By.id("mensajesToast")));
    }

    @Entonces("debería visualizar dentro del listado el grupo con el nombre indicado")
    public void deberiaVisualizarDentroDelListadoElGrupoConElNombreIndicado() {

        var grupoTR = driver.findElements(By.cssSelector("app-grupos table tr"));
        assertThat(grupoTR).hasSizeGreaterThan(1);

        var campoTDs = grupoTR.get(1).findElements(By.tagName("td"));
        assertThat(campoTDs.get(0).getText()).isNotEmpty();
        assertThat(campoTDs.get(1).getText()).isEqualTo(nombreIndicado);
    }

    @Cuando("el usuario intenta crear un grupo sin indicar su nombre")
    public void elUsuarioIntentaCrearUnGrupoSinIndicarSuNombre() {

        var crearGruposButton = driver.findElement(By.id("crearGruposButton"));
        crearGruposButton.click();

        var miembrosInput = driver.findElement(By.id("miembrosGrupoNuevoInput"));
        miembrosInput.sendKeys("Carla");
        miembrosInput.sendKeys(Keys.ENTER);
        miembrosInput.sendKeys("Miguel");
        miembrosInput.sendKeys(Keys.ENTER);

        driver.findElement(By.id("guardarGrupoNuevoButton")).click();

        var wait = new WebDriverWait(driver, 2);
        mensaje = wait.until(visibilityOfElementLocated(By.id("mensajesToast"))).getText();
    }

    @Entonces("no debería crear el grupo sin nombre")
    public void noDeberiaCrearElGrupoSinNombre() {

        // TODO
    }

    @Y("debería ser informado que no puede crear un grupo sin nombre")
    public void deberiaSerInformadoQueNoPuedeCrearUnGrupoSinNombre() {

        assertThat(mensaje).contains("Error", "No se puede guardar");
    }

}
