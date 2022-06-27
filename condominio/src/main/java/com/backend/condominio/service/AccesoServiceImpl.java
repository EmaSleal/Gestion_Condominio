package com.backend.condominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.condominio.domain.Acceso;
import com.backend.condominio.repository.AccesoRepository;


@Service
public class AccesoServiceImpl implements AccesoService {
	
	@Autowired
	private AccesoRepository AR;

	@Override
	public void guardar(Acceso acceso) {
		AR.SP_INSERTAR_ACCESOS(acceso.getIdAcceso(), acceso.getFecha(), acceso.getNumFilial(), acceso.getEntrada());
		
	}

	@Override
	public List<Acceso> Listar() {
		
		return AR.Listar();
	}

	@Override
	public void eliminar(Acceso acceso) {
		AR.SP_BORRAR_ACCESOS(acceso.getIdAcceso());
		
	}

	@Override
	public void editar(Acceso acceso) {
		AR.SP_ACTUALIZAR_ACCESOS(acceso.getIdAcceso(), acceso.getSalida());
		
	}

	@Override
	public Acceso buscarUno(Long id) {
		
		return AR.findById(id).orElse(null);
	}

}
