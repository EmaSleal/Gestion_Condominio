package com.backend.condominio.service;

import java.util.List;

import com.backend.condominio.domain.Acceso;

public interface AccesoService {

	
	public void guardar(Acceso acceso);

	public List<Acceso> Listar();

	public void eliminar(Acceso acceso);
	
	public void editar(Acceso acceso);
	
	public Acceso buscarUno(Long id);
	 
	
}
