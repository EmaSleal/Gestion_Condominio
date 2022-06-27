package com.backend.condominio.service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.backend.condominio.domain.Filial;
import com.backend.condominio.repository.FilialRepository;

@Service
public class FilialServiceImpl implements FilialService{

	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	private FilialRepository filialR;
	
	@Override
	public void guardar(Filial filial) {
        
        filialR.SP_INSERTAR_FILIALES(filial.getId(),filial.getIdDuenio(), filial.getDescripcion());
	}

	@Override
	public List<Filial> Listar() {
		
		return filialR.Listar();
	}

	@Override
	public void editar(Filial filial) {
		filialR.SP_ACTUALIZAR_FILIALES(filial.getId(), filial.getIdDuenio(),filial.getDescripcion());
		
	}

	@Override
	public void eliminar(Filial filial) {
		filialR.SP_BORRAR_FILIALES(filial.getId());
		
	}

	@Override
	public Filial buscarUno(Long id) {
		
		return filialR.findById(id).orElse(null);
	}

	
}
