package com.backend.condominio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.backend.condominio.domain.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>{
	
	@Procedure(name="guardarFilial")
	void SP_INSERTAR_FILIALES(long IDN,int ID_DUENON, String DESCRIPCIONN);
	
	@Procedure(name="editarFilal")
	void SP_ACTUALIZAR_FILIALES(long IDN,int ID_DUENON, String DESCRIPCIONN);
	
	@Procedure(name="eliminarFilial")
	void SP_BORRAR_FILIALES(long IDN);
	
	@Query(value ="SELECT * FROM FILIALES", nativeQuery = true)
	List<Filial> Listar();
	
	
	
}
