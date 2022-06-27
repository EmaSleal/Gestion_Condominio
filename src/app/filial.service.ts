import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filial } from './filial';

@Injectable({
  providedIn: 'root',
})
export class FilialService {
  private baseUrl = 'http://localhost:8080/Condominio/filiales';
  private guardaUrl = 'http://localhost:8080/Condominio/filiales/guardar';

  constructor(private httpClient: HttpClient) {}

  obtenerListaDeFiliales(): Observable<Filial[]> {
    return this.httpClient.get<Filial[]>(`${this.baseUrl}`);
  }

  registrarFilial(filial: Filial): Observable<Object> {
    return this.httpClient.post(`${this.guardaUrl}`, filial);
  }

  obtenerFilialXId(id: number): Observable<Filial> {
    return this.httpClient.get<Filial>(`${this.baseUrl}/${id}`);
  }

  eliminarFilial(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
