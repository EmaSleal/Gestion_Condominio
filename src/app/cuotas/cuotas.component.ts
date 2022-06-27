import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Cuota } from '../cuota';
import { CuotaService } from '../cuota.service';
import { Duenio } from '../duenio';
import { DuenioService } from '../duenio.service';

@Component({
  selector: 'app-cuotas',
  templateUrl: './cuotas.component.html',
  styleUrls: ['./cuotas.component.css'],
})
export class CuotasComponent implements OnInit {
  Cuotas: Cuota[];

  duenios: Duenio[];

  NCuota: Cuota = new Cuota();

  constructor(
    private duenioS: DuenioService,
    private CuotaS: CuotaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerCuotas();
    this.obtenerDuenios();
  }
  private obtenerCuotas() {
    this.CuotaS.obtenerListaDeCuotas().subscribe((dato) => {
      this.Cuotas = dato;
    });
  }

  private obtenerDuenios() {
    this.duenioS.obtenerListaDeDuenios().subscribe((dato) => {
      this.duenios = dato;
    });
  }

  guardarCuotas() {
    this.CuotaS.registrarCuota(this.NCuota).subscribe(
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
    this.guardarCuotas();
    console.log(this.NCuota);
  }

  eliminarCuotas(idCuotaS: number) {
    Swal.fire({
      title: 'Estas seguro?',
      text: 'Se eliminara la cuota definitivamente!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminalo!',
      cancelButtonText: 'No lo hagas!',
      reverseButtons: true,
    }).then((result) => {
      if (result.value) {
        this.CuotaS
          .eliminarCuota(idCuotaS)
          .subscribe((dato) => {
            console.log(dato);
            this.obtenerCuotas();
            Swal.fire(
              'Empleado eliminado',
              'La cuota ha sido eliminado con exito',
              'success'
            );
          });
      }
    });
  }

  actualizarCuotaExtra(idCuotaS: number) {
    this.CuotaS
      .obtenerCuotaXId(idCuotaS)
      .subscribe((dato) => {
        this.NCuota = dato;
      });
  }
}
