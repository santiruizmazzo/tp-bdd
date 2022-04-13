import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { BienvenidaComponent } from '../bienvenida/bienvenida.component';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../model/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
  providers: [UsuarioService]
})
export class UsuarioComponent implements OnInit, AfterViewInit {

  usuario?: Usuario;

  @ViewChild(BienvenidaComponent) bienvenida!: BienvenidaComponent;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {

    this.bienvenida.iniciarEvent.subscribe(idUsuario => this.cargar(idUsuario));
  }

  cargar(idUsuario: string):  void {

    this.usuarioService.obtener(idUsuario).subscribe(
      usuario => this.usuario = usuario,
      error => {}
    )
  }

}
