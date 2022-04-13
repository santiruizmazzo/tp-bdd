import { Pipe, PipeTransform } from '@angular/core';
import { Usuario } from '../model/usuario';

@Pipe({
  name: 'resumirUsuario'
})
export class ResumirUsuarioPipe implements PipeTransform {

  transform(usuario: Usuario | null): string {

    return usuario != null ?  `${usuario.id} (${usuario.correo})`: '';
  }

}
