package ar.com.grupoesfera.repartir.steps;

import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import org.apiguardian.api.API;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@StepDefinitionAnnotation
@Documented
public @interface Step {

    /**
     * A cucumber or regular expression.
     *
     * @return a cucumber or regular expression
     */
    String value();
}
