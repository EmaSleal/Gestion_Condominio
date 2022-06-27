package com.backend.condominio.service;

import java.util.List;

import com.backend.condominio.domain.Filial;

public interface FilialService {
	public void guardar(Filial filial);
	
	public List<Filial> Listar();
	
	public void editar(Filial filial);
	
	public void eliminar(Filial filial);
	
	public Filial buscarUno(Long id);
}
