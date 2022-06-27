package com.backend.condominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.backend.condominio.domain.Duenio;
import com.backend.condominio.domain.Filial;

@Repository
public interface DuenioRepository extends JpaRepository<Duenio, Long>{
	
	@Procedure(name="guardarDuenio")
	void SP_INSERTAR_DUENIOS(long IDDUENION, String NOMBREN, String APE1N, String APE2N, long TELEFONON, String CORREON);
	
	@Procedure(name="editarDuenio")
	void SP_ACTUALIZAR_DUENIO(long IDDUENIOCUR, String NOMBREN, String APE1N, String APE2N, long TELEFONON, String CORREON);
	
	@Procedure(name="eliminarDuenio")
	void SP_BORRAR_DUENIO(long IDDUENIOCUR);
	
	
	@Query(value ="SELECT * FROM DUENIOS", nativeQuery = true)
	List<Duenio> Listar();
	
	@Procedure(name="mostrarPagos")
	List<String> SP_MOSTRAR_DATOS_PAGOS(long ID);
	
}
