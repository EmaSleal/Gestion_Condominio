package com.backend.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.condominio.domain.CuotasExtra;
import com.backend.condominio.repository.CuotasExtraRepository;


@Service
public class CuotasExtraServiceImpl implements CuotasExtraService{
	
	@Autowired
	private CuotasExtraRepository CER;

	@Override
	public void guardar(CuotasExtra cuotasExtra) {
		CER.SP_INSERTAR_CUOTAS_EXTRAS(cuotasExtra.getId(), cuotasExtra.getFecha(), cuotasExtra.getMonto(), cuotasExtra.getNumDuenio(), cuotasExtra.getDescripcion());
		
	}

	@Override
	public List<CuotasExtra> Listar() {
		
		return CER.Listar();
	}

	@Override
	public void eliminar(CuotasExtra cuotasExtra) {
		CER.SP_BORRAR_CUOTAS_EXTRAS(cuotasExtra.getId());
		
	}

	@Override
	public void editar(CuotasExtra cuotasExtra) {
		CER.SP_ACTUALIZAR_CUOTAS_EXTRAS(cuotasExtra.getId(), cuotasExtra.getFecha(), cuotasExtra.getMonto(), cuotasExtra.getDescripcion());
		
	}

	@Override
	public CuotasExtra buscarUno(Long id) {
		
		return CER.findById(id).orElse(null);
	}

}
