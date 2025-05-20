package ar.com.grupoesfera.repartir.exceptions;

public class GastoNegativoException extends RuntimeException {

    public GastoNegativoException() {
        super("No se permite agregar un gasto con monto negativo");
    }
}
