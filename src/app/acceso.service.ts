import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Acceso } from './acceso';

@Injectable({
  providedIn: 'root'
})
export class AccesoService {

  private baseUrl = 'http://localhost:8080/Condominio/accesos';
  private guardaUrl = 'http://localhost:8080/Condominio/accesos/guardar';

  constructor(private httpClient: HttpClient) {}

  obtenerListaDeAccesos(): Observable<Acceso[]> {
    return this.httpClient.get<Acceso[]>(`${this.baseUrl}`);
  }

  registrarAcceso(acceso: Acceso): Observable<Object> {
    return this.httpClient.post(`${this.guardaUrl}`, acceso);
  }

  obtenerAccesoXId(id: number): Observable<Acceso> {
    return this.httpClient.get<Acceso>(`${this.baseUrl}/${id}`);
  }

  eliminarAcceso(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
