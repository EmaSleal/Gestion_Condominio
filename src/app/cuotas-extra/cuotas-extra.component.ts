import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CuotasExtra } from '../cuotas-extra';
import { CuotasExtraService } from '../cuotas-extra.service';
import { Duenio } from '../duenio';
import { DuenioService } from '../duenio.service';

@Component({
  selector: 'app-cuotas-extra',
  templateUrl: './cuotas-extra.component.html',
  styleUrls: ['./cuotas-extra.component.css'],
})
export class CuotasExtraComponent implements OnInit {
  cuotasExtras: CuotasExtra[];

  duenios: Duenio[];

  NcuotasExtra: CuotasExtra = new CuotasExtra();

  constructor(
    private duenioS: DuenioService,
    private cuotasExtraS: CuotasExtraService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerCuotasExtras();
    this.obtenerDuenios();
  }
  private obtenerCuotasExtras() {
    this.cuotasExtraS.obtenerListaDeCuotasExtras().subscribe((dato) => {
      this.cuotasExtras = dato;
    });
  }

  private obtenerDuenios() {
    this.duenioS.obtenerListaDeDuenios().subscribe((dato) => {
      this.duenios = dato;
    });
  }

  guardarCuotasExtras() {
    this.cuotasExtraS.registrarCuotasExtra(this.NcuotasExtra).subscribe(
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
    this.guardarCuotasExtras();
    console.log(this.NcuotasExtra);
  }

  eliminarCuotasExtras(idCuotasExtraS: number) {
    Swal.fire({
      title: 'Estas seguro?',
      text: 'Se eliminara la cuota extra definitivamente!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminalo!',
      cancelButtonText: 'No lo hagas!',
      reverseButtons: true,
    }).then((result) => {
      if (result.value) {
        this.cuotasExtraS
          .eliminarCuotasExtra(idCuotasExtraS)
          .subscribe((dato) => {
            console.log(dato);
            this.obtenerCuotasExtras();
            Swal.fire(
              'Empleado eliminado',
              'El empleado ha sido eliminado con exito',
              'success'
            );
          });
      }
    });
  }

  actualizarCuotaExtra(idCuotasExtraS: number) {
    this.cuotasExtraS
      .obtenerCuotasExtraXId(idCuotasExtraS)
      .subscribe((dato) => {
        this.NcuotasExtra = dato;
      });
  }
}
