import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) {

  }

  obtener(id: string): Observable<Usuario> {

    return this.http.get<Usuario>(`/api/usuarios/${id}`);
  }
}
