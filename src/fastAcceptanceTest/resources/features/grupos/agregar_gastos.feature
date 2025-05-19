# language: es
Característica: Agregar gastos a un grupo

  Regla: El total de un grupo no debe ser negativo

    Escenario: No puedo agregar un gasto con monto negativo
      Dado que existe un grupo con total igual a 0
      Cuando el usuario intenta agregarle un gasto con monto -5
      Entonces el total del grupo debe seguir siendo 0
