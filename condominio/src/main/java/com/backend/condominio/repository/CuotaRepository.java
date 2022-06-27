package com.backend.condominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.backend.condominio.domain.Cuota;

public interface CuotaRepository  extends JpaRepository<Cuota, Long>{
	
	@Procedure(name="guardarCuotas")
	void SP_INSERTAR_CUOTAS_EXTRAS(long IDCUOTAN, String FECHAN, Integer MONTON, int IDDUENION, String DESCRIPCIONN);
	
	@Procedure(name="editarCuotas")
	void SP_ACTUALIZAR_CUOTAS_EXTRAS(long IDCUOTACUR, String FECHAN, Integer MONTON, String DESCRIPCIONN);
	
	@Procedure(name="eliminarCuotas")
	void SP_BORRAR_CUOTAS_EXTRAS(long IDCUOTACUR);
	
	@Query(value ="SELECT * FROM CUOTAS", nativeQuery = true)
	List<Cuota> Listar();
}
