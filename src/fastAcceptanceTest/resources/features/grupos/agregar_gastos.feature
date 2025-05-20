# language: es
Característica: Agregar gastos a un grupo

  Regla: El total de un grupo no debe ser negativo

    Escenario: No puedo agregar un gasto que haga que el total sea negativo
      Dado que existe un grupo con total igual a 0
      Cuando el usuario intenta agregarle un gasto con monto -5
      Entonces el sistema debe rechazar el gasto
      Y el total del grupo debe seguir siendo 0

    Escenario: Un gasto negativo no está permitido
      Dado que existe un grupo con total igual a 200
      Cuando el usuario intenta agregarle un gasto con monto -50
      Entonces el sistema debe rechazar el gasto
      Y el total del grupo debe seguir siendo 200