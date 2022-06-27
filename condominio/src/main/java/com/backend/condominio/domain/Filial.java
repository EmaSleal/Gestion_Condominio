package com.backend.condominio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



import lombok.Data;

@Data
@Entity
@NamedStoredProcedureQuery(
	    name = "guardarFilial", 
	    procedureName = "SP_INSERTAR_FILIALES", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDN"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "ID_DUENON"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "DESCRIPCIONN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "editarFilal", 
	    procedureName = "SP_ACTUALIZAR_FILIALES", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDN"), 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "ID_DUENON"),
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "DESCRIPCIONN")
	    }
	)
@NamedStoredProcedureQuery(
	    name = "eliminarFilial", 
	    procedureName = "SP_BORRAR_FILIALES", 
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "IDN"), 
	        
	    }
	)
@Table(name="FILIALES")
public class Filial implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFilial;
	
	@Column(name="ID_DUENIO")
	@NotEmpty
	private int idDuenio;
	
	@Column(name="DESCRIPCION")
	@NotEmpty
	private String descripcion;

	public long getId() {
		return idFilial;
	}

	public void setId(long id) {
		this.idFilial = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(long idFilial) {
		this.idFilial = idFilial;
	}

	public int getIdDuenio() {
		return idDuenio;
	}

	public void setIdDuenio(int idDuenio) {
		this.idDuenio = idDuenio;
	}
	
}
