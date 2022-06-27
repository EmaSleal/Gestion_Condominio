package com.backend.condominio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.condominio.domain.Duenio;
import com.backend.condominio.repository.DuenioRepository;

@Service
public class DuenioServiceImpl implements DuenioService{
	
	@Autowired
	private DuenioRepository DR;

	@Override
	@Transactional
	public void guardar(Duenio duenio) {
		DR.SP_INSERTAR_DUENIOS(duenio.getIdDuenio(), duenio.getNombre(),duenio.getApellido1(), duenio.getApellido2() , duenio.getTelefono(), duenio.getCorreo());
		
	}

	@Override
	public List<Duenio> Listar() {
		
		return DR.Listar();
	}

	

	@Override
	@Transactional
	public void eliminar(Duenio duenio) {
		DR.SP_BORRAR_DUENIO(duenio.getIdDuenio());
		
	}

	@Override
	@Transactional
	public void editar(Duenio duenio) {
		DR.SP_ACTUALIZAR_DUENIO(duenio.getIdDuenio(), duenio.getNombre(),duenio.getApellido1(), duenio.getApellido2() , duenio.getTelefono(), duenio.getCorreo());
		
	}

	@Override
	public Duenio buscarUno(Long id) {
		
		return DR.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<String> listarDuoenioCuota(Long id) {
		
		return DR.SP_MOSTRAR_DATOS_PAGOS(id);
	}

	

}
