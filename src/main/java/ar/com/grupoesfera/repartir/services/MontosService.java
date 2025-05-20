package ar.com.grupoesfera.repartir.services;

import ar.com.grupoesfera.repartir.model.Gasto;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.exceptions.GastoNegativoException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MontosService {

    public void inicializarTotal(Grupo grupo) {

        grupo.setTotal(BigDecimal.valueOf(0,2));
    }

    public void acumularAlTotal(Grupo grupo, Gasto gasto) {

        BigDecimal total = grupo.getTotal();

        if (gasto.getMonto().compareTo(BigDecimal.ZERO) < 0) {
            throw new GastoNegativoException();
        }

        total = total.add(gasto.getMonto());
        grupo.setTotal(total);
    }

}
