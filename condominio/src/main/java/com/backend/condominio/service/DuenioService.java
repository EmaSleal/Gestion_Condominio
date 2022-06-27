package com.backend.condominio.service;

import java.util.List;

import com.backend.condominio.domain.Duenio;

public interface DuenioService {

	public void guardar(Duenio duenio);

	public List<Duenio> Listar();

	public void eliminar(Duenio duenio);
	
	public void editar(Duenio duenio);
	
	public Duenio buscarUno(Long id);
	
	public List<String> listarDuoenioCuota(Long id);
}
