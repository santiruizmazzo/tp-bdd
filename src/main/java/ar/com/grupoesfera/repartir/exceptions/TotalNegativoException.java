package ar.com.grupoesfera.repartir.exceptions;

public class TotalNegativoException extends RuntimeException {
    public TotalNegativoException() {
        super("No se permite que un grupo tenga monto negativo");
    }
}
