import { Pipe, PipeTransform } from '@angular/core';
import { Grupo } from '../model/grupo';

@Pipe({
  name: 'identificarGrupo'
})
export class IdentificarGrupoPipe implements PipeTransform {

  transform(grupo: Grupo | null): string {

    return grupo != null ?  `#${grupo.id}  ${grupo.nombre}`: '';
  }

}
