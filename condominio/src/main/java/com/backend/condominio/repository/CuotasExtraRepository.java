package com.backend.condominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.backend.condominio.domain.CuotasExtra;

public interface CuotasExtraRepository extends JpaRepository<CuotasExtra, Long>{

	@Procedure(name="guardarCuotasExtra")
	void SP_INSERTAR_CUOTAS_EXTRAS(long CUOTAIDN, String FECHAN, Integer MONTON, int DUENIOIDN, String DESCRIPCIONN);
	
	@Procedure(name="editarCuotasExtra")
	void SP_ACTUALIZAR_CUOTAS_EXTRAS(long CUOTAIDCUR, String FECHAN, Integer MONTON, String DESCRIPCIONN);
	
	@Procedure(name="eliminarCuotasExtra")
	void SP_BORRAR_CUOTAS_EXTRAS(long CUOTAIDCUR);
	
	@Query(value ="SELECT * FROM CUOTAS_EXTRAS", nativeQuery = true)
	List<CuotasExtra> Listar();
	
}
