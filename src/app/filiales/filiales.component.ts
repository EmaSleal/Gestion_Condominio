import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Filial } from '../filial';
import { FilialService } from '../filial.service';
import Swal from 'sweetalert2';
import { Duenio } from '../duenio';
import { DuenioService } from '../duenio.service';

@Component({
  selector: 'app-filiales',
  templateUrl: './filiales.component.html',
  styleUrls: ['./filiales.component.css']
})
export class FilialesComponent implements OnInit {
  filiales: Filial[];

  duenios: Duenio[];

  Nfilial: Filial = new Filial();

  constructor(
    private duenioS: DuenioService,
    private filialS: FilialService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerFiliales();
    this.obtenerDuenios();
  }
  private obtenerFiliales() {
    this.filialS.obtenerListaDeFiliales().subscribe((dato) => {
      this.filiales = dato;
    });
  }

  private obtenerDuenios() {
    this.duenioS.obtenerListaDeDuenios().subscribe((dato) => {
      this.duenios = dato;
    });
  }

  guardarFilial() {
    this.filialS.registrarFilial(this.Nfilial).subscribe(
      (dato) => {
        console.log(dato);
        this.enviarALista();
      },
      (error) => console.log(error)
    );
  }

  enviarALista() {
    this.router.navigate(['']);
  }

  onSubmit() {
    this.guardarFilial();
    console.log(this.Nfilial);
  }

  eliminarfilial(idfilial: number) {
    Swal.fire({
      title: 'Estas seguro?',
      text: 'Se eliminara la filial definitivamente!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminalo!',
      cancelButtonText: 'No lo hagas!',
      reverseButtons: true,
    }).then((result) => {
      if (result.value) {
        this.filialS.eliminarFilial(idfilial).subscribe((dato) => {
          console.log(dato);
          this.obtenerFiliales();
          Swal.fire(
            'Empleado eliminado',
            'El empleado ha sido eliminado con exito',
            'success'
          );
        });
      }
    });
  }

  actualizarfilial(idfilial: number) {
    this.filialS.obtenerFilialXId(idfilial).subscribe((dato) => {
      this.Nfilial = dato;
    });
  }
}
