import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Duenio } from './duenio';

@Injectable({
  providedIn: 'root',
})
export class DuenioService {
  private baseUrl = 'http://localhost:8080/Condominio/duenios';
  private guardaUrl = 'http://localhost:8080/Condominio/duenios/guardar';


  constructor(private httpClient: HttpClient) {}

  obtenerListaDeDuenios(): Observable<Duenio[]> {
    return this.httpClient.get<Duenio[]>(`${this.baseUrl}`);
  }

  registrarDuenio(duenio: Duenio): Observable<Object> {
    return this.httpClient.post(`${this.guardaUrl}`, duenio);
  }

  obtenerDuenioXId(id: number): Observable<Duenio> {
    return this.httpClient.get<Duenio>(`${this.baseUrl}/${id}`);
  }

  eliminarDuenio(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
