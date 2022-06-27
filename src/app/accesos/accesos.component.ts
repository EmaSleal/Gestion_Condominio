import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Acceso } from '../acceso';
import { AccesoService } from '../acceso.service';
import { Filial } from '../filial';
import { FilialService } from '../filial.service';

@Component({
  selector: 'app-accesos',
  templateUrl: './accesos.component.html',
  styleUrls: ['./accesos.component.css']
})
export class AccesosComponent implements OnInit {

  filiales: Filial[];

  accesos: Acceso[];

  Nacceso: Acceso = new Acceso();

  constructor(
    private accesoS: AccesoService,
    private filialS: FilialService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerFiliales();
    this.obtenerAccesos();
  }
  private obtenerFiliales() {
    this.filialS.obtenerListaDeFiliales().subscribe((dato) => {
      this.filiales = dato;
    });
  }

  private obtenerAccesos() {
    this.accesoS.obtenerListaDeAccesos().subscribe((dato) => {
      this.accesos = dato;
    });
  }

  guardarAcceso() {
    this.accesoS.registrarAcceso(this.Nacceso).subscribe(
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
    this.guardarAcceso();
    console.log(this.Nacceso);
  }

  eliminarAcceso(idacceso: number) {
    Swal.fire({
      title: 'Estas seguro?',
      text: 'Se eliminara el acceso definitivamente!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminalo!',
      cancelButtonText: 'No lo hagas!',
      reverseButtons: true,
    }).then((result) => {
      if (result.value) {
        this.accesoS.eliminarAcceso(idacceso).subscribe((dato) => {
          console.log(dato);
          this.obtenerAccesos();
          Swal.fire(
            'Empleado eliminado',
            'El empleado ha sido eliminado con exito',
            'success'
          );
        });
      }
    });
  }

  actualizarAcceso(idacceso: number) {
    this.accesoS.obtenerAccesoXId(idacceso).subscribe((dato) => {
      this.Nacceso = dato;
    });
  }

}
