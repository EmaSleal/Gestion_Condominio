package com.backend.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.condominio.domain.Cuota;
import com.backend.condominio.repository.CuotaRepository;

@Service
public class CuotaServiceImpl  implements CuotaService{
	
	@Autowired
	private CuotaRepository CR;

	@Override
	public void guardar(Cuota cuota) {
		CR.SP_INSERTAR_CUOTAS_EXTRAS(cuota.getId(), cuota.getFecha(), cuota.getMonto(), cuota.getNumDuenio(), cuota.getDescripcion());
		
	}

	@Override
	public List<Cuota> Listar() {
		return CR.Listar();
	}

	@Override
	public void eliminar(Cuota cuota) {
		CR.SP_BORRAR_CUOTAS_EXTRAS(cuota.getId());
		
	}

	@Override
	public void editar(Cuota cuota) {
		CR.SP_ACTUALIZAR_CUOTAS_EXTRAS(cuota.getId(), cuota.getFecha(), cuota.getMonto(), cuota.getDescripcion());
		
	}

	@Override
	public Cuota buscarUno(Long id) {

		return CR.findById(id).orElse(null);
	}

}
