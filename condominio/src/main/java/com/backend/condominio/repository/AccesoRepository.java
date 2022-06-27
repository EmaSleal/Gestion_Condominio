package com.backend.condominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.backend.condominio.domain.Acceso;

public interface AccesoRepository extends JpaRepository<Acceso, Long>{
	
	@Procedure(name="guardarAcceso")
	void SP_INSERTAR_ACCESOS(long IDACCESON, String FECHAN, Integer FILIALN, String HENTRADAN);
	
	@Procedure(name="editarAcceso")
	void SP_ACTUALIZAR_ACCESOS(long IDACCESOCUR, String HSALIDAN);
	
	@Procedure(name="eliminarAcceso")
	void SP_BORRAR_ACCESOS(long IDACCESOCUR);
	
	@Query(value ="SELECT * FROM ACCESOS", nativeQuery = true)
	List<Acceso> Listar();
}
