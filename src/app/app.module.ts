import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { DueniosComponent } from './duenios/duenios.component';
import { AccesosComponent } from './accesos/accesos.component';
import { CuotasExtraComponent } from './cuotas-extra/cuotas-extra.component';
import { CuotasComponent } from './cuotas/cuotas.component';
import { FilialesComponent } from './filiales/filiales.component';


@NgModule({
  declarations: [
    AppComponent,
    DueniosComponent,
    FilialesComponent,
    AccesosComponent,
    CuotasExtraComponent,
    CuotasComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
