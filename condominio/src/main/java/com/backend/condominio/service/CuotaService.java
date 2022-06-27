package com.backend.condominio.service;

import java.util.List;

import com.backend.condominio.domain.Cuota;

public interface CuotaService {

	public void guardar(Cuota cuotas);

	public List<Cuota> Listar();

	public void eliminar(Cuota cuotas);
	
	public void editar(Cuota cuotas);
	
	public Cuota buscarUno(Long id);
}
