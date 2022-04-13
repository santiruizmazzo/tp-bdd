package ar.com.grupoesfera.repartir.steps;

import io.cucumber.java.ParameterType;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class GherkinParameters {

    private final Pattern PATRON_MIEMBROS = Pattern.compile("'([^']+)'");

    @ParameterType(".*")
    public List<String> miembros(String valor) {

        List<String> miembros = new LinkedList<>();

        PATRON_MIEMBROS.matcher(valor)
                .results()
                .map(MatchResult::group)
                .map(miembro -> miembro.substring(1, miembro.length() - 1))
                .allMatch(miembros::add);

        return miembros;
    }

}
