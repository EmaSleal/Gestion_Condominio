import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CuotasExtra } from './cuotas-extra';

@Injectable({
  providedIn: 'root',
})
export class CuotasExtraService {
  private baseUrl = 'http://localhost:8080/Condominio/cuotaExtra';
  private guardaUrl = 'http://localhost:8080/Condominio/cuotaExtra/guardar';

  constructor(private httpClient: HttpClient) {}

  obtenerListaDeCuotasExtras(): Observable<CuotasExtra[]> {
    return this.httpClient.get<CuotasExtra[]>(`${this.baseUrl}`);
  }

  registrarCuotasExtra(cuotasExtra: CuotasExtra): Observable<Object> {
    return this.httpClient.post(`${this.guardaUrl}`, cuotasExtra);
  }

  obtenerCuotasExtraXId(id: number): Observable<CuotasExtra> {
    return this.httpClient.get<CuotasExtra>(`${this.baseUrl}/${id}`);
  }

  eliminarCuotasExtra(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
