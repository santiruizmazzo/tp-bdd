package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalNoDebeSerNegativoSteps extends FastCucumberSteps {

    private Grupo grupo;
    private TotalNegativoException excepcion;

    @Dado("que existe un grupo con total igual a {int}")
    public void queExisteUnGrupoConTotalIgualA(int monto) {
        grupo = new Grupo();
        grupo.setTotal(BigDecimal.valueOf(monto));
    }

    @Cuando("el usuario intenta agregarle un gasto con monto {int}")
    public void elUsuarioIntentaAgregarleUnGastoConMonto(int monto) {
        try {
            grupo.setTotal(BigDecimal.valueOf(monto));
        } catch (TotalNegativoException e) {
            excepcion = e;
        }
    }

    @Entonces("el total del grupo debe seguir siendo {int}")
    public void elTotalDelGrupoDebeSeguirSiendo(int total) {
        assertThat( this.grupo.getTotal() == total);
        assertThat( excepcion == new TotalNegativoException(-5));
    }
}
