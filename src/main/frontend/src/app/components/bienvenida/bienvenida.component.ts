import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-bienvenida',
  templateUrl: './bienvenida.component.html',
  styleUrls: ['./bienvenida.component.css']
})
export class BienvenidaComponent implements OnInit {

  mostrar: boolean = true;

  nombre: string = "";

  @Output() readonly iniciarEvent = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  iniciar(): void {

    this.iniciarEvent.emit(this.nombre);
    this.mostrar = false;
  }
}
