import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; // CLI imports router
import { AccesosComponent } from './accesos/accesos.component';
import { CuotasExtraComponent } from './cuotas-extra/cuotas-extra.component';
import { CuotasComponent } from './cuotas/cuotas.component';
import { DueniosComponent } from './duenios/duenios.component';
import { FilialesComponent } from './filiales/filiales.component';

const routes: Routes = [
  { path: 'filiales', component: FilialesComponent },
  { path: 'duenios', component: DueniosComponent },
  { path: 'accesos', component: AccesosComponent },
  { path: 'cuotasExtra', component: CuotasExtraComponent },
  { path: 'cuotas', component: CuotasComponent },
  { path: '', redirectTo: '/', pathMatch: 'full' },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
