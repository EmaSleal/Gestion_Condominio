import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Duenio } from '../duenio';
import { DuenioService } from '../duenio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-duenios',
  templateUrl: './duenios.component.html',
  styleUrls: ['./duenios.component.css'],
})
export class DueniosComponent implements OnInit {
  duenios: Duenio[];

  Nduenio: Duenio = new Duenio();

  constructor(private duenioS: DuenioService, private router: Router) {}

  ngOnInit(): void {
    this.obtenerduenios();
  }
  private obtenerduenios() {
    this.duenioS.obtenerListaDeDuenios().subscribe((dato) => {
      this.duenios = dato;
    });
  }

  guardarDuenio() {
    this.duenioS.registrarDuenio(this.Nduenio).subscribe(
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
    this.guardarDuenio();
    console.log(this.Nduenio);
  }

  eliminarDuenio(idDuenio: number) {
    Swal.fire({
      title: 'Estas seguro?',
      text: "Se eliminara el dueño definitivamente!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminalo!',
      cancelButtonText: 'No lo hagas!',
      reverseButtons: true,
    }).then((result) => {
      if (result.value) {
        this.duenioS.eliminarDuenio(idDuenio).subscribe((dato) => {
          console.log(dato);
          this.obtenerduenios();
          Swal.fire(
            'Empleado eliminado',
            'El empleado ha sido eliminado con exito',
            'success'
          );
        });
      }
    });
    }

  actualizarDuenio(idDuenio: number) {
    this.duenioS.obtenerDuenioXId(idDuenio).subscribe((dato) => {
      this.Nduenio = dato;
    });
  }
}

