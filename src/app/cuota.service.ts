import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cuota } from './cuota';

@Injectable({
  providedIn: 'root',
})
export class CuotaService {
  private baseUrl = 'http://localhost:8080/Condominio/cuota';
  private guardaUrl = 'http://localhost:8080/Condominio/cuota/guardar';

  constructor(private httpClient: HttpClient) {}

  obtenerListaDeCuotas(): Observable<Cuota[]> {
    return this.httpClient.get<Cuota[]>(`${this.baseUrl}`);
  }

  registrarCuota(cuota: Cuota): Observable<Object> {
    return this.httpClient.post(`${this.guardaUrl}`, cuota);
  }

  obtenerCuotaXId(id: number): Observable<Cuota> {
    return this.httpClient.get<Cuota>(`${this.baseUrl}/${id}`);
  }

  eliminarCuota(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
