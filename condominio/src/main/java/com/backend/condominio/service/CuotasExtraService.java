package com.backend.condominio.service;

import java.util.List;

import com.backend.condominio.domain.Acceso;
import com.backend.condominio.domain.CuotasExtra;

public interface CuotasExtraService {
	
	public void guardar(CuotasExtra cuotasExtra);

	public List<CuotasExtra> Listar();

	public void eliminar(CuotasExtra cuotasExtra);
	
	public void editar(CuotasExtra cuotasExtra);
	
	public CuotasExtra buscarUno(Long id);
}
